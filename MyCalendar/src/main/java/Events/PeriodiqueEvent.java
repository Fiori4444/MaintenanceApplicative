package Events;

import ValueObjects.FrequenceEvenement;

import java.time.LocalDateTime;

public class PeriodiqueEvent extends Event {

    private FrequenceEvenement frequenceJours; // uniquement pour PERIODIQUE

    public PeriodiqueEvent(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, int frequenceJours) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.frequenceJours.setFrequenceJours(frequenceJours);
    }

    public String description() {
        return "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
    }
}
