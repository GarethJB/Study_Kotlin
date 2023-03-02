package com.example.study.book.`object`.relationship



/*  ▶ 연관 관계 Association ◀

    2개의 서로 분리된 클래스가 연결을 가지는 것
    단방향 혹은 양방향으로 연결될 수 있다
    객체가 따로 생성된다
    # 두 요소가 각각의 객체의 생명주기에 영향을 주지 않는다    */

class PatientAssociation(val name: String) {
    fun doctorList(d: DoctorAssociation) {
        println("Patient: $name, Doctor: ${d.name}")
    }
}

class DoctorAssociation(val name: String) {
    fun patientList(p: PatientAssociation) {
        println("Doctor: $name, Patient: ${p.name}")
    }
}

fun main() {
    val doc1 = DoctorAssociation("홍길동")
    val patient1 = PatientAssociation("심청")
    doc1.patientList(patient1)
    patient1.doctorList(doc1)
}