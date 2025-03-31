package Command;

import Main.Main;

import java.util.Scanner;

public class SeConnecterCommand implements Command {
    private Main main;
    private Scanner scanner;

    public SeConnecterCommand(Main main, Scanner scanner) {
        this.main = main;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        main.seConnecter(scanner);
    }
}
