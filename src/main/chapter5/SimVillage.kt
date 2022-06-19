fun main() {
  runSimulation()
}

fun runSimulation() {
  val greetingFunction = configureGreetingFunction()
  println(greetingFunction("Julito"))
  println(greetingFunction("Julito"))
  println(greetingFunction("Julito"))
}

fun configureGreetingFunction(): (String) -> String {
  val structureType = "hospitals"
  var numBuildings = 5
  return { playerName: String ->
    val currentYear = 2018
    numBuildings += 1
    println("Adding $numBuildings $structureType")
    "Welcum to SimVillage, $playerName! (copyright $currentYear)"
  }
}