package Events;

import java.time.LocalDateTime;

public class NewEvent extends Event {

    public NewEvent(/*String type,*/ String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, String lieu, String participants, int frequenceJours) {
        super(/*type,*/ title, proprietaire, dateDebut, dureeMinutes);
    }

    public String description() {
        return "Events.NewEvent : " + title + " à " + dateDebut.toString();
    }
}
