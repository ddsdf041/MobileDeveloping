package com.example.myapplication

import androidx.compose.runtime.internal.illegalDecoyCallException

class FourthExercise {
//    Задание 4. Массивы и коллекции
//    12.	В массиве строк (список фамилий) определите самую длинную фамилию.

    fun exercise(){
        println("ЧЕТВЁРТОЕ ЗАДАНИЕ")
        println("=".repeat(10))

        var word = ""
        var maxLength = 0
        val surnames = arrayOf("Лёвина", "Перевезенцева", "Насонова", "Синяев")

        for (surname in surnames){
            if (surname.length > maxLength){
                maxLength = surname.length
                word = surname
            }
        }
        println("Самая длинная фамилия: $word")
    }
}