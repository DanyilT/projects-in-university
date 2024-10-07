package Exercise1;

public class Main {
    public static void main(String[] args) {
        FamilyTicket family1 = new FamilyTicket();
        FamilyTicket family2 = new FamilyTicket();

        family1.setFamilyName("Smith");
        family1.setNumberTravelling(3);

        family2.setFamilyName("Johnson");
        family2.setNumberTravelling(6);

        System.out.println("Family 1: " + family1.getFamilyName() + ", Number Travelling: " + family1.getNumberTravelling());
        System.out.println("Family 2: " + family2.getFamilyName() + ", Number Travelling: " + family2.getNumberTravelling());
        System.out.println("Max people allowed: " + FamilyTicket.getMaxPeople());
    }
}
