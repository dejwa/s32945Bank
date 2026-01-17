package pl.pjatk.s32945Bank.Model;

public class Client {
    private String name, surname;
    private int id;
    private double balance;

    public Client(int id, String name, String surname, double balance) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getId() {
        return id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void addToBalance(double amount) {
        this.balance += amount;
    }
    public void subFromBalance(double amount) {
        this.balance -= amount;
    }


}
