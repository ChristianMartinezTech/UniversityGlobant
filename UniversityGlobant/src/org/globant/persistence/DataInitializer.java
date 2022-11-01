package org.globant.persistence;

import org.globant.data.*;

import java.util.ArrayList;
import java.util.List;

public class DataInitializer {

    // Methods
    public static University preInfoSetup(){
        // Initializing University
        University Globant = new University();

        // Initializing 4 teachers
        FullTimeTeacher Benzema = new FullTimeTeacher("Karim Benzema", 38.5f, 15);
        FullTimeTeacher Modric = new FullTimeTeacher("Luka Modric", 32.5f, 28);
        PartTimeTeacher Vini = new PartTimeTeacher("Vinicius Junior", 30.0f, 25);
        PartTimeTeacher Courtois = new PartTimeTeacher("Thibaut Courtois", 25.0f, 30);

        // Initializing 6 Students
        Student Chris = new Student("Christian Martinez", 26);
        Student Rivas = new Student("Felipe Rivas", 30);
        Student Jarold = new Student("Jarold Hakins", 27);
        Student Massi = new Student("Massiel Mendoza", 34);
        Student Teo = new Student("Mateo Castellanos", 31);
        Student Sindy = new Student("Sindy Piedrahita", 22);

        // Initializing Courses
        List<Student> studentsEnglish = new ArrayList<>();
        studentsEnglish.add(Jarold);
        studentsEnglish.add(Sindy);
        Course English = new Course("English", 101, studentsEnglish, Courtois.getName());

        List<Student> studentsFrontEnd = new ArrayList<>();
        studentsFrontEnd.add(Massi);
        studentsFrontEnd.add(Sindy);
        studentsFrontEnd.add(Rivas);
        Course FrontEnd = new Course("Front-End Development",  102,studentsFrontEnd, Modric.getName());

        List<Student> studentsBackEnd = new ArrayList<>();
        studentsBackEnd.add(Chris);
        studentsBackEnd.add(Jarold);
        studentsBackEnd.add(Teo);
        Course BackEnd = new Course("Back-End Development",  103, studentsBackEnd, Benzema.getName());

        List<Student> studentsDevOps = new ArrayList<>();
        studentsDevOps.add(Chris);
        studentsDevOps.add(Rivas);
        Course DevOps = new Course("DevOps Development",  101, studentsDevOps, Vini.getName());
        return Globant;
    }
}
