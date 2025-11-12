package tudublin;

public class Student {
    private String name;
    private Programme programme;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    @Override
    public String toString() {
        return "(Student) name = " + name + " / programme = " + programme;
    }
}
