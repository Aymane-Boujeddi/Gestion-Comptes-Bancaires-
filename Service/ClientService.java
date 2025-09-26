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
        if(inMemoryManagerRepository.isCurrentManagerClient(removingClientEmail,currentManagerEmail).isEmpty()){
                throw new NotCurrentManagersClientException("This Client does not belong to this Manager .");
        }
        if(inMemoryManagerRepository.getClientByEmail(removingClientEmail).isEmpty()){
                throw new UserNotFoundException("This Client does not exist");
        }
        inMemoryManagerRepository.removeClient(removingClient,currentManagerEmail);

    }
    public void updateClientsName(){

    }

}
