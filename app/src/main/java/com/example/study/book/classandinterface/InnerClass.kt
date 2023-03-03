package com.example.study.book.classandinterface



// ◆ 내부 클래스 기법 ◆

/*  - 내부 클래스를 두는 이유
    독립적인 클래스로 정의하기 모호한 경우나
    다른 클래스에서는 잘 사용하지 않는 내부에서만 사용하고
    외부에서는 접근할 필요가 없기 때문                         */

// 내부클래스를 너무 남용하면 클래스의 의존성이 커지고 코드가 읽기 어려워 진다

/*  - 코틀린의 내부 클래스 종류

    ① 중첩 클래스 Nested Class
       → 객체 생성 없이 사용 가능
    ② 이너 클래스 Inner Class
       → 필드나 메소드와 연동하는 내부 클래스로 inner 키워드가 필요
    ③ 지역 클래스 Local Class
       → 클래스의 선언이 블록 안에 있는 클래스
    ④ 익명 객체 Anonymous Object
       → 이름이 없고 주로 일회용 객체를 사용하기 위해 object 키워드를 통해 선언    */


// ▶ 중첩 클래스 ◀
// 객체 생성 없이 접근할 수 있다
// 자바의 static 클래스처럼 다뤄진다
class Outer {
    val ov = 5
    class Nested {
        val nv = 10
        fun greeting() = "[Nested] Hello ! $nv" // 외부의 ov 에는 접근 불가
    }
    fun outside() {
        val msg = Nested().greeting()   // 객체 생성 없이 중첩 클래스의 메소드 접근
        println("[Outer]: $msg, ${Nested().nv}")    // 중첩 클래스의 프로퍼티 접근
    }
}

interface Switcher {    // ① 인터페이스의 선언 (익명 객체)
    fun on(): String
}

// ▶ 이너 클래스 ◀
// inner 키워드를 사용한다
// 바깥 클래스의 멤버에 접근할 수 있다 → private 도 접근 가능
class Smartphone(val model: String) {
    private val cpu = "Exynos"

    inner class ExternalStorage(val size: Int) {
        fun getInfo() = "${model}: Installed on $cpu with ${size}Gb"    // 바깥 클래스의 프로퍼티 접근
    }


// ▶ 지역 클래스 ◀
// 특정 메소드의 블록이나 init 블록 같이 블록 범위에서만 유효한 클래스
// 블록 범위를 벗어나면 더 이상 사용되지 않음
    fun powerOn(): String {
        class Led(val color: String) {  // 지역 클래스 선언
            fun blink(): String = "Blinking $color on $model"   // 외부의 프로퍼티는 접근 가능
        }
        val powerStatus = Led("Red")    // 여기에서 지역 클래스가 사용됨
        return powerStatus.blink()
    }   // powerOn() 블록 끝

    fun powerOff(): String {
        class Black(val color: String) {
            fun blink(): String = "Blinking $color on $model"
        }
        val powerStatus = Black("Black")
        val powerSwitch = object : Switcher {   // ② 익명 객체를 사용해 Switcher 의 on() 을 구현
            override fun on() : String {
                return powerStatus.blink()
            }
        }   // 익명(object) 객체 블록의 끝
        return powerSwitch.on() // 익명 객체의 메소드 사용
    }



}




fun main() {

    // 중첩 클래스
    // static 처럼 객체 생성 없이 사용
    val output = Outer.Nested().greeting()
    println(output)

    // Outer.outside()  // 오류 → 외부 클래스의 경우는 객체를 생성해야 함
    val outer = Outer()
    outer.outside()

    println()

    // 이너 클래스
    val mySdcard = Smartphone("S7").ExternalStorage(32)
    println(mySdcard.getInfo())

    println()

    // 지역 클래스
    val myPhone = Smartphone("Note9")
    myPhone.ExternalStorage(128)
    println(myPhone.powerOn())

    // 익명 함수
    println(myPhone.powerOff())
}