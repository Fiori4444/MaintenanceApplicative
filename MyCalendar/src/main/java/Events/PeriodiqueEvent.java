package Events;

import java.time.LocalDateTime;

public class PeriodiqueEvent extends Event {

    public int frequenceJours; // uniquement pour PERIODIQUE

    public PeriodiqueEvent(/*String type,*/ String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, String lieu, String participants, int frequenceJours) {
        super(/*type,*/ title, proprietaire, dateDebut, dureeMinutes);
        this.frequenceJours = frequenceJours;
    }

    public String description() {
        return "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
    }
}
