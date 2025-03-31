package Command;

import Main.Main;

import java.util.Scanner;

public class AjouterEventPeriodiqueCommand implements Command {
    private Main main;
    private Scanner scanner;

    public AjouterEventPeriodiqueCommand(Main main, Scanner scanner) {
        this.main = main;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        main.ajouterEventPeriodique(scanner);
    }
}
