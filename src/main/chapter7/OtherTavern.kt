const val TAVERN_NAME = "Taernyl's Folly"

fun main(args: Array<String>) {
  placeOrder("shabdy, Dragon's Breath, 5.91")
}

private fun placeOrder(manuData: String) {
  val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
  val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
  println("Madrigal speaks with $tavernMaster about their order.")
}