package Exercise4;

public class Main {
    public static void main(String[] args) {
        System.out.println("num student objects = " + Student.numStudentObjects);

        Student student1 = new Student("Dany", 1);
        System.out.println("created student1");
        System.out.println("num student objects = " + Student.numStudentObjects);

        Student student2 = new Student("qwerty", 2);
        System.out.println("created student2");
        System.out.println("num student objects = " + Student.numStudentObjects);
    }
}
