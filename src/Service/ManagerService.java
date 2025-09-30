package Service;

import Model.Manager;
import Repository.impl.InMemoryManagerRepository;
import Exception.EmailAlreadyExistsException;

public class ManagerService {
    private InMemoryManagerRepository inMemoryManagerRepository;


    public ManagerService(InMemoryManagerRepository inMemoryManagerRepositor) {
        this.inMemoryManagerRepository = inMemoryManagerRepository;

    }
    public void createManagerAccount(Manager newManager) throws EmailAlreadyExistsException {
        if(inMemoryManagerRepository.getManagerByEmail(newManager.getEmail()).isPresent() || inMemoryManagerRepository.getClientByEmail(newManager.getEmail()).isPresent()){
            throw new EmailAlreadyExistsException("Email already existing");
        }
        inMemoryManagerRepository.createNewManager(newManager);

    }
    public Manager getManagerByEmail(String email) {
        return inMemoryManagerRepository.getManagerByEmail(email).get();
    }
    



    
}
