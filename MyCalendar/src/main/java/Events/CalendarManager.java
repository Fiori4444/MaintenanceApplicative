package Events;

import ValueObjects.ListEvent;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Event> eventDansPeriode(LocalDateTime start, LocalDateTime end) {
        return null;
    }
}