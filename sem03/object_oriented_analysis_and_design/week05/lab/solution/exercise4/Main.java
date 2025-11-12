public class Main {
    public static void main(String[] args) {
        // Create instance-object of abstract class Building, which is not allowed (abstract classes cannot be instantiated)
        // Building building = new Building(); // Uncommenting this line will cause a compiler errors

        // Create instance-objects of classes House and Warehouse
        House house = new House();
        house.setAddress("24 Main Street");
        house.setSizeMetersSquared(2000);
        house.setNumBedrooms(3);
        house.setNumBathrooms(2);

        Warehouse warehouse = new Warehouse();
        warehouse.setAddress("100 Industrial Road");
        warehouse.setSizeMetersSquared(5000);
        warehouse.setMainGoodsType("Electronics");

        System.out.println(house);
        System.out.println(warehouse);
    }
}
