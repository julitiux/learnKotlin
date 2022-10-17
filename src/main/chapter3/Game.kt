// Chapter 3

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

  // com.bignerdranch.nyethack.Player Status
  println(
    "(Aura: $auraColor)" +
      "(Blessed: ${if (isBlessed) "YES" else "NO"})"
  )
  println("$name $healthStatus")


//  1 in 1..3
//  (1..3).toList()
//  1 in 3 downTo 1
//  1 in 1 until 3
//  3 in 1 until 3
//  2 in 1..3
//  2 !in 1..3
//  'x' in 'a'..'z'

}