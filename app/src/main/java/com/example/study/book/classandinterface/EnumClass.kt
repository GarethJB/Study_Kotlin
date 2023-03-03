package com.example.study.book.classandinterface



// ◆ 열거형 클래스 ◆

// 여러개의 상수를 선언하고 열겨된 값을 조건에 따라 선택할 수 있는 특수한 클래스
// 열거형 클래스는 실드 클래스처럼 다양한 데이터타입을 다루지 못함
// enum 키워드와 함께 선언할 수 있다
// 데이터타입이 동일한 상수를 나열할 수 있다

/*  enum class 클래스 이름 [(생성자)] {
        상수1[(값)], 상수2[(값)], 상수3[(값)], ...
        [; 프로퍼티 혹은 메소드]
    }                                                   */


// 동서남북 네 방향을 각각 변수로 선언하는 열거형 클래스
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}


// 각 요일마다 숫자를 지정한 열거형 클래스
enum class DayOfWeek(val num: Int) {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4),
    FRIDAY(5), SATURDAY(6), SUNDAY(7)
}   // 각 상수의 값은 파라미터를 통해 초기화될 수 있다


// 필요한 경우 메소드를 포함할 수 있다
enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0), ORANGE(255, 165, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(75, 0, 130), VIOLET(238, 130, 238);  // 세미콜론으로 끝을 알림

    fun rgb() = (r * 256 + g) * 256 + b // 메소드를 포함할 수 있다
}


// when 을 사용하여 각 케이스를 처리
fun getColor(color: Color) = when (color) {
    Color.RED -> color.name // 이름 가져오기
    Color.ORANGE -> color.ordinal   // 순서 번호 : 1
    Color.YELLOW -> color.toString()    // 문자열 변환
    Color.GREEN -> color    // 기본값
    Color.BLUE -> color.r   // r값 : 0
    Color.INDIGO -> color.g
    Color.VIOLET -> color.rgb() // 메소드 연산 결과
}


// 인터페이스를 통한 열거형 클래스 구현
interface Score {
    fun getScore(): Int
}

enum class MemberType(var prio: String) : Score {   // Score 를 구현할 열거형 클래스
    NORMAL("Third") {
        override fun getScore(): Int = 100  // 구현된 메소드
    },
    SILVER("Second") {
        override fun getScore(): Int = 500
    },
    GOLD("First") {
        override fun getScore(): Int = 1500
    }
}




fun main() {

    // when 을 사용해 각 값에 따른 실행이 가능하고
    // , [쉼표] 를 통해 여러 케이스를 표현할 수 있다
    val day = DayOfWeek.SATURDAY    // SATURDAY 의 값 읽기
    when(day.num) {
        1, 2, 3, 4, 5 -> println("Weekday")
        6, 7 -> println("Weekend")
    }

    // 메소드를 포함한 열거형 클래스 실행
    println(Color.BLUE.rgb())


    // 인터페이스를 통한 열거형 클래스 구현
    println(MemberType.NORMAL.getScore())
    println(MemberType.GOLD)
    println(MemberType.valueOf("SILVER"))
    println(MemberType.SILVER.prio)

    for (grade in MemberType.values()) {    // 모든 값을 가져오는 반복문
        println("grade.name = ${grade.name}, prio = ${grade.prio}")
    }
}

