package com.bignerdranch.nyethack.chapter16

import kotlin.system.exitProcess

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

  private fun fight() = currentRoom.monster?.let {
    while (player.healtPoints > 0 && it.healtPoints > 0){
      slay(it)
      Thread.sleep(1000)
    }
    "Combat complete"
  } ?: "There's nothing here to fight"

  private fun slay(monster: Monster){
    println("${monster.name} did ${monster.attack(player)} damage")
    println("${player.name} did ${player.attack(monster)} damage")

    if(player.healtPoints <= 0){
      println(">>>> You have been defeated! Thnaks for playing. <<<<")
      exitProcess(0)
    }

    if(monster.healtPoints <= 0){
      println(">>>> ${monster.name} has been defeated! <<<<")
      currentRoom.monster = null
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
      "fight" -> fight()
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