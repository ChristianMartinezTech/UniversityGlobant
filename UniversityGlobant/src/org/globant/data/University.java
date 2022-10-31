package org.globant.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class University {
    private static List<Teacher> listOfTeachers;
    private static List<Student> listOfStudents;
    private static List<Course> listOfCourses;

    // Constructor
    public University(){
        listOfTeachers = new ArrayList<>();
        listOfStudents = new ArrayList<>();
        listOfCourses = new ArrayList<>();
    }

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

    // Find all teacher courses
    public static List teacherCourses(String teacherName){
        List<String> teacherCourse;
        teacherCourse = new ArrayList<>();

        for (int i = 0; i < listOfCourses.size(); i++) {
            if (listOfCourses.get(i).getTeacherName().equals(teacherName)){
                teacherCourse.add(String.valueOf(listOfCourses.get(i)));
            }
        }
        return teacherCourse;
    }

    // Assign teacher to Course
    public static String assignTeacher(int courseID, String teacherName){
        for (int i = 0; i < listOfCourses.size(); i++) {
            if (Objects.equals(listOfCourses.get(i).getCourseId(), courseID)){
                listOfCourses.get(i).setTeacherName(teacherName);
                return("Teacher set to Course: " + listOfCourses.get(i).getName());
            }
        }
        return("Course ID not found. Could not assign teacher to Course.");
    }

    // Remove teacher from Course
    public static String removeTeacherFromClass(int courseID){
        for (int i = 0; i < listOfCourses.size(); i++) {
            if (Objects.equals(listOfCourses.get(i).getCourseId(), courseID)){
                listOfCourses.get(i).setTeacherName("");
                return("Teacher removed from course: " + listOfCourses.get(i).getName());
            }
        }
        return("Course ID not found. Could not assign teacher to Course.");
    }

    // Find Student ID
    public static boolean findStudent(int studentID) {
        for (int i = 0; i < listOfStudents.size(); i++) {
            if (listOfStudents.get(i).getId() == studentID) {
                return true;
            }
        }
        return false;
    }

    // Find the Student Name
    public static String findStudentName(int studentID){
        for (int i = 0; i < listOfStudents.size(); i++) {
            if (listOfStudents.get(i).getId() == studentID) {
                return listOfStudents.get(i).getName();
            }
        }
        return "Student Name not found";
    }

    // Find all Student Courses
    public static List studentCourses(int studentID){
        List<String> studentCourse;
        studentCourse = new ArrayList<>();
        String studentName = findStudentName(studentID);

        for (int i = 0; i < listOfCourses.size(); i++) {
            Course course = listOfCourses.get(i);
            List<Student> students = course.getCourseStudents();

            for (int j = 0; j < students.size(); j++){
                if (Objects.equals(students.get(j).getName(), studentName)){
                    studentCourse.add(listOfCourses.get(i).getName());
                }
            }
            }
        return studentCourse;
        }

        // Find course by id
        public static String findCourseByID(int courseID){
            String courseName = "";

            for (int i = 0; i < listOfCourses.size(); i++) {
                Course course = listOfCourses.get(i);
                if (course.getCourseId() == courseID){
                    courseName = course.getName();
                    return courseName;
                }
            }
            return courseName;
        }

        // Return student type
        public static Student studentClass(int studentID){
            Student referencedStudent = null;

            for (int i = 0; i < listOfStudents.size(); i++){
                if (listOfStudents.get(i).getId() == studentID){
                    referencedStudent = listOfStudents.get(i);
                }
            }
            return referencedStudent;
        }

        // Add student to course
        public static String addStudentToCourse(int studentID, int courseID) {
            List studentCourses = studentCourses(studentID);
            String courseName = findCourseByID(courseID);

            if (!studentCourses.contains(courseName)) {
                for (int i = 0; i < listOfCourses.size(); i++) {
                    if (Objects.equals(listOfCourses.get(i).getCourseId(), courseID)) {

                        listOfCourses.get(i).addStudent(studentClass(studentID));
                        return "Student Added to Class";
                    }
                }
            }
            return ("Student already Added to Class");
        }
}