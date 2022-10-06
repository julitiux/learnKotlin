import kotlin.math.roundToInt

const val TAVERN_NAME_4 = "Taernyl's Folly"

var playerGold4 = 10
var playerSilver4 = 10
val patronList = listOf("Eli", "Mordoc", "Sophie")

fun main(args: Array<String>) {
  placeOrder("shabdy,Dragon's Breath,5.91")
  println(patronList[0])
}

fun performPurchase4(price: Double) {
  displayBalance()
  val totalPurse = playerGold4 + (playerSilver4 / 100.0)
  println("Total purse: $totalPurse")
  println("Purchasing item for $price")

  val remainingBalance = totalPurse - price
  println("Remaining balance: ${"%.2f".format(remainingBalance)}")

  val remainingGold = remainingBalance.toInt()
  val remainigSilver = (remainingBalance % 1 * 100).roundToInt()
  playerGold4 = remainingGold
  playerSilver4 = remainigSilver
  displayBalance()
}

private fun displayBalance() {
  println("Player's purse balance: Gold: $playerGold4 , Silver: $playerSilver4")
}

private fun placeOrder(menuData: String) {
  val indexOfApostrophe = TAVERN_NAME_4.indexOf('\'')
  val tavernMaster = TAVERN_NAME_4.substring(0 until indexOfApostrophe)
  println("Madrigal speaks with $tavernMaster about their order.")

  val (type, name, price) = menuData.split(',')
  val message = "Madrigal buys a $name ($type) for $price"
  println(message)

  performPurchase4(price.toDouble())

  val phrase = if (name == "Dragon's Breath") {
    "Madrigal exclaims: ${toDragonSpeak("Ah, delicius $name!")}"
  } else {
    "Madrigal says: thanks for the $name."
  }
  println(phrase)

}

private fun toDragonSpeak(phrase: String) =
  phrase.replace(Regex("[aeiou]]")) {
    when (it.value) {
      "a" -> "4"
      "e" -> "3"
      "i" -> "1"
      "o" -> "0"
      "u" -> "|_|"
      else -> it.value
    }
  }