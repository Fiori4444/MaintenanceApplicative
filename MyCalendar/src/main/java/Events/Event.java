package Events;

import ValueObjects.*;
import java.time.LocalDateTime;

public abstract class Event {
    public TitreEvenement title;
    public ProprietaireEvenement proprietaire;
    public DateDebut dateDebut;
    public DureeEvenement dureeMinutes;

    public Event(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes) {
        this.title = new TitreEvenement(title);
        this.proprietaire = new ProprietaireEvenement(proprietaire);
        this.dateDebut = new DateDebut(dateDebut);
        this.dureeMinutes = new DureeEvenement(dureeMinutes);
    }

    public abstract String description();

    public DateDebut getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(DateDebut dateDebut) {
        this.dateDebut = dateDebut;
    }
}