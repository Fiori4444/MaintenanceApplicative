import Events.CalendarManager;
import Events.Event;
import Events.PersonnelEvent;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalendarManagerTest {

    @Test
    void testEventDansPeriode() {
        CalendarManager calendarManager = new CalendarManager();
        LocalDateTime start = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2023, 12, 31, 23, 59);

        Event event1 = new PersonnelEvent("Event 1", "user1", LocalDateTime.of(2023, 6, 15, 10, 0), 60);
        Event event2 = new PersonnelEvent("Event 2", "user2", LocalDateTime.of(2024, 1, 1, 10, 0), 60);

        calendarManager.ajouterEvent(event1);
        calendarManager.ajouterEvent(event2);

        List<Event> events = calendarManager.eventDansPeriode(start, end);

        assertEquals(1, events.size());
        assertEquals(event1, events.get(0));
    }
}
