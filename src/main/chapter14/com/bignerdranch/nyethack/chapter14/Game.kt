package com.bignerdranch.nyethack.chapter14

fun main(args: Array<String>) {

  val player = Player("Julito")
  println(player.name + "TheBrave")
  player.castFireball()

  // Aura
  val auraColor = player.auraColor()
  // Player Status
  printPlayerStatus(player)
  // Aura
  player.auraColor()
}

private fun printPlayerStatus(player: Player) {
  println(
    "(Aura: ${player.auraColor()})" +
      "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
  )
  println("${player.name} ${player.formatHealthStatus()}")
}

private fun shoudlBeAString(): String {
  TODO()
  println("unreachable")
}