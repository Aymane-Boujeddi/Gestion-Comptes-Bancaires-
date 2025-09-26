import Controller.AuthController;
import Controller.ClientController;
import Repository.impl.InMemoryManagerRepository;
import Service.AccountService;
import Service.ClientService;
import Service.ManagerService;
import View.AuthView;

import java.util.Scanner;

public class Main {

    public void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        InMemoryManagerRepository inMemoryManagerRepository = new InMemoryManagerRepository();

        AccountService accountService = new AccountService();
        ClientService clientService = new ClientService(inMemoryManagerRepository);
        ManagerService managerService = new ManagerService(inMemoryManagerRepository);

        AuthController authController = new AuthController(clientService,managerService,scanner);
        ClientController clientController = new ClientController(clientService,scanner);

        AuthView authView = new AuthView(scanner,authController);

    }

}
