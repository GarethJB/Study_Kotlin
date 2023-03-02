package com.example.study.book.`object`.relationship



/*  ▶ 의존 관계 Dependency ◀

    한 클래스가 다른 클래스에 의존되어 있어 영향을 주는 것
    A 클래스를 생성하려고 하는데 먼저 B의 객체가 필요한 경우 → A는 B의 객체에 의존하는 관계    */

class PatientDependency(val name: String, var id: Int) {
    fun doctorList(d: DoctorDependency) {
        println("Patient: $name, Doctor: ${d.name}")
    }
}

class DoctorDependency(val name: String, val p: PatientDependency) {
    val customerId: Int = p.id

    fun patientList() {
        println("Doctor: $name, Patient: ${p.name}")
        println("Patient Id: $customerId")
    }
}

fun main() {
    val patient1 = PatientDependency("심청", 1234)
    val doc1 = DoctorDependency("홍길동", patient1)
    doc1.patientList()
}