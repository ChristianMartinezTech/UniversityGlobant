import DataModel.Course;
import DataModel.FullTimeTeacher;
import DataModel.PartTimeTeacher;
import DataModel.Student;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Instantiating FullTimeTeacher
        FullTimeTeacher Carlos = new FullTimeTeacher("Carlos", 32.5f, 7);
        System.out.println("Name: " + Carlos.getName());
        System.out.println("Base Salary: " + Carlos.getBaseSalary());
        System.out.println("Experience Years: " + Carlos.getExpYears());
        System.out.println("Full Time: " + Carlos.getFullTime());
        System.out.println("Salary: " + Carlos.calculateSalary());
        System.out.println("------------------");

        // Instantiating FullTimeTeacher
        PartTimeTeacher Alfonso = new PartTimeTeacher("Alfonso", 15.1f, 20);
        System.out.println("Name: " + Alfonso.getName());
        System.out.println("Base Salary: " + Alfonso.getBaseSalary());
        System.out.println("Weekly Hours: " + Alfonso.getWeeklyHours());
        System.out.println("Full Time: " + Alfonso.getFullTime());
        System.out.println("Salary: " + Alfonso.calculateSalary());
        System.out.println("------------------");

        // Instantiating Student
        Student Albertico = new Student("Albertico", 15);
        System.out.println("Name: " + Albertico.getName());
        System.out.println("Id: " + Albertico.getId());
        System.out.println("Age: " + Albertico.getAge());
        System.out.println("------------------");

        // Instantiating Course
        String[] students = new String[2];
        students[0] = "Chris";
        students[1] = "Danielito";

        Course Spanish = new Course("Spanish", 101, students, "Profe");
        System.out.println(Spanish);
        System.out.println("------------------");
        System.out.println("Name: " + Spanish.getName());
        System.out.println("Classroom: " + Spanish.getClassroom());
        System.out.println("Teacher: " + Spanish.getTeacherName());
        System.out.println("Students: " + Arrays.toString(Spanish.getCourseStudents()));
        System.out.println("------------------");

        // Work on:
        // Course: enrollStudents and assignTeacher methods
        // Teacher and Student assing and unassing
        // University class
    }
}
