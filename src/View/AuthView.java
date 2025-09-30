package View;

import Controller.AuthController;
import Controller.ClientController;

import java.util.Scanner;

public class AuthView {
    private Scanner scanner;
    private AuthController authController;
    private ClientView clientView;
    private ManagerView managerView;


    public AuthView(Scanner scanner, AuthController authController, ClientView clientView, ManagerView managerView) {
        this.scanner = scanner;
        this.authController = authController;
        this.clientView = clientView;
        this.managerView = managerView;
    }

    public void start() {
        while (true) {
            System.out.println("\n===== MENU CLIENT =====");
            System.out.println("1. Connexion");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            switch(choice){
                case 1 : login();
                case 0 : break;
                default: System.out.println("Choix invalide.");

            }
        }
    }

    private void login(){
        System.out.println("Email :");
        String loginEmail = scanner.next();
        System.out.println("Password : ");
        String loginPassword = scanner.next();

       authController.login(loginEmail,loginPassword,clientView,managerView);

       
    }
}
