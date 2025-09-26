package Model;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Personne{
    private String department;
    private List<Client> clients;

    public Manager(String name, String lastName, String email, String password,String department) {
        super(name, lastName, email, password);
        this.department = department;
        this.clients = new ArrayList<>();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void addToClientsList(Client client){
        clients.add(client);
    }


}
