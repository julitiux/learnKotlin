package com.bignerdranch.nyethack.chapter14

fun main(args: Array<String>) {
  
  println(currentRoom.description())
  println(currentRoom.load())

  // Aura
  val auraColor = player.auraColor()
  // Player Status
  printPlayerStatus(player)
  // Aura
  player.auraColor()
}

object Game {

  private val player = Player("Julito")
  private var currentRoom: Room = TownSquare()

  init {
    println("Welcome, adventurer")
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