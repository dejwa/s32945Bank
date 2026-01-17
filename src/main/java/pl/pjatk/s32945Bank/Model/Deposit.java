package pl.pjatk.s32945Bank.Model;

public class Deposit {
    private int id,id_client;
    private double amount;
    private Status status;

    public Deposit(int id, int id_client, double amount, Status status) {
        this.id = id;
        this.id_client = id_client;
        this.amount = amount;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public Status getStatus() {
        return status;
    }
    public int getIdClient() {
        return id_client;
    }
    public double getAmount() {
        return amount;
    }

    public void acceptStatus() {
        if (status != Status.DECLINED) {
            this.status = Status.ACCEPTED;
        }
    }
    public void declineStatus() {
        this.status = Status.DECLINED;
    }
}
