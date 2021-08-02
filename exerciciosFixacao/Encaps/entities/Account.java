package cursoUdemyNelio.exerciciosFixacao.Encaps.entities;

public class Account {

    private int number;
    private String holder;
    private double balance;

    public Account(String holder, int number, double initialDeposit) {
        this.holder = holder;
        this.number = number;
        deposit(initialDeposit);
    }

    public Account(String holder, int number) {
        this.holder = holder;
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public int getNumber() {
        return number;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount + 5;
    }

    public String toString() {
        String s = "Account " + getNumber();
        s += ", Holder: " + getHolder();
        s += ", Balance: $ " + String.format("%.2f", getBalance());
        return s;
    }

}
