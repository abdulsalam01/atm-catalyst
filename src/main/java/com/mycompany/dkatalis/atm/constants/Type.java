/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dkatalis.atm.constants;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author abdulsalam
 */
public class Type {
    public static enum Transaction {
        INITIAL,
        DEPOSIT,
        WITHDRAW,
        TRANSFER,
        OWED,
    };
    
    public static double getCalculation(double amount, double balance, Transaction type) {
        return mapValues(amount, balance).get(type);
    }
    
    public static Map<Transaction, Double> mapValues(double amount, double balance) {
        Map<Transaction, Double> transactionTypeMaps = new HashMap<>();
        
        transactionTypeMaps.put(Transaction.INITIAL, 0.0);
        transactionTypeMaps.put(Transaction.DEPOSIT, balance + amount);
        transactionTypeMaps.put(Transaction.OWED, balance + amount);
        transactionTypeMaps.put(Transaction.TRANSFER, balance - amount);
        transactionTypeMaps.put(Transaction.WITHDRAW, balance - amount);
        
        return transactionTypeMaps;
    }
}
