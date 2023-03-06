package com.example.study.book.standardfunction

import java.io.Closeable
import java.io.FileOutputStream
import java.io.PrintWriter


// ◆ use() 함수 활용 ◆

// use() 함수를 사용하면 객체를 사용한 후 close() 함수를 자동적으로 호출해 닫아 줄 수 있다
//public inline fun <T : Closeable?, R> T.use(block: (T) -> R): R

// use() 함수 사용

fun main() {
    PrintWriter(FileOutputStream("d:\\test\\output.txt")).use {
        it.println("hello")
    }
}