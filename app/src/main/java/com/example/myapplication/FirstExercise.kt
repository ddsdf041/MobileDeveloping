package com.example.myapplication

class FirstExercise {
//    Задание 1 – Вычисление.
//    12.	Пользователь вводит количество недель, месяцев, лет и получает количество дней за это время.
//    Считать, что в месяце 30 дней.

    fun exercise(){
        println("ПЕРВОЕ ЗАДАНИЕ")
        println("=".repeat(10))

        val daysInTheWeek = 7
        val daysInTheMonth = 30
        val daysInTheYear = 365

        println("За какой промежуток времени посчитать дни?\n1 - Недели \n2 - Месяцы\n3 - Года\n")
        val answer= readln()

        when(answer){
            "1" -> {
                print("Введите кол-во недель: ")
                val weeks = readln().toInt()

                val result = weeks * daysInTheWeek

                println("Дней в $weeks неделе(-ях): $result")
            }
            "2" -> {
                print("Введите кол-во месяцев: ")
                val months = readln().toInt()

                val result = months * daysInTheMonth

                println("Дней в $months месяце(-ях): $result")
            }
            "3" -> {
                print("Введите кол-во лет: ")
                val years = readln().toInt()

                val result = years * daysInTheYear

                println("Дней в $years году(-ах)/ лет: $result")
            }
            else -> println("Такого варианта не существует!")
        }
    }
}