
const val MAX_EXPERIENCE: Int = 5000

fun main(args: Array<String>) {

  val playerName = "Estragon"
  var experiencePoints = 5
  experiencePoints += 5
  println(experiencePoints)
  println(playerName)

  println ("Do you need to stable a steed?")
  val hasSteed = false
  if(hasSteed)
    println("yes")
  else
    println("No, I have no steed. But I do have 50 gold pieces, and I would like a drink.")
  println("Excellent!")
  println("I have mead, wine, and LaCroix. What will you have?")

}