package DataModel;

import java.util.Arrays;

public class Student {
    private String name;
    private int id;
    private int age;

    // Getters
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getId() {
        return id;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setId(int id) {
        this.id = id;
    }

    // Constructor
    public Student(String name, int age){
        setName(name);
        setAge(age);
        setNewId();
        University.addStudent(this);
    }

    // Methods
    private void setNewId(){
        setId(1); // Configure this from University Class
    };

    @Override
    public String toString(){
        return "Student name: " + this.name +  ". Student ID: " + this.id + ". Age: " + this.age + ".";
    }
}
