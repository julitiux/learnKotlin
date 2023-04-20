package com.bignerdranch.nyethack.chapter18

fun String.addEnthusiam(amount: Int = 1) = this + "!".repeat(amount)

fun main(args: Array<String>) {
  println("Mandrigal has left the building".addEnthusiam())
}