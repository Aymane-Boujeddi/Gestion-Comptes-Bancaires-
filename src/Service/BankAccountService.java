package Service;

import Model.Account;
import Model.AccountType;
import Model.Client;
import Model.Manager;
import Repository.impl.InMemoryManagerRepository;
import Exception.UserNotFoundException;
import Exception.NotCurrentManagersClientException;


import java.util.List;
import java.util.Optional;

public class BankAccountService {
    private InMemoryManagerRepository inMemoryManagerRepository;

    public BankAccountService(InMemoryManagerRepository inMemoryManagerRepository) {
        this.inMemoryManagerRepository = inMemoryManagerRepository;
    }

    public void createBankAccount(Client currentClient, Manager currentManager, Account newUsersBankAccount) throws NotCurrentManagersClientException, UserNotFoundException {
            if(inMemoryManagerRepository.isCurrentManagerClient(currentClient.getEmail(),currentManager.getEmail()).isEmpty()){
                throw new NotCurrentManagersClientException("This Client does not belong to this Manager .");
            }
            if(inMemoryManagerRepository.getClientByEmail(currentClient.getEmail()).isEmpty()) {
                throw new UserNotFoundException("This Client does not exist");
            }
            inMemoryManagerRepository.createNewBankAccount(currentClient,currentManager,newUsersBankAccount);
    }
    public Optional<Client> getClientByEmail(String email) throws UserNotFoundException {
        if(inMemoryManagerRepository.getClientByEmail(email).isEmpty()){
            throw new UserNotFoundException("This Email does not belong to any Client");
        }
        return inMemoryManagerRepository.getClientByEmail(email);
    }

    public List<Account> getAllBankAccountsForClient(Client currentClient) throws IllegalArgumentException{
        if(currentClient.getAccounts().isEmpty()){
            throw new IllegalArgumentException("This Client has no bank accounts");
        }
        return currentClient.getAccounts();
    }



}
