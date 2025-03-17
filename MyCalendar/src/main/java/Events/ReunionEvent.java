package Events;

import ValueObjects.FrequenceEvenement;
import ValueObjects.LieuEvenement;
import ValueObjects.ParticipantsEvenement;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReunionEvent extends Event {

    public LieuEvenement lieu;
    public ParticipantsEvenement participants;

    public ReunionEvent(String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes, String lieu, ArrayList<String> participants) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.lieu = new LieuEvenement(lieu);
        this.participants = new ParticipantsEvenement(participants);
    }

    public String description() {
        String res = "";
        res = "Réunion : " + title.getTitle() + " à " + lieu.getLieu() + " avec ";
        for (int i = 0; i < participants.getParticipants().size(); i++) {
            res += participants.getParticipants().get(i);
            if (i != participants.getParticipants().size() - 1) {
                res += ", ";
            }
        }
        return res;
    }
}
