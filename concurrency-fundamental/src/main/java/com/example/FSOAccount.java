package com.example;

public class FSOAccount {

    private double balance;

    public FSOAccount(double openingBalance) {
        // Check to see openingBalance > 0, throw if not
        balance = openingBalance;
    }

    public synchronized void deposit(final int amount) {
        // Check to see amount > 0, throw if not
        balance = balance + amount;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized boolean transferTo(FSOAccount other, int amount) {
// Check to see amount > 0, throw if not
// Simulate some other checks that need to occur
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if (balance >= amount) {
            balance = balance - amount;
            other.deposit(amount);
            return true;
        }
        return false;
    }
}
