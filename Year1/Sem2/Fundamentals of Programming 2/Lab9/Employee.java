public class Employee extends Person {
    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary: " + salary;
    }
}
