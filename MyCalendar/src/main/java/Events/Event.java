package Events;

import ValueObjects.*;
import java.time.LocalDateTime;

public abstract class Event {
    public TitreEvenement title;
    public ProprietaireEvenement proprietaire;
    public DateDebut dateDebut;
    public DureeEvenement dureeMinutes;

    public Event(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes) {
        this.title.setTitle(title);
        this.proprietaire.setProprietaire(proprietaire);
        this.dateDebut.setDateDebut(dateDebut);
        this.dureeMinutes.setDureeMinutes(dureeMinutes);
    }

    public abstract String description();
}