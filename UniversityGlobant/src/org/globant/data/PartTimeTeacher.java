package org.globant.data;

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

    // Methods
    public float calculateSalary(){
        float salary = getBaseSalary();
        return salary * weeklyHours;
    }
}
