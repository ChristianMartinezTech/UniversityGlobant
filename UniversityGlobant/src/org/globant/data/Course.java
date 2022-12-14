package org.globant.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * Course class
 */
public class Course {
    private int courseId;
    private String name;
    private int classroom;
    private String teacherName;
    private List<Student> courseStudents;

    // Constructor
    public Course(String name, int classroom, List<Student> courseStudents, String teacherName){
        this.name = name;
        this.classroom = classroom;
        this.courseStudents = courseStudents;
        this.teacherName = teacherName;
        this.courseId = (int)(Math.random() * 999);
        University.addCourse(this);
    }

    // Getter
    public int getCourseId() {
        return courseId;
    }
    public String getName() {
        return name;
    }
    public int getClassroom() {
        return classroom;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public List<Student> getCourseStudents() {
        return courseStudents;
    }


    // Setter
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public void setTeacherName(String teacherName) {this.teacherName = teacherName;
    }

    public void setCourseStudents(List<Student> courseStudents) {
        this.courseStudents = courseStudents;
    }


    /**
     * Override the toString method
     * @return String with the Course data and desired formatting
     */
    @Override
    public String toString(){
        return "Course name: " + this.name + ". Teacher: " + teacherName + ". Course ID: " + this.courseId + ". Classroom: " + this.classroom + ". Students: " + this.courseStudents + ".";
    }

    /***
     * Gets the course details
     * @return String with the course details
     */
    public String showCourseDetails(){
        return toString();
    }

    /***
     * Adds a student to the courseStudents array list
     * @param newStudent void
     */
    public void addStudent(Student newStudent){
        this.courseStudents.add(newStudent);
    }

    /***
     * Removes a student of the courseStudents array list
     * @param newStudent void
     */
    public void removeStudent(Student newStudent){
        this.courseStudents.remove(newStudent);
    }
}
