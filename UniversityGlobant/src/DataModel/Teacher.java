package DataModel;

public abstract class Teacher{
    private String name;
    private float baseSalary;
    private boolean isFullTime;


    // Getter
    public float getBaseSalary() {
        return baseSalary;
    }
    public String getName() {
        return name;
    }
    public boolean getFullTime(){
        return isFullTime;
    }

    // Setter
    public void setBaseSalary(float baseSalary) {
        this.baseSalary = baseSalary;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setFullTime(boolean fullTime) {
        isFullTime = fullTime;
    }

    // Constructor
    public Teacher(String name, float baseSalary){
        this.setName(name);
        this.setBaseSalary(baseSalary);
        University.addTeacher(this);
    }

    // Methods

    @Override
    public String toString(){
        return "Teacher name: " + this.name +  ". Base salary: " + this.baseSalary + ". Full time: " + this.isFullTime + ".";
    }
}
