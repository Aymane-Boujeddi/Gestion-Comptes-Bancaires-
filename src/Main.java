import Controller.*;
import Repository.impl.InMemoryManagerRepository;
import Service.*;
import Utils.Validation;
import View.AuthView;
import View.ClientView;
import View.ManagerView;

import java.util.Scanner;

public class Main {

    public void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Validation validation = new Validation();

        InMemoryManagerRepository inMemoryManagerRepository = new InMemoryManagerRepository();

        BankAccountService bankAccountService = new BankAccountService();
        AuthService authService = new AuthService(inMemoryManagerRepository);
        ClientService clientService = new ClientService(inMemoryManagerRepository);
        ManagerService managerService = new ManagerService(inMemoryManagerRepository);
        TransactionService transactionService = new TransactionService();

        AuthController authController = new AuthController(clientService,managerService,authService,validation);
        ClientController clientController = new ClientController(clientService,scanner,validation);
        ManagerController managerController = new ManagerController(managerService,clientService,scanner,validation);
        TransactionController transactionController = new TransactionController(scanner,transactionService);
        BankAccountController bankAccountController = new BankAccountController(bankAccountService,scanner,validation);

        ClientView clientView = new ClientView(scanner,clientController,transactionController,bankAccountController);
        ManagerView managerView = new ManagerView(scanner,clientController,managerController,transactionController,bankAccountController);
        AuthView authView = new AuthView(scanner,authController,clientView,managerView);

        authView.start();

    }

}
