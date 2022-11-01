package org.globant.data;

/***
 * PartTimeTeacher class
 * Inherits from the Teacher class
 */
public class PartTimeTeacher extends Teacher{
    private int weeklyHours;

    // Constructor
    public PartTimeTeacher(String name, float baseSalary, int weeklyHours){
        super(name, baseSalary);
        this.weeklyHours = weeklyHours;
        this.setFullTime(false);
    }

    // Getter
    public int getWeeklyHours() {
        return weeklyHours;
    }

    // Setter
    public void setWeeklyHours(int weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    /***
     * Calculates the salary of the PartTimeTeacher
     * @return float with the PartTimeTeacher salary
     */
    public float calculateSalary(){
        float salary = getBaseSalary();
        return salary * weeklyHours;
    }
}
