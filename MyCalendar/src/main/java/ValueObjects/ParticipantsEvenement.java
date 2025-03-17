package ValueObjects;

public class ParticipantsEvenement {
    private String participants;

    public ParticipantsEvenement(String participants) {
        this.participants = participants;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }
}
