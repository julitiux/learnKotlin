// Chapter 3

fun main(args: Array<String>) {

  val name = "Madrigal"
  var healthPoints = 89
  val isBlessed = true
  val isInmortal = false

  //Aura
  val auraVisible = isBlessed && healthPoints > 50 || isInmortal
  if (auraVisible)
    println("GREEN")
  else
    println("NONE")

  if (healthPoints == 100)
    println(name + " is in a excelente condition !")
  else if (healthPoints >= 90)
    println(name + " has a few scratches.")
  else if (healthPoints >= 75)
    if (isBlessed)
      println(name + " has some  minor wounds but is healing quite quickly!")
    else
      println(name + " has some minor wounds.")
  else if (healthPoints >= 15)
    println(name + " looks pretty hurt.")
  else
    println(name + " is an awful condition!")

}