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
}