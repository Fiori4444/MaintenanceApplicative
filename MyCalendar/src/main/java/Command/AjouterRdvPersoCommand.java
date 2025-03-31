package Command;

import Main.Main;

import java.util.Scanner;

public class AjouterRdvPersoCommand implements Command {
    private Main main;
    private Scanner scanner;

    public AjouterRdvPersoCommand(Main main, Scanner scanner) {
        this.main = main;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        main.ajouterRdvPerso(scanner);
    }
}
