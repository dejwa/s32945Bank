package pl.pjatk.s32945Bank.Class;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import pl.pjatk.s32945Bank.Model.Client;
import pl.pjatk.s32945Bank.Model.Deposit;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DepositStorageTest {

    private DepositStorage depositStorage;

    //@Mock
    //private Client client1;
    //private Client client2;
    //private ClientStorage mockClientStorage;


    @BeforeEach void setUp() {
        depositStorage = new DepositStorage();
        depositStorage.addDeposit(1,35.98);
        depositStorage.addDeposit(2,49.00);
        depositStorage.addDeposit(1,3752.12);

        //when(client1.getBalance()).thenReturn(99999.00);
        //when(client2.getBalance()).thenReturn(3.50);
        //when(mockClientStorage.)
    }

    @Test
    void depositAdd() {
        depositStorage.addDeposit(3,99.99);
        assertEquals(4,depositStorage.getDeposits().size());
    }

    @Test
    void depositRemove() {
        depositStorage.removeDeposit(2);
        assertEquals(2,depositStorage.getDeposits().size());
    }

    @Test
    void removeDeclined(){
        depositStorage.getDeposits().get(0).insuficientStatus();
        depositStorage.getDeposits().get(1).notFoundStatus();
        depositStorage.getDeposits().get(2).declineStatus();
        depositStorage.removeDeclined();
        assertEquals(0,depositStorage.getDeposits().size());
    }

}