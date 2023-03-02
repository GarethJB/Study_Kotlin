package com.example.study.book.`object`

// ◆ 정보 은닉 캡슐화 ◆

// 클래스를 작성할 때 숨겨야 하는 속성이나 기능

// ▶ 가시성 지시자 ◀
// 각 클래스나 메소드, 프로퍼티의 접근 범위를 가시성 Visibility 라고 한다

//  private : 이 요소는 외부에서 접근할 수 없다
//  public : 이 요소는 어디서든 접근이 가능하다 (default)
//  protected : 외부에서 접근할 수 없으나 하위 상속 요소에서는 가능하다
//  internal : 같은 정의의 모듈 내부에서는 접근이 가능하다


// ▶ Private 가시성◀
private class PrivateClass {
    private var i = 1
    private fun privateFunc() {
        i += 1  // 접근 허용
    }
    fun access() {
        privateFunc()   // 접근 허용
    }
}

class OtherClass {
    // 다른 클래스에서 프로퍼티로서 PrivateClass 의 객체를 지정하려면 똑같이 private 로 선언해야 함
    //val opc = PrivateClass()    // 불가 - 프로퍼티 opc 는 private 이 되어야 함
    fun test() {
        val pc = PrivateClass() // 생성 가능
    }
}

fun TopFunction() {
    val tpc = PrivateClass()    // 객체 생성 가능
}


// ▶ protected 가시성 ◀
open class BaseProtected {
    protected var i = 1
    protected fun protectedFunc() {
        i += 1  // 접근 허용
    }
    fun access() {
        protectedFunc() // 접근 허용
    }
    protected class Nested  // 내부 클래스에는 지시자 허용
}

class Derived : BaseProtected() {
    fun test(base: BaseProtected): Int {
        protectedFunc() // BaseProtected 클래스의 메소드 접근 가능
        return i    // BaseProtected 클래스의 프로퍼티 접근 가능
    }
}


// ▶ internal ◀
// internal 은 코틀린에서 새롭게 정의된 이름이다
// 모듈이 달라지면 접근할 수 없다
// 만일 프로젝트에 또 다른 모듈이 없어 하나만 있는 경우 internal 의 접근 범위는 프로젝트 전체가 된다
// 파일이 달라도 동일한 모듈에 있다면 바로 접근할 수 있다
// 만일 패키지 이름이 다르다면 필요한 클래스를 import 해서 사용할 수 있다
internal class InternalClass {
    internal var i = 1
    internal fun icFunc() {
        i += 1  // 접근 허용
    }
    fun access() {
        icFunc()    // 접근 허용
    }
}

class Other {
    internal val ic = InternalClass()   // 프로퍼티를 지정할 때 internal 로 맞춰야 함
    fun test() {
        ic.i    // 접근 허용
        ic.icFunc() // 접근 허용
    }
}


// 자동차와 도둑의 예제
open class CarTest protected constructor(_year: Int, _model: String, _power: String, _wheel: String) {  // ①
    private var year: Int = _year
    public var model: String = _model   // public 은 기본값이므로 생략 가능
    protected open var power: String = _power
    internal var wheel: String = _wheel

    protected fun start(key: Boolean) {
        if (key) println("Start the Engine!")
    }

    class Driver(_name: String, _license: String) { // ②
        private var name: String = _name
        var license: String = _license  // public
        internal fun driving() = println("[Driver] Driving() - $name")
    }
}

class Kia(_year: Int, _model: String, _power: String, _wheel: String,
            var name: String, private var key: Boolean)
                : CarTest(_year, _model, _power, _wheel) {
                    override var power: String = "50hp"
                    val driver = Driver(name, "first class")

                    constructor(_name: String, _key: Boolean)
                        : this(2014, "basic", "100hp", "normal", _name, _key) {
                            name = _name
                            key = _key
                        }
                    fun access(password: String) {
                        if (password == "goKia") {
                            println("-----[Kia] access()-----")
                            //super.year    // ③ private 접근 불가
                            println("super.model = ${super.model}") // public
                            println("super.power = ${super.power}") // protected
                            println("super.wheel = ${super.wheel}") // internal
                            super.start(key)    // protected

                            // driver.name  // private 접근 불가
                            println("Driver().license = ${driver.license}") // public
                            driver.driving()    // internal
                        } else {
                            println("You're a burglar")
                        }
                    }
                }

class Burglar() {
    fun steal(anyCar: Any) {
        if (anyCar is Kia) {    // ④ 인자가 Kia 의 객체일 때
            println("-----[Burglar] steal()-----")
            //println(anyCar.power) // protected 접근 불가
            //println(anyCar.year)  // private 접근 불가
            println("anyCar.name = ${anyCar.name}") // public 접근
            println("anyCar.wheel = ${anyCar.wheel}")
            println("anyCar.model = ${anyCar.model}")

            println(anyCar.driver.license)
            anyCar.driver.driving()
            //println(CarTest.start())
            anyCar.access("Don't Know")
        } else {
            println("Nothing to steal")
        }
    }
}



fun main() {

    // private
    val pc = PrivateClass() // 생성 가능
    //pc.i    // 접근 불가
    //pc.privateFunc()    // 접근 불가


    // protected
    val base = BaseProtected()  // 생성 가능
    //base.i  // 접근 불가
    //base.protectedFunc()    // 접근 불가
    base.access()   // 접근 가능


    // internal
    val mic = InternalClass()   // 생성 가능
    mic.i   // 접근 허용
    mic.icFunc()    // 접근 허용


    // 자동차와 도둑의 예제
    //val car = Car()   // protected 생성 불가
    val kia = Kia("홍길동", true)
    kia.access("goKia")

    val burglar = Burglar()
    burglar.steal(kia)
}


