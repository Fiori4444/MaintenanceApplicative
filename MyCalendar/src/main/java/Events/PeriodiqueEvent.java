package Events;

import ValueObjects.FrequenceEvenement;
import ValueObjects.TitreEvenement;

import java.time.LocalDateTime;

public class PeriodiqueEvent extends Event {

    private FrequenceEvenement frequenceJours;

    public PeriodiqueEvent(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, int frequenceJours) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.frequenceJours = new FrequenceEvenement(frequenceJours);
    }

    public String description() {
        return "Événement périodique : " + title.getTitle() + " tous les " + frequenceJours.getFrequence() + " jours";
    }

    public FrequenceEvenement getFrequenceJours() {
        return frequenceJours;
    }

}
