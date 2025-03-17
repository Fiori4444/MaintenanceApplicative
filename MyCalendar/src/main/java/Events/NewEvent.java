package Events;

import java.time.LocalDateTime;

public class NewEvent extends Event {

    public NewEvent(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes);
    }

    public String description() {
        return "Events.NewEvent : " + title + " à " + dateDebut.toString();
    }
}
