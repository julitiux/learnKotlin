// Chapter 3

fun main(args: Array<String>) {

  val name = "Madrigal"
  var healthPoints = 89
  val isBlessed = true
  val isInmortal = false

  //Aura
  val auraVisible = isBlessed && healthPoints > 50 || isInmortal
  val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()
  val auraColor = when (karma) {
    in 0..5 -> "RED"
    in 6..10 -> "ORANGE"
    in 11..15 -> "PURPLE"
    in 16..20 -> "GREEN"
    else -> "OTHER"
  }

  val healthStatus = when (healthPoints) {
    100 -> "is in a excelente condition !"
    in 90..99 -> "has a few scratches."
    in 75..89 -> if (isBlessed)
      "has some  minor wounds but is healing quite quickly!"
    else
      "has some minor wounds."
    in 15..74 -> "looks pretty hurt."
    else -> "is an awful condition!"
  }

  // Player Status
  println(
    "(Aura: $auraColor)" +
      "(Blessed: ${if (isBlessed) "YES" else "NO"})"
  )
  println("$name $healthStatus")

  println("(HP: $healthPoints)(Aura: $auraColor) -> $healthStatus")

}