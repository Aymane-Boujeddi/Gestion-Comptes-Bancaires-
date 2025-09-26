package Service;

import Model.Client;
import Model.Manager;
import Repository.impl.InMemoryManagerRepository;
import Exception.FailedLoginException;

import java.util.Optional;

public class AuthService {
    private InMemoryManagerRepository inMemoryManagerRepository;

    public AuthService(InMemoryManagerRepository inMemoryManagerRepository) {
        this.inMemoryManagerRepository = inMemoryManagerRepository;
    }

    public String login(String email,String password) throws FailedLoginException  {
        Optional<Client> loginClient = inMemoryManagerRepository.getClientByEmail(email);
        Optional<Manager> loginManager = inMemoryManagerRepository.getManagerByEmail(email);
        if(loginClient.isPresent() && password.equals(loginClient.get().getPassword())){
            return "client";
        } else if (loginManager.isPresent() && password.equals(loginManager.get().getPassword())) {
            return "manager";
        }else{
            throw new FailedLoginException("Email or password not correct ");
        }
    }
}
