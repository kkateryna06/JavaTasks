package day01;

public class BankAccount {
    private final int accountNumber;
    private String ownerName;
    private long balance;

    BankAccount(int accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
    }

    BankAccount(int accountNumber, String ownerName, long balance) {
        this(accountNumber, ownerName);
        if (balance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be a negative number");
        }
        this.balance = balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public long getBalance() {
        return balance;
    }

    public boolean deposit(long amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(long amount) {
        if (amount <= 0) {
            return false;
        } else if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public boolean transferTo(long amount, BankAccount recipient) {
        boolean operationResult = withdraw(amount);
        if (operationResult) {
            recipient.deposit(amount);
            return true;
        }
        return false;
    }

}
