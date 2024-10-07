package Exercise1;

public class FamilyTicket {
    private static final int MAX_PEOPLE = 4;
    private String familyName;
    private Integer numberTravelling;

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Integer getNumberTravelling() {
        return numberTravelling;
    }

    public void setNumberTravelling(Integer numberTravelling) {
        if (numberTravelling <= MAX_PEOPLE) {
            this.numberTravelling = numberTravelling;
        } else {
            System.out.println("Number of travellers exceeds the maximum allowed: " + MAX_PEOPLE);
        }
    }

    public static int getMaxPeople() {
        return MAX_PEOPLE;
    }
}
