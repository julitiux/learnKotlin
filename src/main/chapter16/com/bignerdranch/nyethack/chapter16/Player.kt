package com.bignerdranch.nyethack.chapter16

import java.io.File

class Player(
  _name: String,
  override var healthPoints: Int = 100,
  var isBlessed: Boolean,
  private var isImmortal: Boolean
): Fightable {

  override var healtPoints: Int
    get() = TODO("Not yet implemented")
    set(value) {}
  override val diceCount: Int
    get() = TODO("Not yet implemented")
  override val diceSides: Int
    get() = TODO("Not yet implemented")
  override val damageRoll: Int
    get() = TODO("Not yet implemented")

  override fun attack(opponent: Fightable): Int {
    TODO("Not yet implemented")
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
    require(healthPoints > 0, { "healthPoints must be greater than zero" })
    require(name.isNotBlank(), { "Player must have a name" })
  }

  constructor(name: String) : this(name, isBlessed = true, isImmortal = false) {
    if (name.lowercase() == "kar") healthPoints = 40
  }

  fun auraColor(): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
  }

  fun formatHealthStatus() =
    when (healthPoints) {
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