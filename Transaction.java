package FinalBankProject;


import java.util.Date;

public class Transaction {

    private double amount;
    private Date timestamp;
    private Account account;


    public Transaction(double amount, Date timestamp, Account account) {
        this.amount = amount;
        this.timestamp = timestamp;
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Account getAccount() {
        return account;
    }
}
