fun main() {
  var swordsJuggLing : Int? = null
  val isJuggLingProficent = (1..3).shuffled().last() == 3
  if(isJuggLingProficent){
    swordsJuggLing = 2
  }

  swordsJuggLing = swordsJuggLing!!.plus(1)

  println("You juggle $swordsJuggLing words")

}