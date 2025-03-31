package Command;

import Main.Main;

public class SeDeconnecterCommand implements Command {
    private Main main;

    public SeDeconnecterCommand(Main main) {
        this.main = main;
    }

    @Override
    public void execute() {
        main.seDeconnecter();
    }
}
