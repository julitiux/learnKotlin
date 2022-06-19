fun main() {

  runSimulation("Julito") { playerName, numBuildings ->
    val currentYear = 2018
    println("Adding $numBuildings houses")
    "Welcome to SimVillage, $playerName! (copyright $currentYear)"
  }

}

inline fun runSimulation(playerName: String, greetingFunction: (String, Int) -> String) {
  val numBuildings = (1..3).shuffled().last() //Randomly selects 1,2, or 3
  println(greetingFunction(playerName, numBuildings))
}