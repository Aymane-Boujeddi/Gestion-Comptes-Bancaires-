package View;

import Controller.*;
import Model.Manager;

import java.util.Scanner;

public class ManagerView {
    private Scanner scanner ;
    private ClientController clientController;
    private ManagerController managerController;
    private TransactionController transactionController;
    private BankAccountController bankAccountController;
    private Manager currentManager;

    public ManagerView(Scanner scanner, ClientController clientController, ManagerController managerController, TransactionController transactionController, BankAccountController bankAccountController) {
        this.scanner = scanner;
        this.clientController = clientController;
        this.managerController = managerController;
        this.transactionController = transactionController;
        this.bankAccountController = bankAccountController;
    }

    public void start(Manager cuurentManager) {
        this.currentManager = cuurentManager;

        while (true) {
            System.out.println("\n===== MENU GESTIONNAIRE =====");
            System.out.println("1. Créer un Nouveau Utilisateur");
            System.out.println("2. Modifier un client");
            System.out.println("3. Supprimer un client");
            System.out.println("4. Gérer les comptes d’un client");
            System.out.println("5. Gérer les transactions d’un compte");
            System.out.println("6. Consulter les transactions d’un client");
            System.out.println("7. Identifier les transactions suspectes");
            System.out.println("8. Deconnecter");
            System.out.println("0. Retour");
            System.out.print("Votre choix : ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: createNewClient(); break;
                case 2: modifierClientMenu(); break;
                case 3: managerController.removeClient(currentManager); break;
                case 4: gererComptesMenu(); break;
                case 5: gererTransactionsMenu(); break;
                case 6: consulterTransactionsClient(); break;
                case 7: identifierTransactionsSuspectesMenu(); break;
                case 8: logout(); break;
                case 0:  break;
                default: System.out.println("Choix invalide.");
            }
        }
    }
    private void createNewClient(){
        while(true){
            System.out.println("\n===== Creer Un Nouveau Utilisateur =====");
            System.out.println("1. Creer un client");
            System.out.println("2. Creer un gestionnaire");

            int choice = scanner.nextInt();
            switch (choice){
                case 1: clientController.createNewClient(currentManager); break;
                case 2: managerController.createNewManager(); break;
                case 0: break;
                default: System.out.println("Choix invalide.");
            }
        }
    }
    private  void modifierClientMenu() {

        while (true) {
            System.out.println("\n===== MODIFIER CLIENT =====");
            System.out.println("1. Modifier le nom");
            System.out.println("2. Modifier l’email");
            System.out.println("3. Modifier le prenom");
            System.out.println("4. Modifier le mot de passe");
            System.out.println("0. Retour");
            System.out.print("Votre choix : ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: clientController.updateClientName(currentManager); break;
                case 2: clientController.updateClientEmail(currentManager); break;
                case 3: clientController.updateClientLastName(currentManager); break;
                case 4: clientController.updateClientPassword(currentManager); break;
                case 0: break;
                default: System.out.println("Choix invalide.");
            }
        }
    }
    private  void gererComptesMenu() {

        while (true) {
            System.out.println("\n===== GÉRER COMPTES =====");
            System.out.println("1. Ajouter un compte");
            System.out.println("2. Modifier un compte");
            System.out.println("3. Supprimer un compte");
            System.out.println("0. Retour");
            System.out.print("Votre choix : ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: bankAccountController.createBankAccount(currentManager); break;
                case 2: modifierCompte(); break;
                case 3: supprimerCompte(); break;
                case 0:  break;
                default: System.out.println("Choix invalide.");
            }
        }
    }
    private  void gererTransactionsMenu() {

        while (true) {
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
                case 0: break;
                default: System.out.println("Choix invalide.");
            }
        }
    }
    private void logout(){
        currentManager = null;
        System.out.println("Deconnexion reussie");
        return;
    }
    private void modifierCompte(){
        while(true){
            System.out.println("\n===== MODIFIER COMPTE =====");
            System.out.println("1. Modifier le type de compte");
            System.out.println("2. Modifier le solde");
            System.out.println("0. Retour");
            System.out.print("Votre choix : ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: bankAccountController.updateAccountType(currentManager); break;
                case 2: bankAccountController.updateAccountBalance(currentManager); break;
                case 0: break;
                default: System.out.println("Choix invalide.");
            }
        }
    }
}
