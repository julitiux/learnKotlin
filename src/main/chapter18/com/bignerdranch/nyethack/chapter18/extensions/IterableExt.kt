package com.bignerdranch.nyethack.chapter18.extensions

fun <T> Iterable<T>.random(): T = this.shuffled().first()