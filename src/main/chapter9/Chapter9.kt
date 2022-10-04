import java.io.File

fun main() {

//  Apply
//  Here is an example of configuring a file instance without apply
//  val menuFile = File("menu-file.txt")
//  menuFile.setReadable(true)
//  menuFile.setWritable(true)
//  menuFile.setExecutable(false)

//  Using apply, the same configuration can be achieved with less repetition:
  val menuFile = File("menu-file.txt").apply {
    setReadable(true)
    setWritable(true)
    setExecutable(false)
  }


//  Let
//  let scopes a variable to the lambda provided and makes the keyword it
//  val firstElement = listOf(1, 2, 3).first()
//  val firstItemSquared = firstElement * firstElement

//  Using let
  val firstItemSquared = listOf(1, 2, 3).first().let { it * it }

  //  let can be combined to work on a nullable type
  fun formatGreeting(viGuest: String?): String {
    return viGuest.let {
      "Welcome, $it. Please go straight back - your table is ready."
    } ?: "Welcum to the tavern. You'llbe seated soon."
  }


  //  run
//  run returns the lambda result
  fun nameIsLong(name: String) = name.length >= 20

  "Julito".run(::nameIsLong)
  "Polarcubis, Supreme Master of NyetHack".run(::nameIsLong)

  //  or
  fun playerCreateMessage(nameTooLong: Boolean): String {
    return if (nameTooLong) {
      "Name is too long. Please choose another name."
    } else {
      "Welcome, adventurer"
    }
  }

//  final example of run
  "Polarcubis, Supreme Master of NyetHack"
    .run(::nameIsLong)
    .run(::playerCreateMessage)
    .run(::println)

//  There is a second flavor of run
  val healthPoints: Int = 50
  val status = run {
    if (healthPoints == 100) "perfect health" else "has injuries"
  }

}