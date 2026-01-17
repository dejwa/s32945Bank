package pl.pjatk.s32945Bank.Class;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import pl.pjatk.s32945Bank.Model.Client;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class ClientStorageTest {

    private ClientStorage clientStorage;

    @BeforeEach void setUp() {
        clientStorage = new ClientStorage();
    }

    @Test
    void insertClient() {
        clientStorage.addClient("Student","Pjatka",3.50);
        assertEquals(clientStorage.getClients().size(), 1);
    }

    @Test
    void findByIdTest() {
        clientStorage.addClient("BoJack","Horseman",9000000.00);
        clientStorage.addClient("Todd","Chavez",90.35);

        assertEquals(true, clientStorage.findById(2).isPresent());
    }

    @Test
    void findByIdTestNotFound() {
        clientStorage.addClient("BoJack","Horseman",9000000.00);
        clientStorage.addClient("Todd","Chavez",90.35);

        assertEquals(false, clientStorage.findById(99).isPresent());
    }

    @Test
    void removeClient() {
        clientStorage.addClient("BoJack","Horseman",9000000.00);
        clientStorage.addClient("Todd","Chavez",90.35);
        clientStorage.removeClient(1);
        assertEquals("Todd",clientStorage.getClients().get(0).getName());
    }

}