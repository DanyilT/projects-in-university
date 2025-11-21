import people.*;
import surgery.*;

public class Main {
    public static void main(String[] args) {

        Owner fredTheOwner = new Owner();
        fredTheOwner.setName("Fred");
        fredTheOwner.setPhone("086 888 9999");
        fredTheOwner.setAddress("22 main street, Galway City");

        System.out.println(fredTheOwner);

        Pet fido = new Pet();
        fido.setName("Fido");
        fido.setDetails("Fido is a small, white poodle");
        fido.owner = fredTheOwner;

        System.out.println(fido);

        System.out.println(Vaccination.getNumNeedles());

        Vaccination vaccination1 = new Vaccination(InjectionType.NEEDLE);
        vaccination1.setName("Covid booster");
        vaccination1.setQuantity(100);
        vaccination1.pet = fido;

        System.out.println(vaccination1);

        System.out.println(Vaccination.getNumNeedles());

        try {
            System.out.println("EXCEPTION TEST: fredTheOwner.setAddress(\"\");");
            fredTheOwner.setAddress("");
        } catch (EmptyAddressException e){
            System.out.println("EmptyAddressException occurred");
        } catch (Exception e){
            System.out.println("Exception occurred = " + e.getMessage());
        }

        try {
            System.out.println("EXCEPTION TEST: vaccination1.setQuantity(0);");
            vaccination1.setQuantity(0);
        } catch (EmptyAddressException e){
            System.out.println("EmptyAddressException occurred");
        } catch (Exception e){
            System.out.println("Exception occurred = " + e.getMessage());
        }
    }
}
