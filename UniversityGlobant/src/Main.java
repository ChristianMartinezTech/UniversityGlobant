import DataModel.FullTimeTeacher;
import DataModel.PartTimeTeacher;

public class Main {
    public static void main(String[] args) {
        // Trying to instantiate FullTimeTeacher
        FullTimeTeacher Carlos = new FullTimeTeacher("Carlos", 32.5f, 7);
        System.out.println("Name: " + Carlos.getName());
        System.out.println("Base Salary: " + Carlos.getBaseSalary());
        System.out.println("Experience Years: " + Carlos.getExpYears());
        System.out.println("Full Time: " + Carlos.getFullTime());
        System.out.println("Salary: " + Carlos.calculateSalary());
        System.out.println("------------------");

        // Trying to instantiate FullTimeTeacher
        PartTimeTeacher Alfonso = new PartTimeTeacher("Alfonso", 15.1f, 20);
        System.out.println("Name: " + Alfonso.getName());
        System.out.println("Base Salary: " + Alfonso.getBaseSalary());
        System.out.println("Weekly Hours: " + Alfonso.getWeeklyHours());
        System.out.println("Full Time: " + Alfonso.getFullTime());
        System.out.println("Salary: " + Alfonso.calculateSalary());
        System.out.println("------------------");
    }
}
