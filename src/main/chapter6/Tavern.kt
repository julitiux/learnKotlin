fun main() {
  var beverage = readLine()

  if (beverage != null) {
    beverage = beverage.capitalize()
  } else {
    println("I cant do that without crashing - beverage was null")
  }

  println(beverage)
}