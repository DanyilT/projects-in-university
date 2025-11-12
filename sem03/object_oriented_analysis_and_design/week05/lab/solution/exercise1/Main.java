public class Main {
    public static void main(String[] args) {
        Food food1 = new Food("lettuce", FreshType.FRESH);
        Food food2 = new Food("apple", FreshType.OUT_OF_DATE);

        System.out.println(food1);
        System.out.println(food2);
    }
}
