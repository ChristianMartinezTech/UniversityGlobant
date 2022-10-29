package org.globant.view;

import org.globant.data.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // App menus functionality
        Scanner usr = new Scanner(System.in);
        System.out.println("Hi there. Welcome to Globant University");
        System.out.println("1. Type 1 for Teacher");
        System.out.println("2. Type 2 for Student");
        System.out.println("3. Type 3 to show a specific course information");
        System.out.println("4. Type 4 to show all courses information");
        System.out.println("5. Type 5 to exit");

        int usrOption = usr.nextInt();
        menuOptions(usrOption, preInfoSetup());
    }

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
        Student[] studentsEnglish = new Student[2];
        studentsEnglish[0] = Jarold;
        studentsEnglish[1] = Sindy;
        Course English = new Course("English", 101, studentsEnglish, Courtois.getName());

        Student[] studentsFrontEnd = new Student[3];
        studentsFrontEnd[0] = Massi;
        studentsFrontEnd[1] = Sindy;
        studentsFrontEnd[2] = Rivas;
        Course FrontEnd = new Course("Front-End Development", 102, studentsFrontEnd, Modric.getName());

        Student[] studentsBackEnd = new Student[3];
        studentsBackEnd[0] = Chris;
        studentsBackEnd[1] = Jarold;
        studentsBackEnd[2] = Teo;
        Course BackEnd = new Course("Back-End Development", 103, studentsBackEnd, Benzema.getName());

        Student[] studentsDevOps = new Student[2];
        studentsDevOps[0] = Chris;
        studentsDevOps[1] = Rivas;
        Course DevOps = new Course("DevOps Development", 104, studentsDevOps, Vini.getName());
        return Globant;
    }


    public static void menuOptions(int usrOption, University Globant){
        switch(usrOption){
            case 1:
                teacherMenu(Globant);
                break;
            case 2:
                studentMenu(Globant);
                break;
            case 3:
                //specificCourse();
                break;
            case 4:
                System.out.println(University.getListOfCourses());
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Not valid. Please select the correct number");
        }
    }

    public static void teacherMenu(University Globant){
        Scanner usr = new Scanner(System.in);
        System.out.println("Welcome teacher! Please input your full name:");

        // Taking in the full name with spaces
        String teacherName="";
        teacherName += usr.nextLine();

         if(University.findTeacher(teacherName)) {
             // Scanner teacherOptions = new Scanner(System.in);
             System.out.println("1. Type 1 to see all your Courses");
             System.out.println("2. Type 2 to assign yourself a course");
             System.out.println("3. Type 3 to remove yourself from a course");
             System.out.println("4. Type 4 to calculate your next salary");
             int teacherChoose = usr.nextInt();

             switch(teacherChoose){
                 case 1:
                     System.out.println(University.teacherCourses(teacherName));
                     break;

                 case 2:
                     System.out.println("Please type the course ID:");
                     int teacherNewCourseID = usr.nextInt();
                     System.out.println(University.assignTeacher(teacherNewCourseID, teacherName));
                     break;

                 case 3:
                     // Teacher removeCourse
                     System.out.println("3");
                     break;
                 case 4:
                     // Teacher calculate Salary
                     System.out.println("4");
                     break;
                 default:
                     System.out.println("Not valid. Please select the correct number");
                     break;
             }
         } else {
            System.out.println("Teacher NOT found. Please type in your full name with this format: \\\"Globant Teacher\\\"");
        }
    }

    public static void studentMenu(University Globant){
        Scanner usr = new Scanner(System.in);
        System.out.println("Welcome! Please input your student ID:");

        int studentID = usr.nextInt();

        if (University.findStudent(studentID)){
            System.out.println("Student found");

            // Student menu

        } else {
            System.out.println("Student NOT found");
        }
    }
}
// Work on Teacher's methods
// Then student
// Then the rest
