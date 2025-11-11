import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeWriter {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Smith", 47000.00));
        employees.add(new Employee("Karen Jones", 55000.00));
        employees.add(new Employee("Alan Buffet", 120000.00));
        employees.add(new Employee("Sally Ryan", 210000.00));

        try (DataOutputStream dout = new DataOutputStream(new FileOutputStream("employees.dat"))) {
            for (Employee employee : employees) {
                employee.put(dout);
            }
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }
    }
}
