package org.globant.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/***
 * University class keeps track of the Student, Teacher, and Course classes and interacts with the main
 */
public class University {
    private static List<Teacher> listOfTeachers;
    private static List<Student> listOfStudents;
    private static List<Course> listOfCourses;

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

    /***
     * Adds a teacher object to the list of teachers
     * @param teacher Object
     */
    public static void addTeacher(Teacher teacher){
        listOfTeachers.add(teacher);
    }

    /***
     * Adds a student object to the list of students
     * @param student object
     */
    public static void addStudent(Student student){
        listOfStudents.add(student);
    }

    /***
     * Adds a Student object to the list of students
     * @param course object
     */
    public static void addCourse(Course course){
        listOfCourses.add(course);
    }

    /***
     * finds a teacher in the listOfTeachers ArrayList
     * @param teacher name
     * @return boolean depending on whether it finds the teacher
     */
    public static boolean findTeacher(String teacher){
        // return listOfTeachers.contains(teacher);

        for (Teacher listOfTeacher : listOfTeachers) {
            if (Objects.equals(listOfTeacher.getName(), teacher)) {
                return true;
            }
        }
        return false;
    }

    /***
     * finds the courses witch teacherName teaches
     * @param teacherName name of the teacher
     * @return list with the courses teacherName teaches
     */
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

    /***
     * Assings a teacher to a course
     * @param courseID id of the desired course
     * @param teacherName name of the teacher to add
     * @return String indicating whether the teacher was successfully added
     */
    public static String assignTeacher(int courseID, String teacherName){
        for (int i = 0; i < listOfCourses.size(); i++) {
            if (Objects.equals(listOfCourses.get(i).getCourseId(), courseID)){
                listOfCourses.get(i).setTeacherName(teacherName);
                return("Teacher set to Course: " + listOfCourses.get(i).getName());
            }
        }
        return("Course ID not found. Could not assign teacher to Course.");
    }

    /***
     * Removes teacher from course
     * @param courseID id of the course
     * @return String indicating whether the teacher was successfully removed
     */
    public static String removeTeacherFromClass(int courseID){
        for (int i = 0; i < listOfCourses.size(); i++) {
            if (Objects.equals(listOfCourses.get(i).getCourseId(), courseID)){
                listOfCourses.get(i).setTeacherName("");
                return("Teacher removed from course: " + listOfCourses.get(i).getName());
            }
        }
        return("Course ID not found. Could not assign teacher to Course.");
    }

    /***
     * Finds a student by id in listOfStudents
     * @param studentID id of the student
     * @return true or false indicating if the student was found
     */
    public static boolean findStudent(int studentID) {
        for (int i = 0; i < listOfStudents.size(); i++) {
            if (listOfStudents.get(i).getId() == studentID) {
                return true;
            }
        }
        return false;
    }

    /***
     * Finds the name of the student by using its id
     * @param studentID id of the student
     * @return String indicating whether the name of the student was found
     */
    public static String findStudentName(int studentID){
        for (int i = 0; i < listOfStudents.size(); i++) {
            if (listOfStudents.get(i).getId() == studentID) {
                return listOfStudents.get(i).getName();
            }
        }
        return "Student Name not found";
    }

    /***
     * Returns the list of the courses the student with studentID is enrolled in
     * @param studentID id of the student
     * @return list with the courses enrolled in
     */
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

    /***
     * Finds a course by its id
     * @param courseID course id
     * @return String with the course name
     */
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

    /***
     * Returns the student Class found by studentID
     * @param studentID student id
     * @return Student Class found
     */
    public static Student studentClass(int studentID){
        Student referencedStudent = null;

        for (int i = 0; i < listOfStudents.size(); i++){
            if (listOfStudents.get(i).getId() == studentID){
                referencedStudent = listOfStudents.get(i);
            }
        }
        return referencedStudent;
    }

    /***
     * Adds a student to a course
     * @param studentID student id
     * @param courseID course id
     * @return String indicating if the student was suscessfully added to course
     */
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

    /***
     * removes student from course
     * @param studentID student id
     * @param courseID course id
     * @return String indicating if the student was suscessfully removed from course
     */
        public static String removeStudentFromClass(int studentID, int courseID){
            List studentCourses = studentCourses(studentID);
            String courseName = findCourseByID(courseID);

            if (studentCourses.contains(courseName)) {
                for (int i = 0; i < listOfCourses.size(); i++) {
                    if (Objects.equals(listOfCourses.get(i).getCourseId(), courseID)) {

                        listOfCourses.get(i).removeStudent(studentClass(studentID));
                        return "Student removed from class";
                    }
                }
            }
            return ("Student already not in said class");
        }

    /***
     * checks if said course exists
     * @param courseID course id
     * @return boolean indicatinf if the course exists
     */
    public static boolean courseExists(int courseID){
        boolean exists = false;

        for (int i = 0; i < listOfCourses.size(); i++){
            if (listOfCourses.get(i).getCourseId() == courseID){
                exists = true;
            }
        }
        return exists;
    }

    /***
     * checks the course details
     * @param courseID course id
     * @return String with the course details
     */
    public static String courseDetails(int courseID){
        String details = "";
        for (int i = 0; i < listOfCourses.size(); i++){
            if (listOfCourses.get(i).getCourseId() == courseID){
                details = listOfCourses.get(i).showCourseDetails();
            }
        }
        return details;
    }
}