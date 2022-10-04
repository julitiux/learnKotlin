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

  val firstElement = listOf(1, 2, 3).first()
  val firstItemSquared = firstElement * firstElement

}