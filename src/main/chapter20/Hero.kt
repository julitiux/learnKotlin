fun main() {
  val adversary = Jhava()
  println(adversary.utterGreenting())

  val friendshipLevel = adversary.determineFriendshipLevel()
  println(friendshipLevel?.toLowerCase() ?: "It's complicated")

  val adversaryHiyPoints: Int = adversary.hitPoints
}