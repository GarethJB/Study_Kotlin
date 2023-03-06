package com.example.study.book.dsl

import com.example.study.book.standardfunction.apply
import kotlinx.coroutines.Job


// ◆ DSL (Domain-Specific Language ◆

// 특정 애플리케이션의 도메인을 위해 특화된 언어

// DB 에 접근하기 위한 SQL 이 대표적이다

data class Person(
    var name: String? = null,
    var age: Int? = null,
    var job: Job? = null)

data class Job(
    var category: String? = null,
    var position: String? = null,
    var extension: Int? = null)

fun person(block: Person.() -> Unit): Person = Person().apply(block)

fun Person.job(block: Job.() -> Unit) {
    job = Job().apply(block)
}

fun main() {
    val person = person {
        name = "홍길동"
        age = 40
        job {
//            category = "IT"
//            position = "Android Developer"
//            extension = 1234
        }
    }
    println(person)
}




