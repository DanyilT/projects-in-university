public class Main {
	public static void main(String[] args) {
		Car car1 = new Car("qwerty", "qwerty");
		Car car2 = new Car("idk", "purple");

		System.out.println("First Car make is " + car1.make + " and colour = " + car1.colour);
		System.out.printf("Second Car make is %s and colour is %s", car2.make, car2.colour);
	}
}
