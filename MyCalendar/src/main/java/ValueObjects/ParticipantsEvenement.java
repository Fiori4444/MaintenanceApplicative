package ValueObjects;

import java.util.ArrayList;

public class ParticipantsEvenement {
    private ArrayList<String> participants;

    public ParticipantsEvenement(ArrayList<String> participants) {
        this.participants = participants;
    }

    public ArrayList<String> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<String> participants) {
        this.participants = participants;
    }
}
