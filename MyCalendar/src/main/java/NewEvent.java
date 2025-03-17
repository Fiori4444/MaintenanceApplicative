import java.time.LocalDateTime;

public class NewEvent extends Event {

    public NewEvent(/*String type,*/ String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, String lieu, String participants, int frequenceJours) {
        super(/*type,*/ title, proprietaire, dateDebut, dureeMinutes, frequenceJours);
    }

    public String description() {
        return "NewEvent : " + title + " à " + dateDebut.toString();
    }
}
