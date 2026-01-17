package pl.pjatk.s32945Bank.Model;

public class Transfer {
    private int id,id_client;
    private double amount;
    //private String title;
    private Status status;

    public Transfer(int id, int id_client, double amount) {
        this.id = id;
        this.id_client = id_client;
        this.amount = amount;
        this.status = Status.PENDING;
    }

    public int getId() {
        return id;
    }
    public int getIdClient() {
        return id_client;
    }
    public double getAmount() {
        return amount;
    }
    public Status getStatus() {
        return status;
    }

    public void acceptStatus() {
        if (this.status != Status.DECLINED) {
            this.status = Status.ACCEPTED;
        }
    }
    public void declineStatus() {
        this.status = Status.DECLINED;
    }
    public void insuficientStatus() {
        this.status = Status.DECLINED_INSUFFICIENT;
    }
    public void notFoundStatus() {
        this.status = Status.DECLINED_NOT_FOUND;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
}
