public class Athlete extends Person {
    private String club;

    public Athlete(String name, String club) {
        super(name);
        this.club = club;
    }

    @Override
    public String toString() {
        return super.toString() + ", Club: " + club;
    }
}
