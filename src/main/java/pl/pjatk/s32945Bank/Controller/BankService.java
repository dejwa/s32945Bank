package pl.pjatk.s32945Bank.Controller;

import org.springframework.scripting.support.StaticScriptSource;
import pl.pjatk.s32945Bank.Class.ClientStorage;
import pl.pjatk.s32945Bank.Class.DepositStorage;
import pl.pjatk.s32945Bank.Class.TransferStorage;
import pl.pjatk.s32945Bank.Model.Client;
import pl.pjatk.s32945Bank.Model.Deposit;
import pl.pjatk.s32945Bank.Model.Status;
import pl.pjatk.s32945Bank.Model.Transfer;

import java.util.Optional;

public class BankService {
    private ClientStorage clientStorage;
    private TransferStorage transferStorage;
    private DepositStorage depositStorage;

    public BankService(ClientStorage clientStorage, TransferStorage transferStorage, DepositStorage depositStorage) {
        this.clientStorage = clientStorage;
        this.transferStorage = transferStorage;
        this.depositStorage = depositStorage;
    }

    public Status deposit(int id_client, double amount) {
        Deposit d = depositStorage.addDeposit(id_client, amount);
        Optional<Client> c = clientStorage.findById(id_client);
        if (!c.isPresent()) {   //check czy istnieje klient
            d.notFoundStatus();
            return Status.DECLINED_NOT_FOUND;
        }
        Client client = clientStorage.findById(id_client).get();    //pobranie klienta
        d.acceptStatus();
        client.addToBalance(amount);
        return Status.ACCEPTED;
    }

    public Status transfer(int id_client, double amount) {
        Transfer t = transferStorage.addTransfer(id_client, amount);
        Optional<Client> c = clientStorage.findById(id_client);
        if (!c.isPresent()) {
            t.notFoundStatus();
            return Status.DECLINED_NOT_FOUND;
        }
        Client client = clientStorage.findById(id_client).get();
        if (amount <= client.getBalance()) {
            t.acceptStatus();
            client.subFromBalance(amount);
            return Status.ACCEPTED;
        } else {
            t.insuficientStatus();
            return Status.DECLINED_INSUFFICIENT;
        }

    }

}
