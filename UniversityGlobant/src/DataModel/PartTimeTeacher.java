package DataModel;

public class PartTimeTeacher extends Teacher{
    private int weeklyHours;

    // Getter
    public int getWeeklyHours() {
        return weeklyHours;
    }

    // Setter
    public void setWeeklyHours(int weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    // Constructor
    public PartTimeTeacher(String name, float baseSalary, int weeklyHours){
        super(name, baseSalary);
        setWeeklyHours(weeklyHours);
        this.setFullTime(false);
    }

    // Methods
    public float calculateSalary(){
        float salary = getBaseSalary();
        return salary * weeklyHours;
    }
}
