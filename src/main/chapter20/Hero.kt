@file:JvmName("Hero")

fun main() {
  val adversary = Jhava()
  println(adversary.utterGreenting())

  val friendshipLevel = adversary.determineFriendshipLevel()
  println(friendshipLevel?.toLowerCase() ?: "It's complicated")

  val adversaryHitPoints: Int = adversary.hitPoints
  println(adversaryHitPoints.dec())
  println(adversaryHitPoints.javaClass)

  adversary.greeting = "Hello, Hero"
  println(adversary.utterGreenting())

  adversary.offerFood()
}

fun makeProclamation() = "Greating, beast!"

@JvmOverloads
fun handOverFood(leftHand: String = "berries", rightHand: String = "beef"){
  println("Mmm... you hand over some delicious $leftHand and $rightHand.")
}