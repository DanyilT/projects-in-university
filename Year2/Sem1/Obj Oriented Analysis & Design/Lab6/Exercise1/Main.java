import tudublin.Programme;
import tudublin.Student;

public class Main {
    public static void main(String[] args) {
        // Create a Programme object
        Programme hcert = new Programme();
        hcert.setName("HCert Computing");
        hcert.setLevel(6);

        // Create a Student object
        Student student1 = new Student();
        student1.setName("Joelle Murphy");
        student1.setProgramme(hcert);

        // Print the objects
        System.out.println(hcert);
        System.out.println(student1);
    }
}
