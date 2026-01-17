package pl.pjatk.s32945Bank.Class;

import org.springframework.stereotype.Component;
import pl.pjatk.s32945Bank.Model.Deposit;
import pl.pjatk.s32945Bank.Model.Status;

import java.util.ArrayList;

@Component
public class DepositStorage {
    private ArrayList<Deposit> deposits;
    private int idCounter = 1;

    public DepositStorage() {
        this.deposits = new ArrayList<>();
    }

    public Deposit addDeposit(Deposit deposit) {
        this.deposits.add(deposit);
        return deposit;
    }
    public Deposit addDeposit(int id_client, double amount) {
        Deposit d = new Deposit(idCounter++, id_client, amount);
        this.deposits.add(d);
        return d;
    }

    public void removeDeposit(Deposit deposit) {
        this.deposits.remove(deposit);
    }
    public void removeDeposit(int id) {
        this.deposits.stream().filter( d -> d.getId() == id ).findFirst().ifPresent( d-> this.deposits.remove(d) );
    }
    public void removeDeclined() {
        this.deposits.removeIf( d -> d.getStatus() == Status.DECLINED || d.getStatus() == Status.DECLINED_INSUFFICIENT || d.getStatus() == Status.DECLINED_NOT_FOUND );
    }

    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }
}
