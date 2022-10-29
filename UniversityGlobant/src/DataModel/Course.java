package DataModel;

import java.util.Arrays;

public class Course {
    private int courseId;
    private String name;
    private int classroom;
    private String teacherName;
    private Student[] courseStudents;

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

    public Student[] getCourseStudents() {
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

    public static void setTeacherName(String teacherName) {
        teacherName = teacherName;
    }

    public void setCourseStudents(Student[] courseStudents) {
        this.courseStudents = courseStudents;
    }


    // Constructor
    public Course(String name, int classroom, Student[] courseStudents, String teacherName){
        setNewId();
        setName(name);
        setClassroom(classroom);
        setCourseStudents(courseStudents);
        setTeacherName(teacherName);
        University.addCourse(this);
    }


    // Methods
    @Override
    public String toString(){
        return "Course name: " + this.name +  ". Course ID: " + this.courseId + ". Classroom: " + this.classroom + ". Students: " + Arrays.toString(this.courseStudents) + ". Teacher: " + teacherName + ".";
    }

    public String showCourseDetails(){
        return toString();
    }

    private void setNewId(){
        setCourseId(1); // Configure this from University Class
    };
}
