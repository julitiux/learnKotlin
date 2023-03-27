package com.bignerdranch.nyethack.chapter17

class LootBox<T>(item: T) {
  var open = false
  private var loot: T = item

  fun fetchH(): T?{
    return loot.takeIf { open }
  }
}

class Fedora(val name: String, val value: Int)
class Coin(val value: Int)

fun main(args: Array<String>){
  var lootBoxOne: LootBox<Fedora> = LootBox(Fedora("a generic-looking fedora", 15))
  var lootBoxTwo: LootBox<Coin> = LootBox(Coin(15))
}