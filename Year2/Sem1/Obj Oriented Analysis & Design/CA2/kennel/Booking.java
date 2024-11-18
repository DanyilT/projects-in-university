package kennel;

public class Booking {
    public String dateArrive;
    private int durationDay;
    public KennelType kennel;
    private static int maxDuration = -1;
    public Dog dog;

    public Booking(String dateArrive, int durationDay) {
        this.dateArrive = dateArrive;
        this.durationDay = durationDay;
        if (durationDay > Booking.maxDuration) {
            Booking.maxDuration = durationDay;
        }
    }

    public int getDurationDay() {
        return durationDay;
    }

    public void setDurationDay(int durationDay) {
        this.durationDay = durationDay;
        if (durationDay > Booking.maxDuration) {
            Booking.maxDuration = durationDay;
        }
    }

    public static int getMaxDuration() {
        return Booking.maxDuration;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "dateArrive='" + dateArrive + '\'' +
                ", durationDay=" + durationDay +
                ", kennel=" + kennel +
                ", maxDuration=" + maxDuration +
                ", dog=" + dog +
                '}';
    }
}
