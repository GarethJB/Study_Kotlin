package com.example.study.book.generic



// ◆ 자료형의 프로젝션 ◆

// 프로젝션 → 사용하고자 하는 요소의 특정 자료형에 in / out 을 지정해 제한하는 것

// 가변성을 지정하는 2가지 방법

/*  ▶ 선언 지점 변성 declaration-site variance
    클래스를 선언하면서 클래스 자체에 가변성을 지정하는 방식
    클래스에 in / out 을 지정한다
    전체적으로 공변성이 지정되기 때문에,
    클래스를 사용하는 장소에서 따로 자료형을 지정하지 않아도 된다

    // 예시
    class Box<in T: Animal>(var item: T)                            */


/*  ▶ 사용 지점 변성 use-site variance
    사용 시점에서 가변성을 지정하는 방식             */
class TypeClass<T> (var parent: T)

fun <T> print(element: TypeClass<out Parent>) {
    val parentObj: Parent = element.parent
    println(parentObj)
}
