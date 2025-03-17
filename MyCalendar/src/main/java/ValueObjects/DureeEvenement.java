package ValueObjects;

public class DureeEvenement {
    private int dureeMinutes;

    public DureeEvenement(int dureeMinutes) {
        this.dureeMinutes = dureeMinutes;
    }

    public int getDureeMinutes() {
        return dureeMinutes;
    }

    public void setDureeMinutes(int dureeMinutes) {
        this.dureeMinutes = dureeMinutes;
    }
}
