package Controller;

import Model.Manager;
import Service.ClientService;
import Service.ManagerService;
import Exception.EmailAlreadyExistsException;
import Exception.NotCurrentManagersClientException;
import Exception.UserNotFoundException;
import Utils.Validation;

import java.util.Scanner;

public class ManagerController {

    private Scanner scanner;
    private Validation validation;
    private ManagerService managerService;
    private ClientService clientService;

    public ManagerController(ManagerService managerService, ClientService clientService, Scanner scanner, Validation validation) {
        this.validation = validation;
        this.scanner = scanner;
        this.managerService = managerService;
        this.clientService = clientService;
    }

    public void createNewManager(){
        try{
            System.out.println("Enter the new Manager's name : ");
            String newManagerName = scanner.next();
            System.out.println("Enter the new Manager's last name : ");
            String newManagerLastName = scanner.next();
            System.out.println("Enter the new Manager's email : ");
            String newManagerEmail = scanner.next();
            System.out.println("Enter the new Manager's password : ");
            String newManagerPassword = scanner.next();
            System.out.println("Enter the new Manager's department : ");
            String newManagerDepartment = scanner.next();
            Manager newManager = new Manager(newManagerName,newManagerLastName,newManagerEmail,newManagerPassword,newManagerDepartment);
            managerService.createManagerAccount(newManager);
            System.out.println("New Manager created successfully");
        }catch (EmailAlreadyExistsException e) {
            System.out.println(e);
        }
    }

    public void removeClient(Manager currentManager){
       try{
           System.out.println("Enter the Client's email you want to remove : ");
           String removingClientEmail = scanner.next();
           validation.emptyString(removingClientEmail);
           clientService.removeClientAccount(removingClientEmail,currentManager.getEmail());
           System.out.println("Client removed successfully");
       }catch (NotCurrentManagersClientException e) {
           System.out.println(e);
       }catch (UserNotFoundException e){
              System.out.println(e);
       }catch (IllegalArgumentException e){
           System.out.println(e.getMessage());
       }
    }





}
