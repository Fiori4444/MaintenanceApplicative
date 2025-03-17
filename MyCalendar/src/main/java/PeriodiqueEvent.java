import java.time.LocalDateTime;

public class PeriodiqueEvent extends Event {

    public PeriodiqueEvent(/*String type,*/ String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, String lieu, String participants, int frequenceJours) {
        super(/*type,*/ title, proprietaire, dateDebut, dureeMinutes, frequenceJours);
    }

    public String description() {
        return "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
    }
}
