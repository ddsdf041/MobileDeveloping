package com.example.myapplication

class SecondExercise {
//    Задание 2 – Условные конструкции. Решить двумя способами – с помощью обычного if,
//    с помощью конструкции when
//    12.	Даны три числа. Написать "yes", если можно взять какие-то два из них и в сумме получить третье

    fun exercise(){
        println("ВТОРОЕ ЗАДАНИЕ")
        println("=".repeat(10))

        println("Введите три(3) случайных числа")
        print("Первое число: ")
        val first: Float = readln().toFloat()
        print("Второе число: ")
        val second: Float = readln().toFloat()
        print("Третье число: ")
        val third: Float = readln().toFloat()

        //if
        if (first + second == third || first + third == second || second + third == first) {
            println("yes")
        }

        //when
        when(first){
            second + third -> println("yes")
        }
        when(second){
            first + third -> println("yes")
        }
        when(third){
            first + second -> println("yes")
        }
    }
}