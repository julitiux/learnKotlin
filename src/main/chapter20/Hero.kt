fun main() {
  val adversary = Jhava()
  println(adversary.utterGreenting())

  val friendshipLevel = adversary.determineFriendshipLevel()
  println(friendshipLevel?.toLowerCase())
}