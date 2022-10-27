import DataModel.University;

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
        System.out.println("5. Type 4 to exit");

        int usrOption = usr.nextInt();
        menuOptions(usrOption);
    }

    // Methods
    public static void menuOptions(int usrOption){
        switch(usrOption){
            case 1:
                teacherMenu();
            case 2:
                studentMenu();
            case 3:
                specificCourse();
            case 4:
                System.out.println(University.getListOfCourses());
            case 5:
                System.exit(0);
            default:
                System.out.println("Not valid. Please select the correct number");
        }
    }

    public static void teacherMenu(){
        System.out.println("Welcome teacher! Please input your full name:");

    }

    public static void studentMenu(){

    }

    public static void specificCourse(){

    }
}
