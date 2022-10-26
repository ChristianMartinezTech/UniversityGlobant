package DataModel;

import java.util.Arrays;

public class Course {
    private String name;
    private int classroom;
    private String teacherName;
    private String[] courseStudents;

    // Getter
    public String getName() {
        return name;
    }
    public int getClassroom() {
        return classroom;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String[] getCourseStudents() {
        return courseStudents;
    }

    // Setter

    public void setName(String name) {
        this.name = name;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setCourseStudents(String[] courseStudents) {
        this.courseStudents = courseStudents;
    }

    // Constructor
    public Course(String name, int classroom, String[] courseStudents, String teacherName){
        setName(name);
        setClassroom(classroom);
        setCourseStudents(courseStudents);
        setTeacherName(teacherName);
    }

    // Methods
    @Override
    public String toString(){
        return "Course name: " + this.name + ". Classroom: " + this.classroom + ". Students: " + Arrays.toString(this.courseStudents) + ". Teacher: " + teacherName + ".";
    }

    public String showCourseDetails(){
        return toString();
    }


}
