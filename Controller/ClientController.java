package Controller;

import Service.ClientService;

import java.util.Scanner;

public class ClientController {
    private Scanner scanner;
    private ClientService clientService;


    public ClientController(ClientService clientService,Scanner scanner) {
        this.scanner = scanner;
        this.clientService = clientService;
    }



}
