package pl.pjatk.s32945Bank.Class;

import org.springframework.stereotype.Component;
import pl.pjatk.s32945Bank.Model.Client;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class ClientStorage {
    private ArrayList<Client> clients;
    private int idCounter;

    public ClientStorage() {
        this.clients = new ArrayList<>();
    }

    public Client addClient(Client client) {
        this.clients.add(client);
        return client;
    }
    public Client addClient(String name, String surname, double balance) {
        Client c = new Client(idCounter++, name, surname, balance);
        this.clients.add(c);
        return c;
    }

    public Optional<Client> findById(int id) {
        return this.clients.stream().filter(c -> c.getId() == id).findFirst();
    }

    public void removeClient(Client client) {
        this.clients.remove(client);
    }
    public void removeClient(int id) {
        this.clients.stream().filter( c -> c.getId() == id ).findFirst().ifPresent( c-> this.clients.remove(c) );
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

}
