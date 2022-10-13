import java.io.File

fun main() {
  menuPrint()
}

private fun menuPrint() {
  val menuList = File("data/tavern-menu-items.txt")
    .readText()
    .split("\n")
  menuList.forEach { menu ->
    var (type, subMenu, price) = menu.split(",")
    var subMenuMore = subMenu.capitalize().padEnd((30 - price.length), '.') + price
    println(subMenuMore)
  }
}