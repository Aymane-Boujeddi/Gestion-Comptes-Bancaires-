package Model;

import java.time.LocalDate;
import java.util.UUID;

public class Transaction {
    private String transactionId;
    private Double amount;
    private LocalDate date;
    private String motif;
    private String sourceAccountId;
    private String destinationAccountId;

    public Transaction(Double amount, LocalDate date, String motif, String sourceAccountId, String destinationAccountId) {
        this.amount = amount;
        this.date = date;
        this.motif = motif;
        this.sourceAccountId = sourceAccountId;
        this.destinationAccountId = destinationAccountId;
        this.transactionId = UUID.randomUUID().toString();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(String sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public String getDestinationAccountId() {
        return destinationAccountId;
    }

    public void setDestinationAccountId(String destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
    }
}
