package Controller;

import Model.Account;
import Model.AccountType;
import Model.Client;
import Model.Manager;
import Service.BankAccountService;
import Utils.Validation;
import Exception.NotCurrentManagersClientException;
import Exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class BankAccountController {
    private BankAccountService bankAccountService;

    private Scanner scanner;
    private Validation validation;

    public BankAccountController(BankAccountService bankAccountService,Scanner scanner,Validation validation) {
        this.validation = validation;
        this.scanner = scanner;
        this.bankAccountService = bankAccountService;
    }

    public void createBankAccount(Manager currentManager) {
        try {
            System.out.println("Enter the Client's email you want to create a bank account for: ");
            String clientEmail = scanner.next();
            validation.emptyString(clientEmail);
            
            Optional<Client> clientOptional = bankAccountService.getClientByEmail(clientEmail);
            if (clientOptional.isEmpty()) {
                System.out.println("Client not found with email: " + clientEmail);
                return;
            }
            
            Client currentClient = clientOptional.get(); 
            System.out.println("Creating a new bank account for: " + currentClient.getName() + " " + currentClient.getLastName());
            
            System.out.println("Enter the initial deposit amount: ");
            double initialDeposit = scanner.nextDouble();
            validation.validatePositiveAmount(initialDeposit); 
            
            System.out.println("Enter the account type (SAVINGS, CHECKING, TERMDEPOSIT): ");
            String accountTypeInput = scanner.next();
            validation.emptyString(accountTypeInput);
            
            AccountType accountType = AccountType.valueOf(accountTypeInput.toUpperCase());
            
            Account newBankAccount = new Account(currentClient.getId(), initialDeposit, accountType);
            bankAccountService.createBankAccount(currentClient, currentManager, newBankAccount);
            
            System.out.println(" New bank account created successfully");
            
        } catch (UserNotFoundException | NotCurrentManagersClientException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    public void getAllBankAccountsByClientEmail(Client currentClient) {
        try {
           List<Account> clientAccounts = bankAccountService.getAllBankAccountsForClient(currentClient);
           System.out.println("Bank Accounts for " + currentClient.getName() + " " + currentClient.getLastName() + ":");
           for (Account account : clientAccounts) {
                System.out.println( "AccountType: " + account.getAccountType()+ ", Balance: " + account.getBalance());
           }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        }
    }

}
