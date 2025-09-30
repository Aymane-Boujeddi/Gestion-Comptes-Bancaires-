package Repository.impl;

import Model.Account;
import Model.Client;
import Model.Manager;
import Repository.ManagerRepository;

import java.util.HashMap;

import java.util.Map;
import java.util.Optional;

public class InMemoryManagerRepository implements ManagerRepository {
    // Key -> email ; Manager contains Client List<Client>
    Map<String , Manager> managers = new HashMap<>();

    public InMemoryManagerRepository(){
        Manager manager = new Manager("manager","manager","manager@gmail.com","123456789","administration");
        managers.put(manager.getEmail(),manager);
    }

    public Optional<Client> getClientByEmail(String email){
        Optional<Client> clientWithEmail = managers.values().stream().flatMap(manager -> manager.getClients().stream()).filter(client -> client.getEmail().equals(email)).findFirst();
        return clientWithEmail;
    }

    public Optional<Manager> getManagerByEmail(String email){
        Optional<Manager> managerWithEmail = Optional.ofNullable(managers.get(email));
        return managerWithEmail;
    }
    public void createNewClient(Client client,Manager currentManager){
        Manager getCurrentManager = managers.get(currentManager.getEmail());
        getCurrentManager.addToClientsList(client);
    }

    public Optional<Client> isCurrentManagerClient(String clientEmail,String managerEmail){
        Manager currentManager = managers.get(managerEmail);
        return currentManager.getClients().stream().filter(client -> clientEmail.equals(client.getEmail())).findAny();
    }
    public void removeClient(Optional<Client> removingClient,String managerEmail){
        Manager currentManager = managers.get(managerEmail);
        currentManager.getClients().remove(removingClient);
    }
    public void createNewManager(Manager manager){
        managers.put(manager.getEmail(),manager);
    }
    public void updateClientsName(String newName,String clientEmail){
        Optional<Client> updatingClient = getClientByEmail(clientEmail);
        updatingClient.ifPresent(client -> client.setName(newName));
    }

    public void createNewBankAccount(Client currentClient, Manager currentManager, Account newBankAccount){
        Optional<Client> client = getClientByEmail(currentClient.getEmail());
        client.get().addAccount(newBankAccount);
    }






}
