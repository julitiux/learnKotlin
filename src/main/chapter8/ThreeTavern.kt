import kotlin.math.roundToInt

const val TAVERN_NAME_3 = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10

fun main(args: Array<String>) {
  placeOrder("shabdy,Dragon's Breath,5.91")
}

fun performPurchase(price: Double) {
  displayBalance()
  val totalPurse = playerGold + (playerSilver / 100.0)
  println("Total purse: $totalPurse")
  println("Purchasing item for $price")

  val remainingBalance = totalPurse - price
  println("Remaining balance: ${"%.2f".format(remainingBalance)}")

  val remainingGold = remainingBalance.toInt()
  val remainigSilver = (remainingBalance % 1 * 100).roundToInt()
  playerGold = remainingGold
  playerSilver = remainigSilver
  displayBalance()
}

private fun displayBalance() {
  println("com.bignerdranch.nyethack.Player's purse balance: Gold: $playerGold , Silver: $playerSilver")
}

private fun placeOrder(menuData: String) {
  val indexOfApostrophe = TAVERN_NAME_3.indexOf('\'')
  val tavernMaster = TAVERN_NAME_3.substring(0 until indexOfApostrophe)
  println("Madrigal speaks with $tavernMaster about their order.")

  val (type, name, price) = menuData.split(',')
  val message = "Madrigal buys a $name ($type) for $price"
  println(message)

  performPurchase(price.toDouble())

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