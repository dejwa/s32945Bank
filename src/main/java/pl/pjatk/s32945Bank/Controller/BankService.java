package pl.pjatk.s32945Bank.Controller;

import pl.pjatk.s32945Bank.Class.ClientStorage;
import pl.pjatk.s32945Bank.Class.DepositStorage;
import pl.pjatk.s32945Bank.Class.TransferStorage;

public class BankService {
    private ClientStorage clientStorage;
    private TransferStorage transferStorage;
    private DepositStorage depositStorage;

    public BankService(ClientStorage clientStorage, TransferStorage transferStorage, DepositStorage depositStorage) {
        this.clientStorage = clientStorage;
        this.transferStorage = transferStorage;
        this.depositStorage = depositStorage;
    }


}
