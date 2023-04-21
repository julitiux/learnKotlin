package com.bignerdranch.nyethack.chapter18

fun String.addEnthusiam(amount: Int = 1) = this + "!".repeat(amount)

fun <T> T.easyPrint(): T {
  println(this)
  return this
}

fun main(args: Array<String>) {
  "Mandrigal has left the building".easyPrint().addEnthusiam().easyPrint()
  42.easyPrint()
}