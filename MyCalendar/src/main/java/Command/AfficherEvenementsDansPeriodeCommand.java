package Command;

import Main.Main;
import java.util.Scanner;

public class AfficherEvenementsDansPeriodeCommand implements Command {
    private Main main;
    private Scanner scanner;

    public AfficherEvenementsDansPeriodeCommand(Main main, Scanner scanner) {
        this.main = main;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        main.afficherEvenementsDansPeriode(scanner);
    }
}