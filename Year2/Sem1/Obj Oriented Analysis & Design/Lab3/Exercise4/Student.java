package Exercise4;

public class Student {
    private String name;
    private Integer year;
    public static int numStudentObjects = 0;

    public Student(String name, Integer year) {
        this.name = name;
        this.year = year;
        numStudentObjects++;

        System.out.println("created student" + numStudentObjects);
        System.out.println("num student objects = " + Student.numStudentObjects);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
