package org.globant.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    // Methods to add
    public static void addTeacher(Teacher teacher){
        listOfTeachers.add(teacher);
    }
    public static void addStudent(Student student){
        listOfStudents.add(student);
    }
    public static void addCourse(Course course){
        listOfCourses.add(course);
    }


    // Find Teacher
    public static boolean findTeacher(String teacher){
        // return listOfTeachers.contains(teacher);

        for (Teacher listOfTeacher : listOfTeachers) {
            if (Objects.equals(listOfTeacher.getName(), teacher)) {
                return true;
            }
        }
        return false;
    }


    // Find Student
    public static boolean findStudent(int studentID) {
        for (int i = 0; i < listOfStudents.size(); i++) {
            if (listOfStudents.get(i).getId() == studentID) {
                return true;
            }
        }
        return false;
    }


    // Teacher courses
    public static String teacherCourses(String teacherName){
        List<String> teacherCourse;
        teacherCourse = new ArrayList<>();

        for (int i = 0; i < listOfCourses.size(); i++) {
            System.out.println("1");

            if (listOfCourses.get(i).getTeacherName().equals(teacherName)){
                System.out.println("2");
                teacherCourse.add(String.valueOf(listOfCourses.get(i)));
            }
        }
        System.out.println("3");
        return teacherCourse.toString();
    }


    // assign teacher to class
    public static String assignTeacher(int courseID, String teacherName){
        for (int i = 0; i < listOfCourses.size(); i++) {
            if (Objects.equals(listOfCourses.get(i).getCourseId(), courseID)){
                Course.setTeacherName(teacherName);
                return("Teacher set to Course: " + listOfCourses.get(i).getName());
            }
        }
        return("Course ID not found. Could not assign teacher to Course.");
    }
}
