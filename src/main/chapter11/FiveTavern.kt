import java.io.File
import kotlin.math.roundToInt

const val TAVERN_NAME_5 = "Taernyl's Folly"

var playerGold5 = 10
var playerSilver5 = 10
val patronList5 = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName5 = listOf("Iron foot", "Fernsworth", "Baggins")
val uniquePatrons5 = mutableSetOf<String>()
val menuList5 = File("data/tavern-menu-items.txt")
  .readText()
  .split("\n")

fun main(args: Array<String>) {

  if (patronList5.contains("Eli")) {
    println("The tavern master says: Eli's in the back playing cards.")
  } else {
    println("The tavern master says: Eli isn't here.")
  }

  if (patronList5.containsAll(listOf("Sophie", "Mordoc"))) {
    println("the tavern master says: Yea, they're seated by the stew kettle.")
  } else {
    println("the tavern master says: Nay, they departed hours ago.")
  }

  (0..9).forEach {
    val first = patronList5.shuffled().first()
    val last = lastName5.shuffled().first()
    val name = "$first $last"
    uniquePatrons5 += name
  }

  println(uniquePatrons5)

  var orderCount = 0
  while (orderCount <= 9) {
    placeOrder5(uniquePatrons5.shuffled().first(), menuList5.shuffled().first())
    orderCount++
  }

}

fun performPurchase5(price: Double) {
  displayBalance()
  val totalPurse = playerGold5 + (playerSilver5 / 100.0)
  println("Total purse: $totalPurse")
  println("Purchasing item for $price")

  val remainingBalance = totalPurse - price
  println("Remaining balance: ${"%.2f".format(remainingBalance)}")

  val remainingGold = remainingBalance.toInt()
  val remainigSilver = (remainingBalance % 1 * 100).roundToInt()
  playerGold5 = remainingGold
  playerSilver5 = remainigSilver
  displayBalance()
}

private fun displayBalance() {
  println("Player's purse balance: Gold: $playerGold5 , Silver: $playerSilver5")
}

private fun placeOrder5(patronName: String, menuData: String) {
  val indexOfApostrophe = TAVERN_NAME_5.indexOf('\'')
  val tavernMaster = TAVERN_NAME_5.substring(0 until indexOfApostrophe)
  println("$patronName speaks with $tavernMaster about their order.")

  val (type, name, price) = menuData.split(',')
  val message = "$patronName buys a $name ($type) for $price."
  println(message)

//  performPurchase5(price.toDouble())

  val phrase = if (name == "Dragon's Breath") {
    "$patronName exclaims: ${toDragonSpeak5("Ah, delicius $name!")}"
  } else {
    "$patronName says: thanks for the $name."
  }
  println(phrase)

}

private fun toDragonSpeak5(phrase: String) =
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