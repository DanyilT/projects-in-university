public class Exercise2 {
	public static void main(String[] args) {
		Car car1 = new Car("qwerty", "qwerty");
		Car car2 = new Car("idk", "purple");

		System.out.println("First Car name is " + car1.name + " and colour = " + car1.colour);
		System.out.printf("Second Car name is %s and colour is %s", car2.name, car2.colour);
	}
}

class Car {
	String name;
	String colour;

	Car(String name, String colour) {
		this.name = name;
		this.colour = colour;
	}
}
