fun main(args: Array<String>) {

  val player = Player()
  player.name = "estragon"
  println(player.name + "TheBrave")
  player.castFireball()

  //Aura
  val auraColor = auraColor(isBlessed, healthPoints, isInmortal)
  //HealthStatus
  val healthStatus = formatHealthStatus(healthPoints, isBlessed)
  // Player Status
  printPlayerStatus(auraColor, isBlessed, healthStatus, player.name)
  printPlayerStatus("NONE", true, "Mandrigal", healthStatus)
  printPlayerStatus(
    auraColor = "NONE",
    isBlessed = true,
    name = "Mandrigal",
    healthStatus = healthStatus
  )
  printPlayerStatus(
    isBlessed = true,
    auraColor = "NONE",
    healthStatus = healthStatus,
    name = "Mandrigal"
  )

}

private fun printPlayerStatus(auraColor: String, isBlessed: Boolean, healthStatus: String, name: String) {
  println(
    "(Aura: $auraColor)" +
      "(Blessed: ${if (isBlessed) "YES" else "NO"})"
  )
  println("$name $healthStatus")
}

private fun shoudlBeAString(): String{
  TODO()
  println("unreachable")
}