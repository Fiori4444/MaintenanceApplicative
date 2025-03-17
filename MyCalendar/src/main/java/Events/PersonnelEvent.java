package Events;

import java.time.LocalDateTime;

public class PersonnelEvent extends Event {

    public PersonnelEvent(/*String type,*/ String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, String lieu, String participants) {
        super(/*type,*/ title, proprietaire, dateDebut, dureeMinutes);
    }

    public String description() {
        return "RDV : " + title + " à " + dateDebut.toString();
    }
}
