package com.example.study.book.lambda

// ◆ 고차함수와 람다식의 사례 ◆

// ▶ 네트워크 호출 구현 ◀

/*
    콜백(Callback) 함수란 특정 이벤트가 발생하기까지 처리되지 않다가
    이벤트가 발생하면 즉시 호출되어 처리되는 함수를 말한다
    즉 사용자가 아닌 시스템이나 이벤트에 따라 호출 시점을 결정


// 코틀린으로 만든 네트워크 호출 구현부

// ① 람다식 함수의 파라미터를 가진 networkCall() 함수 선언
fun networkCall(onSuccess: (ResultType) -> Unit, onError: (Throwable) -> Unit) {
    try {
        onSuccess(myResult)
    }catch (e: Throwable) {
        onError(e)
    }
}


// ② networkCall() 함수 사용 - 인자 형식에 람다식을 사용
networkCall(result -> {
    // 네트워크 호출에 성공했을 때 구현부
}, error -> {
    // 네트워크 호출에 실패했을 때 구현부
})

*/