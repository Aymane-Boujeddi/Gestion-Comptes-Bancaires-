package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Account {
    private String accountId;
    private String clientId;
    private Double balance;
    private AccountType accountType;
    private List<Transaction> transactions = new ArrayList<>();



    public Account(String clientId, Double balance, AccountType accountType) {
        this.accountId = UUID.randomUUID().toString();
        this.clientId = clientId;
        this.balance = balance;
        this.accountType = accountType;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
