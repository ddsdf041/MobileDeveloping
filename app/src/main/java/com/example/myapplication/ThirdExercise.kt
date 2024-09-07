package com.example.myapplication

class ThirdExercise {
//    Задание 3 – Циклы. Вид цикла выбрать на своё усмотрение
//    12.	Найдите количество целых чисел от a до b включительно, которые делятся на 12.

    fun exercise(){
        println("ТРЕТЬЕ ЗАДАНИЕ")
        println("=".repeat(10))

        var count: Int = 0

        println("Введите числа a и b")
        print("a: ")
        val a = readln().toInt()
        print("b: ")
        val b = readln().toInt()

        for (x in a..b){
            if (x % 12 == 0){
                count++
            }
        }
        println("Кол-во целых чисел в диапазоне от $a до $b, которые делятся на 12, равно $count")
    }
}