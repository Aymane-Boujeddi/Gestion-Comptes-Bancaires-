package Model;

import java.util.ArrayList;
import java.util.List;

public class Client extends Personne{
    private List<Account> accounts ;


    public Client(String name, String lastName, String email, String password) {
        super(name, lastName, email, password);
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    public void addAccount(Account account){
        this.accounts.add(account);
    }

    @Override
    public String toString() {
        return "\n=== CLIENT INFORMATION ===\n" +
                "Name: " + name + "\n" +
                "Last Name: " + lastName + "\n" +
                "Email: " + email + "\n" +
                "Password: ********\n" +
                "==========================";
    }


}
