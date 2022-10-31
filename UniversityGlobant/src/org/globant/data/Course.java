package org.globant.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


    // Methods
    @Override
    public String toString(){
        return "Course name: " + this.name + ". Teacher: " + teacherName + ". Course ID: " + this.courseId + ". Classroom: " + this.classroom + ". Students: " + this.courseStudents + ".";
    }

    // Print course details
    public String showCourseDetails(){
        return toString();
    }

    // Add student Method
    public void addStudent(Student newStudent){
        this.courseStudents.add(newStudent);
    }

    // Remove student method
    public void removeStudent(Student newStudent){
        this.courseStudents.remove(newStudent);
    }
}
