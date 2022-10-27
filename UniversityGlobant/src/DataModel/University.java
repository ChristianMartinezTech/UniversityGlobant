package DataModel;

import java.util.ArrayList;
import java.util.List;

public class University {
    private static List<Teacher> listOfTeachers;
    private static List<Student> listOfStudents;
    private static List<Course> listOfCourses;

    // Getters
    public static List<Teacher> getListOfTeachers() {
        return listOfTeachers;
    }
    public static List<Student> getListOfStudents() {
        return listOfStudents;
    }
    public static List<Course> getListOfCourses() {
        return listOfCourses;
    }

    // Constructor
    public University(){
        listOfTeachers = new ArrayList<>();
        listOfStudents = new ArrayList<>();
        listOfCourses = new ArrayList<>();
    }

    // Methods
    public static void addTeacher(Teacher teacher){
        listOfTeachers.add(teacher);
    }
    public static void addStudent(Student student){
        listOfStudents.add(student);
    }
    public static void addCourse(Course course){
        listOfCourses.add(course);
    }
}
