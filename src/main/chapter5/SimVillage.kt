fun main() {

  val greetingFunction = { playerName: String, numBuildings: Int ->
    val currentYear = 2018
    println("Adding $numBuildings houses")
    "Welcome to SimVillage, $playerName! (copyright $currentYear)"
  }

  println(greetingFunction("Julito", 2))
  runSimulation("Julito", greetingFunction)

}

fun runSimulation(playerName: String, greetingFunction: (String, Int) -> String) {
  val numBuildings = (1..3).shuffled().last() //Randomly selects 1,2, or 3
  println(greetingFunction(playerName, numBuildings))
}