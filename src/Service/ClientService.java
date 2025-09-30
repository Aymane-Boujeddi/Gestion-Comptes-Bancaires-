package Service;

import Model.Client;
import Exception.EmailAlreadyExistsException;
import Exception.NotCurrentManagersClientException;
import Exception.UserNotFoundException;
import Model.Manager;
import Repository.impl.InMemoryManagerRepository;

import java.util.Optional;

public class ClientService {
    private InMemoryManagerRepository inMemoryManagerRepository;

    public ClientService(InMemoryManagerRepository inMemoryManagerRepository) {
        this.inMemoryManagerRepository = inMemoryManagerRepository;
    }



    public void createClientAccount(Client newClient,Manager currentManager) throws EmailAlreadyExistsException {

        if(inMemoryManagerRepository.getManagerByEmail(newClient.getEmail()).isPresent() || inMemoryManagerRepository.getClientByEmail(newClient.getEmail()).isPresent()){
            throw new EmailAlreadyExistsException("Email already existing");
        }
        inMemoryManagerRepository.createNewClient(newClient,currentManager);

    }
    public void removeClientAccount(String removingClientEmail,String currentManagerEmail) throws NotCurrentManagersClientException, UserNotFoundException {
        Optional<Client> removingClient = inMemoryManagerRepository.getClientByEmail(removingClientEmail);
        checkManagersClient(removingClientEmail,currentManagerEmail);
        if(removingClient.isEmpty()){
                throw new UserNotFoundException("This Client does not exist");
        }
        inMemoryManagerRepository.removeClient(removingClient,currentManagerEmail);

    }
    public void checkManagersClient(String clientEmail,String managerEmail) throws NotCurrentManagersClientException {
        if(inMemoryManagerRepository.isCurrentManagerClient(clientEmail,managerEmail).isEmpty()){
            throw new NotCurrentManagersClientException("This Client does not belong to this Manager .");
        }
    }
    public void updateClientsName(String newName, String clientEmail) throws UserNotFoundException {
        Optional<Client> updatingClient = inMemoryManagerRepository.getClientByEmail(clientEmail);
        if(inMemoryManagerRepository.getClientByEmail(clientEmail).isEmpty()){
            throw new UserNotFoundException("This Client does not exist");
        }
        inMemoryManagerRepository.updateClientsName(newName,clientEmail);


    }
    public Client getClientByEmail(String clientEmail,String managerEmail) throws UserNotFoundException, NotCurrentManagersClientException {
        checkManagersClient(clientEmail,managerEmail);
        if(inMemoryManagerRepository.getClientByEmail(clientEmail).isEmpty()){
            throw new UserNotFoundException("This Client does not exist");
        }
        return inMemoryManagerRepository.getClientByEmail(clientEmail).get();
    }

}
