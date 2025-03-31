package Events;

import ValueObjects.ListEvent;

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