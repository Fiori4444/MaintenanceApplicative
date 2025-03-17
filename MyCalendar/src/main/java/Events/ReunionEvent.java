package Events;

import ValueObjects.LieuEvenement;
import ValueObjects.ParticipantsEvenement;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReunionEvent extends Event {

    public LieuEvenement lieu;
    public ParticipantsEvenement participants;

    public ReunionEvent(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, String lieu, ArrayList<String> participants) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.lieu.setLieu(lieu);
        this.participants.setParticipants(participants);
    }

    public String description() {
        return "Réunion : " + title + " à " + lieu + " avec " + participants;
    }
}
