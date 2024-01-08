package entities;

import interfaces.MyComparable;

public class Account implements MyComparable<Account> {

    private String owner;
    private int balance;

    public String getowner() {
        return owner;
    }

    public void setowner(String owner) {
        this.owner = owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Account(String owner, int balance) {
        super();
        this.owner = owner;
        this.balance = balance;
    }

    public Account(String owner) {
        this(owner, 0);
    }

    @Override
    public int compareTo(Account t) {
        if (t == null) {
            return -1;
        }
        if (this == t) {
            return 0;
        }
        if (this.getBalance() > t.getBalance()) {
            return -1;
        }
        if (this.getBalance() < t.getBalance()) {
            return 1;
        }
        return 0;
    }

}
