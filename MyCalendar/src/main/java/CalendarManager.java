import Events.Event;
import ValueObjects.ListEvent;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {
    public ListEvent events;

    public CalendarManager() {
        events = new ListEvent();
    }

    public void ajouterEvent(Event event) {
        events.addEvents(event);
    }

    public void afficherEvenements() {
        for (Event e : events.getEvents()) {
            System.out.println(e.description());
        }
    }
}