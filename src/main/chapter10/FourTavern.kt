import java.io.File
import kotlin.math.roundToInt

const val TAVERN_NAME_4 = "Taernyl's Folly"

var playerGold4 = 10
var playerSilver4 = 10
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")

val menuList = File("data/tavern-menu-items.txt")
  .readText()
  .split("\n")

fun main(args: Array<String>) {

  if (patronList.contains("Eli")) {
    println("The tavern master says: Eli's in the back playing cards.")
  } else {
    println("The tavern master says: Eli isn't here.")
  }

  if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
    println("the tavern master says: Yea, they're seated by the stew kettle.")
  } else {
    println("the tavern master says: Nay, they departed hours ago.")
  }

  patronList.forEachIndexed { index, patron ->
    println("Good eening, $patron - you're ${index + 1} in Line.")
    placeOrder(patron, "shabdy,Dragon's Breath,5.91")
  }

  menuList.forEachIndexed { index, data ->
    println("$index : $data")
  }

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

private fun placeOrder(patronName: String, menuData: String) {
  val indexOfApostrophe = TAVERN_NAME_4.indexOf('\'')
  val tavernMaster = TAVERN_NAME_4.substring(0 until indexOfApostrophe)
  println("$patronName speaks with $tavernMaster about their order.")

  val (type, name, price) = menuData.split(',')
  val message = "$patronName buys a $name ($type) for $price."
  println(message)

//  performPurchase4(price.toDouble())

  val phrase = if (name == "Dragon's Breath") {
    "$patronName exclaims: ${toDragonSpeak("Ah, delicius $name!")}"
  } else {
    "$patronName says: thanks for the $name."
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