package ValueObjects;

import java.time.LocalDateTime;

public class DateDebut {
    private LocalDateTime dateDebut;

    public DateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }
}
