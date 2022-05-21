
// Chapter 4

fun main(args: Array<String>) {

  val name = "Madrigal"
  var healthPoints = 89
  val isBlessed = true
  val isInmortal = false

  //Aura
  val auraVisible = isBlessed && healthPoints > 50 || isInmortal
  val auraColor = if (auraVisible) "GREEN" else "NONE"

  println(auraColor)

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

}