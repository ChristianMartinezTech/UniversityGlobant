# Globant university

## Guide for teachers
Hi there **Felipe Jimenez** and **Juan Pablo Castiblanco**!
This has been the result of 4 very intense weeks of Java learning. :))

There's a guide bellow on how to get the results stated in the PDF guide. The guide of commands always assumes you're in the main menu of the application.

- Print a menu including the following options:
  - Print all the professors with its data. | Press -> 5
  - Print all the classes and a submenu to select a class in order to print the class data including its
    teacher and students. | Press -> 4
  -  Create a new student and add it to an existing class. | Press -> 7 Create the student, Press -> 2 -> 2 to assign it to course
  - Create a new class and add an existing teacher, existing students and its relevant data. | Press -> 9 Create the course, assign data -> Press -> 2 -> 2 to assign students
  - List all the classes in which a given student is included (hint: search by id) | Press 2 -> 1
  - Exit | Press -> 0

## About
Globant university is system to track university classes, teachers and students.

As shown bellow, this is an Object-Oriented System with the Following Classes:
  - University: host the Teacher, Student, and Course lists. As well as the methods to interact between the list and the classes themselves.
  - Teacher: is an abstract class that will inherit to the Part-Time and Full-Time teacher classes.
  - Full-Time teacher: define the Full-Time Teacher class
  - Part-Time teacher: define the Part-Time Teacher class
  - Student: define the Student class
  - Course: define the Course class

## Diagram
.

![alt text](https://github.com/ChristianMartinezTech/UniversityGlobant/blob/main/UniversityUML.png?raw=true)

