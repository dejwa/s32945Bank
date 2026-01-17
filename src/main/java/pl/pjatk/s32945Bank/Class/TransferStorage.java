package pl.pjatk.s32945Bank.Class;

import org.springframework.stereotype.Component;
import pl.pjatk.s32945Bank.Model.Status;
import pl.pjatk.s32945Bank.Model.Transfer;

import java.util.ArrayList;

@Component
public class TransferStorage {
    private ArrayList<Transfer> transfers;
    private int idCounter = 1;

    public TransferStorage() {
        this.transfers = new ArrayList<>();
    }

    public Transfer addTransfer(Transfer transfer) {
        this.transfers.add(transfer);
        return transfer;
    }

    public Transfer addTransfer(int id_client, double amount) {
        Transfer t = new Transfer(idCounter++, id_client, amount);
        this.transfers.add(t);
        return t;
    }

    public void removeTransfer(Transfer transfer) {
        this.transfers.remove(transfer);
    }
    public void removeTransfer(int id) {
        this.transfers.stream().filter( t -> t.getId() == id ).findFirst().ifPresent( t-> this.transfers.remove(t) );
    }
    public void removeDeclined() {
        this.transfers.removeIf( t -> t.getStatus() == Status.DECLINED );
    }

    public ArrayList<Transfer> getTransfers() {
        return transfers;
    }
}
