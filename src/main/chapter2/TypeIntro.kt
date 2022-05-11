fun main(args: Array<String>) {
  val playerName: String = "Estragon"
  playerName = "Madrigal" // Error:(3, 5) Kotlin: Val cannot be reassigned
  var experiencePoints :Int = 5
  experiencePoints += 5
  println(experiencePoints)
  println(playerName)
}