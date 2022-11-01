package org.globant.data;


/***
 * Student class
 */
public class Student {
    private String name;
    private int id;
    private int age;

    // Constructor
    public Student(String name, int age){
        this.name = name;
        this.age = age;
        this.id = (int)(Math.random() * 99999);
        University.addStudent(this);
    }

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

    /***
     * Overidin the toString method to print name and id only, in the wnated formatting
     * @return String with the Student name and id
     */
    @Override
    public String toString(){
        return "Student name: " + this.name +  ". Student ID: " + this.id;
    }
}
