package com.bignerdranch.nyethack.chapter15

fun main(args: Array<String>) {

  Game.play()

}

object Game {
  private val player = Player("Julito")
  private var currentRoom: Room = TownSquare()

  private var worldMap = listOf(
    listOf(currentRoom, Room("Tavern"), Room("Back Room")),
    listOf(Room("Long Corridor"), Room("Generic Room"))
  )

  private fun move(directionInput: String) {
    try {
      val direction = Direction.valueOf(directionInput.toUpperCase())
      val newPosition = direction.updateCoordinate(player.currentPosition)
      if (!newPosition.isInBounds) {
        throw IllegalStateException("$direction us out of bounds.")
      }

      val newRoom = worldMap[newPosition.y][newPosition.x]
      player.currentPosition = newPosition
      currentRoom = newRoom
      println ("OK, you move $direction to the ${newRoom.name}. \n${newRoom.load()}")
    } catch (e: Exception) {
      println("Invalid direction: $directionInput")
    }
  }

  init {
    println("Welcome, adventurer")
  }

  fun play() {
    while (true) {
      println(currentRoom.description())
      println(currentRoom.load())

      //Player status
      printPlayerStatus(player)
      print("> Enter your command: ")
      GameInput(readLine()).processCommand()
    }

  }

  private fun printPlayerStatus(player: Player) {
    println(
      "(Aura: ${player.auraColor()})" +
        "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
    )
    println("${player.name} ${player.formatHealthStatus()}")
  }

  private class GameInput(arg: String?) {
    private val input = arg ?: ""
    val command = input.split(" ")[0]
    val argument = input.split(" ").getOrElse(1, { "" })

    fun processCommand() = when (command.toLowerCase()) {
      "move" -> move(argument)
      else -> commandNotFound()
    }

    private fun commandNotFound() = "I'm not quite sure whta you're trying to do!"
  }

}

private fun shoudlBeAString(): String {
  TODO()
  println("unreachable")
}