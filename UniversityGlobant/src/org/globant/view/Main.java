package org.globant.view;

import org.globant.data.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.globant.data.University.findStudentName;
import static org.globant.data.University.removeTeacherFromClass;

public class Main {
    public static void main(String[] args) {
        // Initalizing data
        University Globant = preInfoSetup();

        // Executing the program menu
        mainMenu(Globant);
    }

    public static void mainMenu(University Globant){
        Scanner usr = new Scanner(System.in);
        System.out.println("Hi there. Welcome to Globant University");
        System.out.println("");
        System.out.println("1. Type 1 for Teacher");
        System.out.println("2. Type 2 for Student");
        System.out.println("3. Type 3 to show a specific course information");
        System.out.println("4. Type 4 to show all courses information");
        System.out.println("5. Type 5 to show all teachers information");
        System.out.println("6. Type 6 to show all students information");
        System.out.println("7. Type 7 to exit");

        int usrOption = usr.nextInt();
        menuOptions(usrOption, Globant);
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


    public static void menuOptions(int usrOption, University Globant){
        switch(usrOption){
            case 1:
                teacherVerification(Globant);
                break;
            case 2:
                studentVerification(Globant);
                break;
            case 3:
                //specificCourse();
                break;
            case 4:
                for (int i = 0; i < University.getListOfCourses().size(); i++){
                    System.out.println(University.getListOfCourses().get(i));
                }

                System.out.println("");
                System.out.println("---------");
                System.out.println("");

                mainMenu(Globant);
                break;
            case 5:
                for (int i = 0; i < University.getListOfTeachers().size(); i++){
                    System.out.println(University.getListOfTeachers().get(i));
                }

                System.out.println("");
                System.out.println("---------");
                System.out.println("");

                mainMenu(Globant);
                break;
            case 6:
                 for (int i = 0; i < University.getListOfStudents().size(); i++){
                    System.out.println(University.getListOfStudents().get(i));
                }

                System.out.println("");
                System.out.println("---------");
                System.out.println("");

                mainMenu(Globant);
                break;
            case 7:
                System.exit(0);
            default:
                System.out.println("Not valid. Please select the correct number");
        }
    }

    public static void teacherVerification(University Globant){
        Scanner usr = new Scanner(System.in);
        System.out.println("");
        System.out.println("Welcome teacher! Please input your full name:");

        // Taking in the full name with spaces
        String teacherName="";
        teacherName += usr.nextLine();

        if(University.findTeacher(teacherName)) {
            teacherMenu(Globant, teacherName);
        } else {
            System.out.println("Teacher NOT found. Please type in your full name with this format: \\\"Globant Teacher\\\"");
            mainMenu(Globant);
        }
    }

    public static void teacherMenu(University Globant, String teacherName){
        Scanner usr = new Scanner(System.in);
             System.out.println("");
             System.out.println("1. Type 1 to see all your Courses");
             System.out.println("2. Type 2 to assign yourself a course");
             System.out.println("3. Type 3 to remove yourself from a course");
             System.out.println("4. Type 5 to go back to the previous menu");
             System.out.println("5. Type 6 to exit");
             int teacherChoose = usr.nextInt();

             switch(teacherChoose){
                 case 1:
                     // Print all teacher Courses
                     System.out.println("");
                     for (int i = 0; i < University.teacherCourses(teacherName).size(); i++){
                         System.out.println(University.teacherCourses(teacherName).get(i));
                     }

                     System.out.println("");
                     System.out.println("---------");
                     System.out.println("");
                     teacherMenu(Globant, teacherName);
                     break;

                 case 2:
                     // Assign Teacher to course
                     System.out.println("");
                     System.out.println("Please type the course ID:");
                     int teacherNewCourseID = usr.nextInt();
                     System.out.println("");
                     System.out.println(University.assignTeacher(teacherNewCourseID, teacherName));
                     System.out.println("");
                     System.out.println("---------");
                     System.out.println("");
                     teacherMenu(Globant, teacherName);
                     break;

                 case 3:
                     // Remove Teacher from Course
                     System.out.println("");
                     System.out.println("Please type the course ID:");
                     int teacherRemoveCourseID = usr.nextInt();
                     System.out.println("");
                     System.out.println(removeTeacherFromClass(teacherRemoveCourseID));
                     System.out.println("");
                     System.out.println("---------");
                     System.out.println("");
                     teacherMenu(Globant, teacherName);
                     break;
                 case 4:
                     System.out.println("");
                     System.out.println("---------");
                     System.out.println("");
                     mainMenu(Globant);
                     break;
                 case 5:
                     System.exit(0);
                     break;
                 default:
                     System.out.println("");
                     System.out.println("Not valid. Please select the correct number");
                     System.out.println("");
                     System.out.println("---------");
                     System.out.println("");
                     teacherMenu(Globant, teacherName);
                     break;
             }
    }

    public static void studentVerification(University Globant) {
        Scanner usr = new Scanner(System.in);
        System.out.println("");
        System.out.println("Welcome! Please input your student ID:");

        int studentID = usr.nextInt();

        if (University.findStudent(studentID)) {
            studentMenu(Globant, studentID);
        } else {
            System.out.println("");
            System.out.println("Student NOT found. Please type in your correct student ID.");
            System.out.println("");
            mainMenu(Globant);
        }
    }

    private static void studentMenu(University Globant, int studentID) {
        Scanner usr = new Scanner(System.in);
        System.out.println("");
        System.out.println("1. Type 1 to see all your Courses");
        System.out.println("2. Type 2 to assign yourself a course");
        System.out.println("3. Type 3 to remove yourself from a course");
        System.out.println("4. Type 4 to go back to the previous menu");
        System.out.println("5. Type 5 to exit");
        String studentname = findStudentName(studentID);
        System.out.println(studentname);
        int studentChoose = usr.nextInt();

        switch(studentChoose){
            case 1:
                // Print all student Courses
                System.out.println("");
                System.out.println("Your active courses are:");
                System.out.println("");
                for (int i = 0; i < University.studentCourses(studentID).size(); i++){
                    System.out.println(University.studentCourses(studentID).get(i));
                }

                System.out.println("");
                System.out.println("---------");
                System.out.println("");
                studentMenu(Globant, studentID);
                break;

            case 2:
                // Assign student to course
                System.out.println("");
                System.out.println("Please type the course ID:");
                int courseID = usr.nextInt();
                System.out.println("");
                System.out.println(University.addStudentToCourse(studentID, courseID));
                System.out.println("");
                System.out.println("---------");
                System.out.println("");
                studentMenu(Globant, studentID);
                break;

            /**case 3:
                // Remove Teacher from Course
                System.out.println("");
                System.out.println("Please type the course ID:");
                int teacherRemoveCourseID = usr.nextInt();
                System.out.println("");
                System.out.println(removeTeacherFromClass(teacherRemoveCourseID));
                System.out.println("");
                System.out.println("---------");
                System.out.println("");
                teacherMenu(Globant, teacherName);
                break;
            case 4:
                System.out.println("");
                System.out.println("---------");
                System.out.println("");
                mainMenu(Globant);
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("");
                System.out.println("Not valid. Please select the correct number");
                System.out.println("");
                System.out.println("---------");
                System.out.println("");
                teacherMenu(Globant, teacherName);
                break;
             **/
        }
    }
}