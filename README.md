# Чтение XML с помощью JAXB на Kotlin

Этот проект демонстрирует, как читать XML-файл в Kotlin с использованием библиотеки JAXB (Java Architecture for XML Binding). Он преобразует XML-данные о студентах в объекты Kotlin и выводит их в консоль.

## Структура проекта

XML_jaxb/
├── pom.xml # Файл конфигурации Maven
├── README.md # Этот файл
├── src/
│ ├── main/
│ │ ├── kotlin/
│ │ │ └── com/
│ │ │ └── example/
│ │ │ └── StudentApp.kt # Основной файл с кодом
│ │ └── resources/
│ │ └── students.xml # XML-файл с данными
└── target/ # Сгенерированные файлы (появляется после сборки)


## Требования

- Java Development Kit (JDK) 11 или выше
- Kotlin (устанавливается через Maven)
- Maven (для сборки проекта)

## Зависимости

Проект использует следующие зависимости, управляемые через `pom.xml`:

- `kotlin-stdlib`: Стандартная библиотека Kotlin.
- `jakarta.xml.bind-api`: API JAXB.
- `jaxb-runtime`: Реализация JAXB.

## Классы

- `Students`: Представляет корневой элемент `<students>` и содержит список `Student`.
- `Student`: Представляет элемент `<student>` с полями `firstName`, `secondName`, `age`, `hobbies`.
- `Hobbies`: Представляет элемент `<hobbies>` и содержит список `hobbyList`.
- `StudentApp`: Содержит метод `main`, который запускает процесс десериализации и вывода данных.

## Использование

1.  Убедитесь, что у вас установлены JDK и Maven.
2.  Склонируйте или скачайте этот репозиторий.
3.  Откройте проект в IDE, поддерживающей Maven (например, IntelliJ IDEA).
4.  Запустите проект, выполнив метод `main` в `StudentApp.kt`.
5.  В консоли будет выведен список студентов, десериализованный из `students.xml`.

## Пример вывода

=== СПИСОК СТУДЕНТОВ ===

Ivan Ivanov, возраст: 25
Хобби: Hockey, Football
Petr Petrov, возраст: 29
Хобби: Programming, Paintball, Lego
Vasiliy Smirnov, возраст: 29
Хобби: Video games



