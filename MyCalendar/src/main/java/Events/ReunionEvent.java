package Events;

import ValueObjects.LieuEvenement;
import ValueObjects.ParticipantsEvenement;

import java.time.LocalDateTime;

public class ReunionEvent extends Event {

    public LieuEvenement lieu; // utilisé seulement pour REUNION
    public ParticipantsEvenement participants; // séparés par virgules (pour REUNION uniquement)

    public ReunionEvent(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, String lieu, String participants) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.lieu.setLieu(lieu);
        this.participants.setParticipants(participants);
    }

    public String description() {
        return "Réunion : " + title + " à " + lieu + " avec " + participants;
    }
}
