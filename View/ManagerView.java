package View;

import Controller.AuthController;

import java.util.Scanner;

public class ManagerView {
    private Scanner scanner ;
    private AuthController authController;

    public ManagerView(Scanner scanner, AuthController authController) {
        this.scanner = scanner;
        this.authController = authController;
    }

    public ManagerView(Scanner scanner) {
        this.scanner = scanner;
    }

    private void managerMenu() {
        boolean back = false;
        while (true) {
            System.out.println("\n===== MENU GESTIONNAIRE =====");
            System.out.println("1. Créer un client");
            System.out.println("2. Modifier un client");
            System.out.println("3. Supprimer un client");
            System.out.println("4. Gérer les comptes d’un client");
            System.out.println("5. Gérer les transactions d’un compte");
            System.out.println("6. Consulter les transactions d’un client");
            System.out.println("7. Identifier les transactions suspectes");
            System.out.println("0. Retour");
            System.out.print("Votre choix : ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: authController.creerClient(); break;
                case 2: modifierClientMenu(); break;
                case 3: supprimerClient(); break;
                case 4: gererComptesMenu(); break;
                case 5: gererTransactionsMenu(); break;
                case 6: consulterTransactionsClient(); break;
                case 7: identifierTransactionsSuspectesMenu(); break;
                case 0: back = true; break;
                default: System.out.println("Choix invalide.");
            }
        }
    }
    private static void modifierClientMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n===== MODIFIER CLIENT =====");
            System.out.println("1. Modifier le nom");
            System.out.println("2. Modifier l’email");
            System.out.println("3. Modifier le téléphone");
            System.out.println("0. Retour");
            System.out.print("Votre choix : ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: modifierNomClient(); break;
                case 2: modifierEmailClient(); break;
                case 3: modifierTelephoneClient(); break;
                case 0: back = true; break;
                default: System.out.println("Choix invalide.");
            }
        }
    }
    private  void gererComptesMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n===== GÉRER COMPTES =====");
            System.out.println("1. Ajouter un compte");
            System.out.println("2. Modifier un compte");
            System.out.println("3. Supprimer un compte");
            System.out.println("0. Retour");
            System.out.print("Votre choix : ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: ajouterCompte(); break;
                case 2: modifierCompte(); break;
                case 3: supprimerCompte(); break;
                case 0: back = true; break;
                default: System.out.println("Choix invalide.");
            }
        }
    }
    private  void gererTransactionsMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n===== GÉRER TRANSACTIONS =====");
            System.out.println("1. Ajouter une transaction");
            System.out.println("2. Modifier une transaction");
            System.out.println("3. Supprimer une transaction");
            System.out.println("0. Retour");
            System.out.print("Votre choix : ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: ajouterTransaction(); break;
                case 2: modifierTransaction(); break;
                case 3: supprimerTransaction(); break;
                case 0: back = true; break;
                default: System.out.println("Choix invalide.");
            }
        }
    }
}
