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


//  with
//  with is a variant of run. It behaves identically, but it uses a different calling convention. Unlike the standard functions you have seen so far, with requires its argument to be accepted as the first parameter rather than calling the standard function on a receiver type

  val nameTooLong = with("Polarcubis, Supreme Master of NyetHack"){
    length >= 20
  }


//  also
//  The also function works very similarly to the let function. Just like let, also passes the receiver you call it on as an argument to a lambda you provide. But there is one major difference between let and also: also returns the receiver, rather than the result of the lambda.

  var fileContents: List<String>
  File("file.txt")
    .also { println(it.name) }
    .also { fileContents = it.readLines() }


//  takeIf
//  without takeIf, thos would be more verbose
  var file = File("myFile.txt")
  var fileContentz = if (file.canRead() && file.canWrite()){
    file.readText()
  } else {
    null
  }

//  with takeIf
//  takeIf works a bit differently than the other standard functions: It evaluates a condition provided in a lambda, called a predicate, that returns either true or false depending on the conditions defined. If the condition evaluates as true, the receiver is returned from takeIf. If the condition is false, null is returned instead.
  val fileContentsz = File("myFile.txt")
    .takeIf { it.canRead() && it.canWrite() }
    ?.readText()
  
}