import java.io.File

fun main() {

//  Apply
  val menuFile = File("menu-file.txt")
  menuFile.setReadable(true)
  menuFile.setWritable(true)
  menuFile.setExecutable(false)

}