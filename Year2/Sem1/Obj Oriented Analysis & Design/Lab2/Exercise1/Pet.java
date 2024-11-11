public class Pet {
    private String name;
    private String type;
    private int age;

    public Pet(String name, String type) {
        this.name = name;
        this.type = type;
        this.age = 5;
    }

    public Pet(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "(PET) " + name + " is a " + type + ", and is " + age + " years old.";
    }
}
