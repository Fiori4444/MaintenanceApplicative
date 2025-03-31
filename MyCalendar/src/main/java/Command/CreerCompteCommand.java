package Command;

import Main.Main;

import java.util.Scanner;

public class CreerCompteCommand implements Command {
    private Main main;
    private Scanner scanner;

    public CreerCompteCommand(Main main, Scanner scanner) {
        this.main = main;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        main.creerCompte(scanner);
    }
}
