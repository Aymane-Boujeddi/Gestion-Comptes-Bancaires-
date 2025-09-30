package Controller;

import Model.Client;
import Model.Manager;
import Service.AuthService;
import Service.ClientService;
import Service.ManagerService;
import Exception.EmailAlreadyExistsException;
import Exception.FailedLoginException;
import Utils.Validation;
import View.ClientView;
import View.ManagerView;

import java.util.Scanner;

public class AuthController {
    private ClientService clientService;
    private ManagerService managerService;
    private AuthService authService;
    private Validation validation;




    public AuthController(ClientService clientService, ManagerService managerService, AuthService authService, Validation validation) {
        this.validation = validation;
        this.clientService = clientService;
        this.managerService = managerService;
        this.authService = authService;
    }




    public void login(String email, String password, ClientView clientView, ManagerView managerView){
        try{

            String role = authService.login(email,password);
            if(role.equals("manager")){
                Client cuurentClient = clientService.getClientByEmail(email);
                clientView.start(cuurentClient);
            }else{
                Manager currentManager = managerService.getManagerByEmail(email);
                managerView.start(currentManager);
            }
        }catch (FailedLoginException e){
            System.out.println(e);
        }
    }
}
