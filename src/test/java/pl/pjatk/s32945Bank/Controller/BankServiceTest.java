package pl.pjatk.s32945Bank.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import pl.pjatk.s32945Bank.Class.ClientStorage;
import pl.pjatk.s32945Bank.Class.DepositStorage;
import pl.pjatk.s32945Bank.Class.TransferStorage;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BankServiceTest {

    //private BankService bs;

    @Mock
    private ClientStorage mockClientStorage;
    private DepositStorage depositStorage;
    private TransferStorage transferStorage;

    @InjectMocks
    private BankService bankService;

    @BeforeEach
    void setUp() {

    }

}