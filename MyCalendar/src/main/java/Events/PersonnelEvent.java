package Events;

import java.time.LocalDateTime;

public class PersonnelEvent extends Event {

    public PersonnelEvent(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes);
    }

    public String description() {
        return "RDV : " + title + " à " + dateDebut.toString();
    }
}
