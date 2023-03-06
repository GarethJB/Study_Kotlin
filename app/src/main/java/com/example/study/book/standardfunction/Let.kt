package com.example.study.book.standardfunction



// ◆ let 함수 ◆

// let() 함수는 함수를 호출하는 객체 T를
// 이어지는 block 의 인자로 넘기고 block 의 결과값 R을 반환한다
public inline fun <T, R> T.let(block: (T) -> R): R { return block(this)}

// let() 함수 사용
fun main() {
    val score: Int? = 32
    // var score = null



    // 일반적인 null 검사
    fun checkScore() {
        if (score != null) {
            println("Score: $score")
        }
    }

    // let 함수를 사용해 null 검사를 제거
    fun checkScoreLet() {
        score?.let { println("Score: $it") }
        val str = score.let { it.toString() }
        println(str)
    }
    checkScore()
    checkScoreLet()
}