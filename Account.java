package FinalBankProject;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private int id;
    private double balance;
    private String name;
    private User accountHolder;
    private List<Transaction> transactions;

    public Account(int id, double balance, String name, User accountHolder) {
        this.id = id;
        this.balance = balance;
        this.name = name;
        this.accountHolder = accountHolder;
        this.transactions = new ArrayList<>();
    }

    public void refill(int replenishment){
        balance = balance+ replenishment;
        System.out.println("You replenished your account on " + replenishment);
        System.out.println("Your balance is " + (int)balance);
    }
    public void withdrawal (int debt){
        balance = balance - debt;
        System.out.println("You have withdrawn from the account " + debt);
        System.out.println("Your balance is " + (int)balance);
    }

    public void transferMines(int debt){
        balance = balance - debt;
    }
    public void transferPlus(int debt){
        balance = balance+ debt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAccountHolder() {
        return accountHolder;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
