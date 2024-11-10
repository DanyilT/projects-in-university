// TestCourse class
public class TestCourse {
    public static void main(String[] args) {
        Course course1 = new Course("B.Sc. (Hons) in Computer Science", "Informatics", 4);
        Course course2 = new Course("B.Sc. in Bioinformatics", "Biology", 4);
        Course course3 = new Course("M.Sc. in Applied Artificial Intelligence", "Informatics", 2);

        System.out.println("\nCourse Object 1");
        course1.display();
        
        System.out.println("\nCourse Object 2");
        course2.display();
        
        System.out.println("\nCourse Object 3");
        course3.display();
    }
}

// Course class
public class Course {
    // Instance variables
    private String courseTitle;
    private String faculty;
    private int duration;

    // Constructor
    public Course(String courseTitle, String faculty, int duration) {
        this.courseTitle = courseTitle;
        this.faculty = faculty;
        this.duration = duration;
    }

    // Void Method
    public void display() {
        System.out.println("Course title: " + this.courseTitle);
        System.out.println("Faculty: " + this.faculty);
        System.out.println("Duration: " + this.duration);
    }
}
