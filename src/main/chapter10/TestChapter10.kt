fun main() {
  val x = listOf(mutableListOf(1, 2, 3))
  val y = listOf(mutableListOf(1, 2, 3))
  
  x[0].add(4)

  if (x == y)
    println(x == y)
}