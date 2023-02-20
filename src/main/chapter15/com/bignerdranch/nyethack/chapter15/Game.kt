package com.bignerdranch.nyethack.chapter15

fun main(args: Array<String>) {

  Game.play()

}

object Game {
  private val player = Player("Julito")
  private var currentRoom: Room = TownSquare()

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
      println("Last command: ${readLine()}")
    }

  }

  private fun printPlayerStatus(player: Player) {
    println(
      "(Aura: ${player.auraColor()})" +
        "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
    )
    println("${player.name} ${player.formatHealthStatus()}")
  }

}

private fun shoudlBeAString(): String {
  TODO()
  println("unreachable")
}