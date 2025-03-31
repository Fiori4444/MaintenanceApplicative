package Main;

import java.time.LocalDateTime;
import java.util.*;

import Command.*;
import Events.*;

public class Main {
    private CalendarManager calendar = new CalendarManager();
    private String utilisateur = null;
    private boolean continuer = true;
    private String[] utilisateurs = new String[99];
    private String[] motsDePasses = new String[99];
    private int nbUtilisateurs = 0;

    public Main() {}

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Command> mainMenuCommands = new HashMap<>();
        mainMenuCommands.put("1", new SeConnecterCommand(this, scanner));
        mainMenuCommands.put("2", new CreerCompteCommand(this, scanner));

        Map<String, Command> userMenuCommands = new HashMap<>();
        userMenuCommands.put("1", new VoirEvenementsCommand(this));
        userMenuCommands.put("2", new AjouterRdvPersoCommand(this, scanner));
        userMenuCommands.put("3", new AjouterReunionCommand(this, scanner));
        userMenuCommands.put("4", new AjouterEventPeriodiqueCommand(this, scanner));
        userMenuCommands.put("5", new SeDeconnecterCommand(this));
        userMenuCommands.put("6", new AfficherEvenementsDansPeriodeCommand(this, scanner)); // New command

        while (true) {
            if (utilisateur == null) {
                afficherMenuPrincipal();
                String choix = scanner.nextLine();
                mainMenuCommands.getOrDefault(choix, () -> System.out.println("Choix invalide")).execute();
            }

            while (continuer && utilisateur != null) {
                afficherMenuUtilisateur();
                String choix = scanner.nextLine();
                userMenuCommands.getOrDefault(choix, () -> System.out.println("Choix invalide")).execute();
            }
        }
    }

    private void afficherMenuPrincipal() {
        System.out.println("1 - Se connecter");
        System.out.println("2 - Créer un compte");
        System.out.print("Choix : ");
    }

    private void afficherMenuUtilisateur() {
        System.out.println("\nBonjour, " + utilisateur);
        System.out.println("=== Menu Gestionnaire d'Événements ===");
        System.out.println("1 - Voir les événements");
        System.out.println("2 - Ajouter un rendez-vous perso");
        System.out.println("3 - Ajouter une réunion");
        System.out.println("4 - Ajouter un évènement périodique");
        System.out.println("5 - Se déconnecter");
        System.out.println("6 - Afficher événements dans une période"); // New menu option
        System.out.print("Votre choix : ");
    }

    public void seConnecter(Scanner scanner) {
        System.out.print("Nom d'utilisateur: ");
        String username = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String password = scanner.nextLine();

        for (int i = 0; i < nbUtilisateurs; i++) {
            if (utilisateurs[i].equals(username) && motsDePasses[i].equals(password)) {
                utilisateur = username;
                continuer = true;
                System.out.println("Connexion réussie.");
                return;
            }
        }
        System.out.println("Nom d'utilisateur ou mot de passe incorrect.");
    }

    public void creerCompte(Scanner scanner) {
        System.out.print("Choisissez un nom d'utilisateur: ");
        String username = scanner.nextLine();
        System.out.print("Choisissez un mot de passe: ");
        String password = scanner.nextLine();

        utilisateurs[nbUtilisateurs] = username;
        motsDePasses[nbUtilisateurs] = password;
        nbUtilisateurs++;
        System.out.println("Compte créé avec succès.");
    }

    public void voirEvenements() {
        System.out.println("Liste des événements:");
        calendar.afficherEvenements();
    }

    public void ajouterRdvPerso(Scanner scanner) {
        System.out.print("Titre de l'événement : ");
        String titre = scanner.nextLine();
        System.out.print("Année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int moisRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jourRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute = Integer.parseInt(scanner.nextLine());
        System.out.print("Durée (en minutes) : ");
        int duree = Integer.parseInt(scanner.nextLine());

        Event event = new PersonnelEvent(titre, utilisateur,
                LocalDateTime.of(annee, moisRdv, jourRdv, heure, minute), duree);

        calendar.ajouterEvent(event);
        System.out.println("Rendez-vous perso ajouté.");
    }

    public void ajouterReunion(Scanner scanner) {
        System.out.print("Titre de l'événement : ");
        String titre = scanner.nextLine();
        System.out.print("Année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int moisRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jourRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute = Integer.parseInt(scanner.nextLine());
        System.out.print("Durée (en minutes) : ");
        int duree = Integer.parseInt(scanner.nextLine());
        System.out.println("Lieu :");
        String lieu = scanner.nextLine();

        ArrayList<String> participants = new ArrayList<>();
        participants.add(utilisateur);

        System.out.println("Ajouter un participant ? (oui / non)");
        while (scanner.nextLine().equals("oui")) {
            System.out.print("Participants : " + participants);
            participants.add(", " + scanner.nextLine());
        }

        Event event = new ReunionEvent(titre, utilisateur,
                LocalDateTime.of(annee, moisRdv, jourRdv, heure, minute), duree, lieu, participants);

        calendar.ajouterEvent(event);

        System.out.println("Réunion ajoutée.");
    }

    public void ajouterEventPeriodique(Scanner scanner) {
        System.out.print("Titre de l'événement : ");
        String titre = scanner.nextLine();
        System.out.print("Année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int moisRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jourRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute = Integer.parseInt(scanner.nextLine());
        System.out.print("Frequence (en jours) : ");
        int frequence = Integer.parseInt(scanner.nextLine());

        Event event = new PeriodiqueEvent(titre, utilisateur,
                LocalDateTime.of(annee, moisRdv, jourRdv, heure, minute), 0, frequence);

        calendar.ajouterEvent(event);

        System.out.println("Événement périodique ajouté.");
    }

    public void seDeconnecter() {
        utilisateur = null;
        continuer = false;
        System.out.println("Déconnexion réussie.");
    }

    public void afficherEvenementsDansPeriode(Scanner scanner) {
        System.out.print("Date de début (AAAA-MM-JJTHH:MM) : ");
        LocalDateTime start = LocalDateTime.parse(scanner.nextLine());
        System.out.print("Date de fin (AAAA-MM-JJTHH:MM) : ");
        LocalDateTime end = LocalDateTime.parse(scanner.nextLine());

        List<Event> events = calendar.eventDansPeriode(start, end);
        System.out.println("Événements dans la période :");
        for (Event event : events) {
            System.out.println(event.description());
        }
    }
}