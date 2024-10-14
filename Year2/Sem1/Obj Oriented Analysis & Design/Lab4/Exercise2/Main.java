package Exercise2;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Dany", "qwerty");
        Phone phone = new Phone("086 888 1122", person1);

        System.out.println(phone);
    }
}
