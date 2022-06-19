fun main() {

  val greetingFunction: () -> String = {
    val currentYear = 2018
    "Welcome to SimVillage, Mayor! (copyright $currentYear)"
  }

  println(greetingFunction())

}