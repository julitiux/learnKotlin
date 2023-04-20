package com.bignerdranch.nyethack.chapter18

import java.util.*

interface Fightable {
  var healtPoints: Int
  val diceCount: Int
  val diceSides: Int
  val damageRoll: Int
    get() = (0 until diceCount).map {
      Random().nextInt(diceCount + 1)
    }.sum()

  fun attack(opponent: Fightable): Int
}

abstract class Monster(
  val name: String,
  val description: String,
  override var healtPoints: Int
) : Fightable {

  override fun attack(opponent: Fightable): Int {
    val damageDealt = damageRoll
    opponent.healtPoints -= damageDealt
    return damageDealt
  }
}

class Goblin(
  name: String = "Goblin",
  description: String = "A nasty-looking goblin",
  healtPoints: Int = 30
) : Monster(name, description, healtPoints) {
  override val diceCount: Int = 2
  override val diceSides: Int = 8
}