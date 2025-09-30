package Controller;

import Model.Client;
import Service.TransactionService;

import java.util.Scanner;

public class TransactionController {
    private Scanner scanner;
    private TransactionService transactionService;
    private Client currentClient;

    public TransactionController(Scanner scanner, TransactionService transactionService) {
        this.scanner = scanner;
        this.transactionService = transactionService;

    }


}
