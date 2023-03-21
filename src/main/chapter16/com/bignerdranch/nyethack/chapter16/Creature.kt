package com.bignerdranch.nyethack.chapter16

interface Fightable {
  var healtPoints: Int
  val diceCount: Int
  val diceSides: Int
  val damageRoll: Int

  fun attack(opponent: Fightable): Int
}