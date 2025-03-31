package Command;

import Main.Main;

import java.util.Scanner;

public class AjouterReunionCommand implements Command {
    private Main main;
    private Scanner scanner;

    public AjouterReunionCommand(Main main, Scanner scanner) {
        this.main = main;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        main.ajouterReunion(scanner);
    }
}
