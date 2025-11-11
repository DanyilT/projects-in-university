import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Employee {
    private String name;
    private double salary;

    public Employee() {}

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void put(DataOutputStream dout) throws IOException {
        dout.writeUTF(name);
        dout.writeDouble(salary);
    }

    public void get(DataInputStream din) throws IOException {
        name = din.readUTF();
        salary = din.readDouble();
    }

    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", salary=" + salary + '}';
    }
}
