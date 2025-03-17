import java.time.LocalDateTime;

public class ReunionEvent extends Event {

    public String lieu; // utilisé seulement pour REUNION
    public String participants; // séparés par virgules (pour REUNION uniquement)

    public ReunionEvent(/*String type,*/ String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, String lieu, String participants, int frequenceJours) {
        super(/*type,*/ title, proprietaire, dateDebut, dureeMinutes, frequenceJours);
        this.lieu = lieu;
        this.participants = participants;
    }

    public String description() {
        return "Réunion : " + title + " à " + lieu + " avec " + participants;
    }
}
