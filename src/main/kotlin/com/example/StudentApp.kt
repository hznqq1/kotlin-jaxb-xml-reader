package com.example

import jakarta.xml.bind.annotation.*
import java.io.FileReader

// Класс для списка студентов
@XmlRootElement(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
data class Students(
    @field:XmlElement(name = "student")
    val studentList: List<Student>? = null
) {
    override fun toString(): String {
        return "Students(studentList=$studentList)"
    }
}

// Класс для одного студента
@XmlAccessorType(XmlAccessType.FIELD)
data class Student(
    @field:XmlElement(name = "firstName")
    val firstName: String? = null,

    @field:XmlElement(name = "secondName")
    val secondName: String? = null,

    @field:XmlElement(name = "age")
    val age: Int? = null,

    @field:XmlElement(name = "hobbies")
    val hobbies: Hobbies? = null
) {
    override fun toString(): String {
        return "Student(firstName='$firstName', secondName='$secondName', age=$age, hobbies=$hobbies)"
    }
}

// Класс для списка хобби
@XmlAccessorType(XmlAccessType.FIELD)
data class Hobbies(
    @field:XmlElement(name = "hobby")
    val hobbyList: List<String>? = null
) {
    override fun toString(): String {
        return "Hobbies(hobbyList=$hobbyList)"
    }
}

// Основной объект приложения
object StudentApp {
    @JvmStatic
    fun main(args: Array<String>) {
        try {
            // Создаем контекст JAXB для класса Students
            val context = jakarta.xml.bind.JAXBContext.newInstance(Students::class.java)
            // Создаем unmarshaller для десериализации
            val unmarshaller = context.createUnmarshaller()

            // Загружаем XML-файл из ресурсов
            val resourceStream = StudentApp::class.java.classLoader.getResourceAsStream("students.xml")
                ?: throw RuntimeException("Файл students.xml не найден в resources")

            // Десериализуем XML в объект Students
            val students = unmarshaller.unmarshal(resourceStream) as Students

            println("=== СПИСОК СТУДЕНТОВ ===")
            students.studentList?.forEach { student ->
                println("- ${student.firstName} ${student.secondName}, возраст: ${student.age}")
                println("  Хобби: ${student.hobbies?.hobbyList?.joinToString(", ")}")
                println()
            }
            // Дополнительно: выводим каждого студента по отдельности
            students.studentList?.forEach { student ->
                println(" - $student")
            }

        } catch (e: Exception) {
            // Выводим стек трейс ошибки для диагностики
            e.printStackTrace()
        }
    }
}