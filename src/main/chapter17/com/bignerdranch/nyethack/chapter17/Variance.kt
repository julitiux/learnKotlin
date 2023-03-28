package com.bignerdranch.nyethack.chapter17

class Barrel<T>(itam: T)

fun main(args: Array<String>) {
  var fedoraBarrel: Barrel<Fedora> = Barrel(Fedora("a generic-looking fedora", 15))
  var lootBarrel: Barrel<Loot> = Barrel(Coin(15))

  lootBarrel = fedoraBarrel
  lootBarrel.item = Coin(15)
}