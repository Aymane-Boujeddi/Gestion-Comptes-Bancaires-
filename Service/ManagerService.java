package Service;

import Repository.impl.InMemoryManagerRepository;

public class ManagerService {
    private InMemoryManagerRepository inMemoryManagerRepository;


    public ManagerService(InMemoryManagerRepository inMemoryManagerRepositor) {
        this.inMemoryManagerRepository = inMemoryManagerRepository;

    }

    
}
