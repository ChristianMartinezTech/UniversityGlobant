package org.globant.data;

/***
 * FullTimeTeacher class
 * Inherits from Teacher
 */
public class FullTimeTeacher extends Teacher{
    private int expYears;

    // Constructor
    public FullTimeTeacher(String name, float baseSalary, int expYears){
        super(name, baseSalary);
        this.expYears = expYears;
        this.setFullTime(true);
    }

    // Getter
    public int getExpYears(){
        return expYears;
    }

    //Setter
    public void setExpYears(int expYears) {
        this.expYears = expYears;
    }

    /***
     * Calculates the salary of FullTimeTeacher
     * @return float with the teacher's salary
     */
    public float calculateSalary(){
        float salary = getBaseSalary();
        return salary * 1.1f * expYears;
    }
}
