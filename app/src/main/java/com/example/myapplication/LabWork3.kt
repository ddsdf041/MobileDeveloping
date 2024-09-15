package com.example.myapplication

import kotlin.math.sqrt

fun task1(){
    var number:Int? = null
    println(number)   //вывело null
    number = 123
    val text:String = number.toString()
    println(text)   //вывело 123
}

fun getFullName(firstName: String?, lastName: String?): String{
    return "${firstName?.trim() ?: "Unknown"} ${lastName?.trim() ?: "Unknown"}"
}

fun calculateSquareRoot(number:Double?): Double{
    return sqrt(number!!)
}

fun getStringLength(obj:Any?): Int{
    val str = obj as? String
    return str?.length ?: -1
}

fun main(){
    println("Задание 1")
    task1()
    println("=".repeat(30))

    println("Задание 2")
    println(getFullName(null,null))
    println(getFullName("Софья","Лёвина"))
    println("=".repeat(30))

    println("Задание 3")
//    println(calculateSquareRoot(null))
    println(calculateSquareRoot(25.0))
    println("=".repeat(30))

    println("Задание 4")
    println(getStringLength(null))
    println(getStringLength("123456789"))
}