fun main() {
  var beverage = readLine()?.let {
    if (it.isNotBlank())
      it.capitalize()
    else {
      "Butter Ale"
    }
  }
//  beverage = null
  println(beverage)
}