package ValueObjects;

import Events.Event;
import com.sun.beans.decoder.ValueObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ListEvent {

    private List<Event> events;

    public ListEvent() {
        events = new ArrayList<Event>();
    }

    public List<Event> getEvents() {
        return events;
    }

    public void addEvents(Event event) {
        this.events.add(event);
    }

    public List<Event> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        List<Event> result = new ArrayList<>();
        for (Event e : events) {
            if (e instanceof Events.PeriodiqueEvent) {
                LocalDateTime temp = e.dateDebut.getDateDebut();
                while (temp.isBefore(fin)) {
                    if (!temp.isBefore(debut)) {
                        result.add(e);
                        break;
                    }
                    temp = temp.plusDays(((Events.PeriodiqueEvent) e).getFrequenceJours().getFrequence());
                }
            } else if (!e.dateDebut.getDateDebut().isBefore(debut) && !e.dateDebut.getDateDebut().isAfter(fin)) {
                result.add(e);
            }
        }
        return result;
    }

    public boolean conflit(Event e1, Event e2) {
        boolean result = false;
        LocalDateTime fin1 = e1.dateDebut.getDateDebut().plusMinutes(e1.dureeMinutes.getDureeMinutes());
        LocalDateTime fin2 = e2.dateDebut.getDateDebut().plusMinutes(e2.dureeMinutes.getDureeMinutes());

        if (e1 instanceof Events.PeriodiqueEvent || e2 instanceof Events.PeriodiqueEvent) {
            result = false;
        } else if (e1.dateDebut.getDateDebut().isBefore(fin2) && fin1.isAfter(e2.dateDebut.getDateDebut())){
            result = true;
        }

        return result;
    }
}
