package com.shyam.wordcount

import java.io.File
import java.io.InputStream

fun main(args:Array<String>){
    val input : InputStream = File("app/test.txt").inputStream()
    val sentence = input.bufferedReader().use{
        it.readText()
    }
    val wordlist = sentence.replace("/n"," ").replace(","," ").replace("."," ").split(" ")
    var wordMap = mutableMapOf<String,Int>()
    for(word in wordlist){
        if (word != "" && word != "/n /n /n /n") {
            if (wordMap[word.capitalize()] != null) {
                val wordcount = wordMap[word.capitalize()]!!
                wordMap[word.capitalize()] = wordcount + 1
            } else {
                wordMap[word.capitalize()] = 1
            }
        }
    }
    for (word in wordMap){
        println(word)
    }
    val wordList = wordMap.toList()
    var sortedList = wordList.sortedWith(compareByDescending({it.second}))
    for (i in sortedList){
        println("${i.first}-${i.second}")
    }
}