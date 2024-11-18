import kennel.*;
import people.*;

public class Main
{
    public static void main(String[] args) {
        System.out.println(Booking.getMaxDuration());

        Owner ownerMatt = new Owner();
        ownerMatt.setName("matt");
        ownerMatt.setPhone("086-111-2222");

        String[] address1 = new String[2];
        address1[0] = "10 high street";
        address1[1] = "Castleknock";
        ownerMatt.setAddress(address1);

        Dog dog1 = new Dog();
        dog1.setName("fido");
        dog1.setDob("2000-01-01");
        dog1.setFullyVaccinated(true);
        dog1.owner = ownerMatt;

        Booking booking1 = new Booking("2022-10-01", 7);
        booking1.dog = dog1;
        booking1.kennel = KennelType.SHARED;

        System.out.println(ownerMatt);
        System.out.println(dog1);
        System.out.println(booking1);

        System.out.println(Booking.getMaxDuration());
    }
}
