package DataModel;

public class FullTimeTeacher extends Teacher{
    private int expYears;

    // Getter
    public int getExpYears(){
        return expYears;
    }

    //Setter
    public void setExpYears(int expYears) {
        this.expYears = expYears;
    }

    // Constructor
    public FullTimeTeacher(String name, float baseSalary, int expYears){
        super(name, baseSalary);
        setExpYears(expYears);
        this.setFullTime(true);
    }

    // Methods
    public float calculateSalary(){
        float salary = getBaseSalary();
        return salary * 1.1f * expYears;
    }
}
