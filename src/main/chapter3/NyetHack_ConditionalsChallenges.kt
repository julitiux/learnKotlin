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

  // com.bignerdranch.nyethack.Player Status
  val formatString = "(HP)(A)(B) -> (H)"
  val formatSpecifiers = "HP|H|A|B".toRegex()

  var result = StringBuffer()

  var i = 0
  formatSpecifiers.findAll(formatString).forEach { match ->
    result.append(formatString.substring(i,match.range.start))
    println ("**************")
    println (match.range.start)
    println (formatString.substring(i,match.range.start))
    println (match.value)
    println ("**************")
    result.append(when (match.value) {
      "H" -> "$name $healthStatus"
      "HP" -> "HP: $healthPoints"
      "A" -> "A: $auraColor"
      "B" -> "B: $isBlessed"
      else -> "?"
    })
    i = match.range.last+1
  }
  result.append(formatString.substring(i))
  println(result)
}