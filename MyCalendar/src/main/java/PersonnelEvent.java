import java.time.LocalDateTime;

public class PersonnelEvent extends Event {

    public PersonnelEvent(/*String type,*/ String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, String lieu, String participants, int frequenceJours) {
        super(/*type,*/ title, proprietaire, dateDebut, dureeMinutes, frequenceJours);
    }

    public String description() {
        return "RDV : " + title + " à " + dateDebut.toString();
    }
}
