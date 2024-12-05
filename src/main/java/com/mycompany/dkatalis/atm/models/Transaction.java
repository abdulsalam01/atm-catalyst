/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dkatalis.atm.models;

import com.mycompany.dkatalis.atm.constants.Defaults;
import com.mycompany.dkatalis.atm.constants.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author abdulsalam
 */
public abstract class Transaction {

    protected static final Map<String, Customer> listCustomerTransaction = new HashMap<>();
    protected static final Map<String, List<HistoryTransaction>> listHistory = new HashMap<>();

    public abstract double transaction(double amount, String... target) throws Exception;

    public String getHistory() {
        String key = Auth.getCurrentAccount();
        StringBuilder listHistories = new StringBuilder();
        List<HistoryTransaction> histories = Transaction.listHistory.get(key);

        if (histories == null) {
            return Defaults.DEFAULT_STRING;
        }
        for (HistoryTransaction history : histories) {
            listHistories.append(history);
            listHistories.append("\n");
        }

        return listHistories.toString();
    }

    public double getCurrentBalance() {
        String key = Auth.getCurrentAccount();
        Customer customer = Transaction.listCustomerTransaction.get(key);
        
        return customer == null ? Defaults.DEFAULT_DOUBLE : customer.getBalance();
    }

    protected double syncBalance(double amount, Type.Transaction type, String... acc) throws Exception {
        String key = acc.length == Defaults.DEFAULT_INT
                ? Auth.getCurrentAccount()
                : acc[0];

        double currentBalance = 0;
        Customer customer = Transaction.listCustomerTransaction.get(key);
        if (customer != null) {
            currentBalance = customer.getBalance();
        } else {
            Auth.setMember(key);
        }

        double balance = Type.getCalculation(amount, currentBalance, type);
        if (balance < 1) {
            return balance;
        }

        return balance;
    }

    protected void syncHistory(Type.Transaction type, double amount, double balance, String... acc) {
        String key = acc.length == Defaults.DEFAULT_INT
                ? Auth.getCurrentAccount()
                : acc[0];

        List<HistoryTransaction> currHistory = Transaction.listHistory.get(key);
        if (currHistory == null) {
            currHistory = new ArrayList<>();
        }

        HistoryTransaction history = new HistoryTransaction();
        history.preformatHistory(
                Auth.getCurrentAccount(), 
                type, amount, 
                balance, acc
        );
        currHistory.add(history);

        Transaction.listCustomerTransaction.put(key, new Customer(key, balance, type));
        Transaction.listHistory.put(key, currHistory);
    }

    private String preformatHistory(Type.Transaction type, double amount, double balance, String... acc) {
        String key = acc.length == Defaults.DEFAULT_INT
                ? Auth.getCurrentAccount()
                : acc[0];        
        String history = String.format("%s %s %f", key, type.name(), amount);
        if (type == Type.Transaction.TRANSFER) {
            history = String.format("%s to %s", history, acc[0]);
        }
        
        return history;
    }
}
