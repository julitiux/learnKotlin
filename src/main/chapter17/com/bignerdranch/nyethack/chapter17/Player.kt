package com.bignerdranch.nyethack.chapter17

import java.io.File

class Player(
  _name: String,
  override var healtPoints: Int = 100,
  var isBlessed: Boolean,
  private var isImmortal: Boolean
) : Fightable {

  override val diceCount = 3
  override val diceSides = 6

  override fun attack(opponent: Fightable): Int {
    val damageDealt = if (isBlessed) {
      damageRoll * 2
    } else {
      damageRoll
    }
    opponent.healtPoints -= damageDealt
    return damageDealt
  }

  var name = _name
    get() = "${field.capitalize()} of $hometown"
    private set(value) {
      field = value.trim()
    }

  val hometown = selectHometown()
  var currentPosition = Coordinate(0, 0)

  private fun selectHometown() = File("data/towns.txt")
    .readText()
    .split("\n")
    .shuffled()
    .first()

  init {
    require(healtPoints > 0, { "healthPoints must be greater than zero" })
    require(name.isNotBlank(), { "Player must have a name" })
  }

  constructor(name: String) : this(name, isBlessed = true, isImmortal = false) {
    if (name.lowercase() == "kar") healtPoints = 40
  }

  fun auraColor(): String {
    val auraVisible = isBlessed && healtPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
  }

  fun formatHealthStatus() =
    when (healtPoints) {
      100 -> "is in a excelente condition !"
      in 90..99 -> "has a few scratches."
      in 75..89 -> if (isBlessed)
        "has some  minor wounds but is healing quite quickly!"
      else
        "has some minor wounds."

      in 15..74 -> "looks pretty hurt."
      else -> "is an awful condition!"
    }

  fun castFireball(numFireballs: Int = 2) =
    println("A glass of Fireball springs into existence. (x$numFireballs)")
}