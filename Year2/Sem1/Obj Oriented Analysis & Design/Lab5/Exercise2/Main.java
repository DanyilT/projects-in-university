package Exercise2;

public class Main {
    public static void main(String[] args) {
        House house1 = new House();
        house1.setAddress("24 Main Street");
        house1.setSizeMetersSquared(2000);
        house1.setNumBedrooms(3);
        house1.setNumBathrooms(2);

        System.out.println(house1);
    }
}
