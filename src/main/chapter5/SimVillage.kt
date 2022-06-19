fun main() {

  runSimulation("Julito", ::printConstructionCost) { playerName, numBuildings ->
    val currentYear = 2018
    println("Adding $numBuildings houses")
    "Welcome to SimVillage, $playerName! (copyright $currentYear)"
  }

}

inline fun runSimulation(playerName: String, costPrinter: (Int) -> Unit, greetingFunction: (String, Int) -> String) {
  val numBuildings = (1..3).shuffled().last() //Randomly selects 1,2, or 3
  costPrinter(numBuildings)
  println(greetingFunction(playerName, numBuildings))
}

fun printConstructionCost(numBuilding: Int) {
  val cost = 500
  println("contruction cost: ${cost * numBuilding}")
}