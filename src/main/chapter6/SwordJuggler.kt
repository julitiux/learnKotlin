fun main() {
  var swordsJuggLing: Int? = null
  val isJuggLingProficent = (1..3).shuffled().last() == 3
  if (isJuggLingProficent) {
    swordsJuggLing = 2
  }

  try {
    proficiencyCheck(swordsJuggLing)
    swordsJuggLing = swordsJuggLing!!.plus(1)
  } catch (e: Exception) {
    println(e)
  }

  println("You juggle $swordsJuggLing words")
}

fun proficiencyCheck(swordJuggling: Int?) {
  swordJuggling ?: throw UnskilledSwordJugglerException()
}

class UnskilledSwordJugglerException() : IllegalStateException("Player cannot juggle swords")