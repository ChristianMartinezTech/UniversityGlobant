package DataModel;

abstract class Teacher{
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

    // Methods
    private float calculateSalary(){
        return 0.00f;
    }

    // Constructor
    public Teacher(String name, float baseSalary){
        this.setName(name);
        this.setBaseSalary(baseSalary);
    }

}
