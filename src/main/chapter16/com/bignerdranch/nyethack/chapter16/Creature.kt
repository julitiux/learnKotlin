package com.bignerdranch.nyethack.chapter16

import kotlin.random.Random

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