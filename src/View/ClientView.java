package View;


import Controller.BankAccountController;
import Controller.ClientController;
import Controller.TransactionController;
import Model.Client;

import java.util.Scanner;

public class ClientView {
    private Scanner scanner;
    private ClientController clientController;
    private TransactionController transactionController;
    private BankAccountController bankAccountController;
    private Client currentClient;

    public ClientView(Scanner scanner, ClientController clientController,TransactionController transactionController, BankAccountController bankAccountController) {
        this.scanner = scanner;
        this.clientController = clientController;
        this.transactionController = transactionController;
        this.bankAccountController = bankAccountController;
    }

    public ClientView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start(Client currentClient) {
        this.currentClient = currentClient;

        while (true) {
            System.out.println("\n===== MENU CLIENT =====");
            System.out.println("1. Consulter mes informations personnelles");
            System.out.println("2. Consulter mes comptes bancaires");
            System.out.println("3. Consulter l’historique complet de mes transactions");
            System.out.println("4. Filtrer mes transactions");
            System.out.println("5. Trier mes transactions");
            System.out.println("6. Calculer mon solde total");
            System.out.println("7. Calculer le total des dépôts");
            System.out.println("8. Calculer le total des retraits");
            System.out.println("0. Retour");
            System.out.print("Votre choix : ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: clientController.getClientInformation(currentClient); break;
                case 2: bankAccountController.getAllBankAccountsByClientEmail(currentClient); break;
                case 3: clientController.consulterHistorique(); break;
                case 4: filtrerTransactionsMenu(); break;
                case 5: trierTransactionsMenu(); break;
                case 6: calculerSoldeTotal(); break;
                case 7: calculerTotalDepots(); break;
                case 8: calculerTotalRetraits(); break;
                case 0:  break;
                default: System.out.println("Choix invalide.");
            }
        }
    }
    private void filtrerTransactionsMenu() {

        while (true) {
            System.out.println("\n===== FILTRER TRANSACTIONS =====");
            System.out.println("1. Par type (dépôt / retrait)");
            System.out.println("2. Par montant minimum");
            System.out.println("3. Par montant maximum");
            System.out.println("4. Par date spécifique");
            System.out.println("5. Par période (entre deux dates)");
            System.out.println("0. Retour");
            System.out.print("Votre choix : ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: filtrerParType(); break;
                case 2: filtrerParMontantMin(); break;
                case 3: filtrerParMontantMax(); break;
                case 4: filtrerParDate(); break;
                case 5: filtrerParPeriode(); break;
                case 0: break;
                default: System.out.println("Choix invalide.");
            }
        }
    }
    private void trierTransactionsMenu() {
        while (true) {
            System.out.println("\n===== TRIER TRANSACTIONS =====");
            System.out.println("1. Par date croissante");
            System.out.println("2. Par date décroissante");
            System.out.println("3. Par montant croissant");
            System.out.println("4. Par montant décroissant");
            System.out.println("5. Par type (dépôt avant retrait)");
            System.out.println("0. Retour");
            System.out.print("Votre choix : ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: trierParDateAsc(); break;
                case 2: trierParDateDesc(); break;
                case 3: trierParMontantAsc(); break;
                case 4: trierParMontantDesc(); break;
                case 5: trierParType(); break;
                case 0:  break;
                default: System.out.println("Choix invalide.");
            }
        }
    }
}
