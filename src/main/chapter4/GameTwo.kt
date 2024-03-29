// Chapter 4

fun main(args: Array<String>) {

  val name = "Madrigal"
  var healthPoints = 89
  val isBlessed = true
  val isInmortal = false

  //Aura
  val auraColor = auraColor(isBlessed, healthPoints, isInmortal)
  //HealthStatus
  val healthStatus = formatHealthStatus(healthPoints, isBlessed)
  // com.bignerdranch.nyethack.Player Status
  printPlayerStatus(auraColor, isBlessed, healthStatus, name)
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

  castFireball()

}

private fun printPlayerStatus(auraColor: String, isBlessed: Boolean, healthStatus: String, name: String) {
  println(
    "(Aura: $auraColor)" +
      "(Blessed: ${if (isBlessed) "YES" else "NO"})"
  )
  println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isInmortal: Boolean): String {
  val auraVisible = isBlessed && healthPoints > 50 || isInmortal
  val auraColor = if (auraVisible) "GREEN" else "NONE"
  return auraColor
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
  when (healthPoints) {
    100 -> "is in a excelente condition !"
    in 90..99 -> "has a few scratches."
    in 75..89 -> if (isBlessed)
      "has some  minor wounds but is healing quite quickly!"
    else
      "has some minor wounds."
    in 15..74 -> "looks pretty hurt."
    else -> "is an awful condition!"
  }

private fun castFireball(numFireballs: Int = 2) =
  println("A glass of fireball springs into existence. (x$numFireballs)")

private fun shoudlBeAString(): String{
  TODO()
  println("unreachable")
}