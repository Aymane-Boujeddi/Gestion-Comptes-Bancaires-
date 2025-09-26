package View;

import Controller.AuthController;
import Controller.ClientController;

import java.util.Scanner;

public class AuthView {
    private Scanner scanner;
    private AuthController authController;



    public AuthView(Scanner scanner, AuthController authController) {
        this.scanner = scanner;
        this.authController = authController;
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

       String role = authController.login(loginEmail,loginPassword);
       
    }
}
