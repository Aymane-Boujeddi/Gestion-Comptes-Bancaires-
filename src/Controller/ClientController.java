package Controller;

import Model.Client;
import Model.Manager;
import Repository.impl.InMemoryManagerRepository;
import Service.ClientService;
import Exception.EmailAlreadyExistsException;
import Exception.NotCurrentManagersClientException;
import Exception.UserNotFoundException;
import Utils.Validation;

import java.util.Optional;
import java.util.Scanner;

public class ClientController {
    private Scanner scanner;
    private Validation validation;
    private ClientService clientService;


    public ClientController(ClientService clientService,Scanner scanner,Validation validation) {
        this.validation = validation;
        this.scanner = scanner;
        this.clientService = clientService;
    }

    public void createNewClient(Manager currentManager){
        try{
            System.out.println("Enter the new Client's name : ");
            String newClientName = scanner.next();
            System.out.println("Enter the new Client's last name : ");
            String newClientLastName = scanner.next();
            System.out.println("Enter the new Client's email : ");
            String newClientEmail = scanner.next();
            System.out.println("Enter the new Client's password : ");
            String newClientPassword = scanner.next();
            validation.emptyString(newClientName);
            validation.emptyString(newClientLastName);
            validation.validateEmail(newClientEmail);
            validation.validatePassword(newClientPassword);
            Client newClient = new Client(newClientName,newClientLastName,newClientEmail,newClientPassword);
            clientService.createClientAccount(newClient,currentManager);
            System.out.println("New Client created successfully");
        }catch (EmailAlreadyExistsException e) {
            System.out.println(e);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }



    public void getClientInformation(Client currentClient){

        System.out.println(currentClient.toString());
    }

    public void getClientBankAccounts(Client currentClient){
        System.out.println(currentClient.getAccounts().toString());
    }

    public void updateClientsName(Manager currentManager){
        try{
            System.out.println("Enter the Client's email you want to update : ");
            String clientEmail = scanner.next();
            validation.validateEmail(clientEmail);
            Client currentClient = clientService.getClientByEmail(clientEmail,currentManager.getEmail());
            System.out.println("Enter the new name : ");
            String newName = scanner.next();
            clientService.updateClientsName(newName,updatingClientEmail);
            System.out.println("Client's name updated successfully");
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateClientPassword(Manager currentManager){
        try{
            System.out.println("Enter Client email to update password : ");
            String clientEmail = scanner.next();
            validation.validateEmail(clientEmail);
            Client currentClient = clientService.getClientByEmail(clientEmail,currentManager.getEmail());
            System.out.println("Enter the new password : ");
            String newPassword = scanner.next();
            validation.validatePassword(newPassword);
            currentClient.setPassword(newPassword);
            System.out.println("Client's password updated successfully");
        }catch (IllegalArgumentException | NotCurrentManagersClientException | UserNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    public void updateClientEmail(Manager currentManager){
        try{
            System.out.println("Enter Client email to update password : ");
            String clientEmail = scanner.next();
            validation.validateEmail(clientEmail);
            Client currentClient = clientService.getClientByEmail(clientEmail,currentManager.getEmail());
            System.out.println("Enter the new email : ");
            String newEmail = scanner.next();
            validation.validateEmail(newEmail);
            currentClient.setEmail(newEmail);
            System.out.println("Client's email updated successfully");
        }catch (IllegalArgumentException | NotCurrentManagersClientException | UserNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    public void updateClientLastName(Manager currentManager){
        try{
            System.out.println("Enter Client email to update password : ");
            String clientEmail = scanner.next();
            validation.validateEmail(clientEmail);
            Client currentClient = clientService.getClientByEmail(clientEmail,currentManager.getEmail());
            System.out.println("Enter the new last name : ");
            String newLastName = scanner.next();
            validation.emptyString(newLastName);
            currentClient.setLastName(newLastName);
            System.out.println("Client's last name updated successfully");
        }catch (IllegalArgumentException | NotCurrentManagersClientException |  UserNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    public void updateClientName(Manager currentManager){
        try{
            System.out.println("Enter Client email to update password : ");
            String clientEmail = scanner.next();
            validation.validateEmail(clientEmail);
            Client currentClient = clientService.getClientByEmail(clientEmail,currentManager.getEmail());
            System.out.println("Enter the new name : ");
            String newName = scanner.next();
            validation.emptyString(newName);
            currentClient.setName(newName);
            System.out.println("Client's name updated successfully");
        }catch (IllegalArgumentException | NotCurrentManagersClientException | UserNotFoundException e){
            System.out.println(e.getMessage());
        }
    }


}
