import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeReader {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        
        try (DataInputStream din = new DataInputStream(new FileInputStream("employees.dat"))) {
            while (din.available() > 0) {
                Employee employee = new Employee();
                employee.get(din);
                employees.add(employee);
            }
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
