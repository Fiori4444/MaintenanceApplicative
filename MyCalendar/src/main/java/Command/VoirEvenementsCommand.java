package Command;

import Main.Main;

public class VoirEvenementsCommand implements Command {
    private Main main;

    public VoirEvenementsCommand(Main main) {
        this.main = main;
    }

    @Override
    public void execute() {
        main.voirEvenements();
    }
}
