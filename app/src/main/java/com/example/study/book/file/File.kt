package com.example.study.book.file



// ◆ 파일 입출력 ◆

/*  Kotlin 의 입출력 API

    파일 처리                   →   java.io.File
    바이트 단위의 입력 처리     →   java.io.InputStream
    바이트 단위의 출력 처리     →   java.io.OutputStream
    문자 기반 읽기 처리         →   java.io.Reader
    문자 기반 쓰기 처리         →   java.io.Writer
    버퍼를 가진 읽기 처리       →   java.io.BufferedReader       */

// Stream 은 데이터가 강물에 띄운 것처럼 흘러간다는 의미로
// 데이터가 머물러 있지 않고 전달되는 개념

// 대량의 데이터에는 copyTo, forEachBlock, ForEachLine 과 같은 API 를 써야한다

// InputStream, Reader, Writer 를 쓸 때는 호출 후 사용이 완료되면 반드시 닫아야 한다



/*  io 와 nio 의 개념

    io 와 nio 의 기본적인 차이점은 버퍼 사용에 있다

    - 입출력
    java.io : Stream 방식
    java.nio : Channel 방식

    - 버퍼 방식
    java.io : Non-buffer
    java.nio : Buffer

    - 비동기 지원
    java.io : 지원 안 함 (블로킹 방식)
    java.nio : 지원함 (넌브로킹 지원)


    # Stream 방식 → 데이터를 물 흐르듯 바로 전송
    # Channel 방식 → 여러 개의 수로를 사용해 병목 현상을 줄임

    # Buffer 는 송/수신 사이에 임시적으로 사용하는 공간이 있는지에 따라 결정
    # 공간이 있는 Buffer 방식이 좀 더 유연한 처리가 가능

    # java.io 의 경우 블로킹 방식으로 비동기 동작을 지원하지 않는 대신 단순하게 구성 가능
    # java.nio 는 넌블로킹을 지원해 입출력 동작의 멈춤 없이 또 다른 작업을 할 수 있는 비동기를 지원    */



/*  스트림과 채널

    Stream 은 데이터가 흘러가는 방향성에 따라
    InputStream [입력 스트림] 과 OutputStream [출력 스트림] 으로 구분된다.
    양방향성을 가지는 작업(읽기/저장)을 할 때, 두 작업을 별도로 지정해야 한다

    Channel 방식은 양방향으로 입력과 출력이 모두 가능하기 때문에 입출력을 별도로 지정하지 않는다
    여러 개의 수로를 가진다고 비유하면 이해하기 좋다
    FileChannel 을 생성하면 입력과 출력을 동시에 사용할 수 있게 되는 것                                */



/*  nio 패키지의 구성

    java.nio            →   다양한 버퍼 클래스
    java.nio.channels   →   파일 채널, TCP/UDP 채널 등
    java.nio.charset    →   문자 세트, 인코더, 디코더 등
    java.nio.file       →   파일 및 파일 시스템 접근 클래스              */



/*  넌버퍼와 버퍼 방식

    # Stream 방식에서는 1Byte 를 쓰면 InputStream 이 1Byte 를 읽는다
    → Buffer 를 사용해 다수의 데이터를 읽는 것보다 느리게 동작
    → io 방식에서는 버퍼와 병합해 사용하는 BufferedInputStream 과 BufferedOutputStream 사용

    #


 */