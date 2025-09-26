package Controller;

import Model.Client;
import Service.AuthService;
import Service.ClientService;
import Service.ManagerService;
import Exception.EmailAlreadyExistsException;
import Exception.FailedLoginException;

import java.util.Scanner;

public class AuthController {
    private ClientService clientService;
    private ManagerService managerService;
    private AuthService authService;


    public AuthController(ClientService clientService, ManagerService managerService, AuthService authService) {
        this.clientService = clientService;
        this.managerService = managerService;
        this.authService = authService;
    }




    public void login(String email,String password){
        try{
            String role = authService.login(email,password);
            if(role.equals("manager")){

            }
        }catch (FailedLoginException e){
            System.out.println(e);
        }
    }
}
