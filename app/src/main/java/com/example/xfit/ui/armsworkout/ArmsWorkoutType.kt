package com.example.xfit.ui.armsworkout

fun main() {
    val number = arrayOf(9, 10, 10, 10, 1, 4, 7, 9, 8, 0, 2, 3, 5, 4)

    //make array sorted with distinct value  -> this can apply on mutablelistof() as well
    val shortedArray = number.sortedArray().distinct()
    //filter the index with third last element and print all the largest number after third last element
    println(shortedArray.filter { it > shortedArray.size - 3 })
    println("----------------------------****---------------------------------")
    println("----------------------------****---------------------------------")

    //this will take function reference of isAdult and return non Adult
    val notAdult = shortedArray.filter(::isAdult)
    notAdult.forEach { println(it) }
    println("----------------------------****---------------------------------")
    println("----------------------------****---------------------------------")

    //this will take function reference of isAdult and return all adult
    val adult = shortedArray.filterNot(::isAdult)
    adult.forEach { println(it) }
    println("----------------------------****---------------------------------")
    println("----------------------------****---------------------------------")

    //add all the month from thirdQuarter to month which has charchter "o"
    val month = mutableListOf("Jan","Feb","March","April","May", "June")
    val thirdQuarter = mutableListOf("Aug","Sep","oct","Nov","Dec")
    thirdQuarter.filterTo(month,{it.contains("o")})
    println(month)
    println("----------------------------****---------------------------------")
    println("----------------------------****---------------------------------")
}

private fun isAdult(age: Int): Boolean {
    return age >= 5
}