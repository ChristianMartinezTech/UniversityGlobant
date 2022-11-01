package org.globant.view;

import org.globant.data.*;
import org.globant.persistence.DataInitializer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static org.globant.data.University.*;

public class Main {
    public static void main(String[] args) {
        // Initializing data
        University Globant = DataInitializer.preInfoSetup();

        // Executing the program menu
        mainMenu(Globant);
    }

    public static void mainMenu(University Globant){
        Scanner usr = new Scanner(System.in);
        System.out.println("Hi there.");
        System.out.println("Welcome to Globant University");
        System.out.println("·········");
        System.out.println("");
        System.out.println("1. Type 1 for Teacher");
        System.out.println("2. Type 2 for Student");
        System.out.println("3. Type 3 to show a specific course information");
        System.out.println("4. Type 4 to show all courses information");
        System.out.println("5. Type 5 to show all teachers information");
        System.out.println("6. Type 6 to show all students information");
        System.out.println("7. Type 7 to create a new Student");
        System.out.println("8. Type 8 to create a new Teacher");
        System.out.println("9. Type 9 to create a new Course");
        System.out.println("0. Type 0 to exit");

        try{
            int usrOption = usr.nextInt();
            menuOptions(usrOption, Globant);
        } catch (java.util.InputMismatchException exception){
            System.out.println("");
            System.out.println("Incorrect input. Please input the correct options");
            System.out.println("");
            System.out.println("---------");
            System.out.println("");
            mainMenu(Globant);
        }
    }


    public static void menuOptions(int usrOption, University Globant){
        Scanner usr = new Scanner(System.in);
        switch(usrOption){
            case 1:
                teacherVerification(Globant);
                break;

            case 2:
                studentVerification(Globant);
                break;

            case 3:
                System.out.println("");
                specificCourseInfo(Globant);
                mainMenu(Globant);
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
                System.out.println("");
                System.out.println("Please input the student name:");
                System.out.println("");
                String studentName = usr.nextLine();

                System.out.println("");
                System.out.println("Thank you. Please input the age:");
                System.out.println("");
                int studentAge = usr.nextInt();

                new Student(studentName, studentAge);
                System.out.println("Student Created");
                System.out.println("");
                System.out.println("---------");
                System.out.println("");
                mainMenu(Globant);
                break;

            case 8:
                System.out.println("");
                System.out.println("Please input the teacher name:");
                System.out.println("");
                String teacherName = usr.nextLine();

                System.out.println("");
                System.out.println("Please input the teacher's base salary:");
                System.out.println("");
                float teacherSalary = usr.nextFloat();

                System.out.println("");
                System.out.println("Is this a full time teacher?");
                System.out.println("1. type 1 for yes");
                System.out.println("2. type 2 for no");
                System.out.println("");
                int teacherFullTime = usr.nextInt();
                System.out.println("");

                if (teacherFullTime == 1){
                    System.out.println("Please input the years of experience");
                    System.out.println("");
                    int teacherYearsExperience = usr.nextInt();

                    new FullTimeTeacher(teacherName, teacherSalary, teacherYearsExperience);
                    System.out.println("Full time teacher Created");
                } else if (teacherFullTime == 2) {
                    System.out.println("Please input the weekly working hours");
                    System.out.println("");
                    int teacherHours = usr.nextInt();

                    new PartTimeTeacher(teacherName, teacherSalary, teacherHours);
                    System.out.println("Part time teacher Created");
                } else{
                    System.out.println("Incorrect Input");
                }

                System.out.println("");
                System.out.println("---------");
                System.out.println("");
                mainMenu(Globant);
                break;

            case 9:
                System.out.println("");
                System.out.println("Please input the course name:");
                System.out.println("");
                String courseName = usr.nextLine();

                System.out.println("");
                System.out.println("Please input the course class room:");
                System.out.println("");
                int courseClassRoom = usr.nextInt();
                String skippingNewline = usr.nextLine();

                System.out.println("");
                System.out.println("Please input the teacher name:");
                String courseTeacher = usr.nextLine();

                if (findTeacher(courseTeacher)){
                    List<Student> studentsCourse = new ArrayList<>();

                    new Course(courseName, courseClassRoom, studentsCourse, courseTeacher);
                    System.out.println("");
                    System.out.println("Course created");
                    System.out.println("Please add students from the Student option in the main menu");
                    System.out.println("");
                } else {
                    System.out.println("");
                    System.out.println("Couldn't find teacher. Please make sure to input the full name.");
                    System.out.println("");
                }

                System.out.println("");
                System.out.println("---------");
                System.out.println("");
                mainMenu(Globant);
                break;

            case 0:
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
            System.out.println("");
            System.out.println("Teacher NOT found. Please type in your full name with this format: \\\"Globant Teacher\\\"");
            System.out.println("");
            System.out.println("---------");
            System.out.println("");
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
            System.out.println("---------");
            System.out.println("");
            mainMenu(Globant);
        }
    }

    private static void studentMenu(University Globant, int studentID) {
        Scanner usr = new Scanner(System.in);
        System.out.println("");
        String studentname = findStudentName(studentID);
        System.out.println(studentname);
        System.out.println("");

        System.out.println("1. Type 1 to see all your Courses");
        System.out.println("2. Type 2 to assign yourself a course");
        System.out.println("3. Type 3 to remove yourself from a course");
        System.out.println("4. Type 4 to go back to the previous menu");
        System.out.println("5. Type 5 to exit");

        int studentChoose = usr.nextInt();
        switch (studentChoose) {
            case 1:
                // Print all student Courses
                System.out.println("");
                System.out.println("Your active courses are:");
                System.out.println("");
                for (int i = 0; i < University.studentCourses(studentID).size(); i++) {
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

            case 3:
                // Remove Student from Course
                System.out.println("");
                System.out.println("Please type the course ID:");
                int removeFromCourseID = usr.nextInt();
                System.out.println("");
                System.out.println(University.removeStudentFromClass(studentID, removeFromCourseID));
                System.out.println("");
                System.out.println("---------");
                System.out.println("");
                studentMenu(Globant, studentID);
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
                studentMenu(Globant, studentID);
                break;
        }
    }

        private static void specificCourseInfo(University Globant){
            Scanner course = new Scanner(System.in);
            System.out.println("");
            System.out.println("Please input the course ID");
            int courseID = course.nextInt();

            if (University.courseExists(courseID)) {
                System.out.println(University.courseDetails(courseID));

            } else {
                System.out.println("");
                System.out.println("Course NOT found. Please type in the correct course ID.");

            }

            System.out.println("");
            System.out.println("---------");
            System.out.println("");
        }
}