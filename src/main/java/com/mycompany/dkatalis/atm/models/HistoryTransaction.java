/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dkatalis.atm.models;

import com.mycompany.dkatalis.atm.constants.Defaults;
import com.mycompany.dkatalis.atm.constants.Type;
import java.util.Date;

/**
 *
 * @author abdulsalam
 */
public class HistoryTransaction {
    private String history;
    private Date timestamps;

    public HistoryTransaction() {
        this.timestamps = new Date();
    }
    
    public HistoryTransaction(String history) {
        this.history = history;
        this.timestamps = new Date();
    }
    
    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Date getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(Date timestamps) {
        this.timestamps = timestamps;
    }

    /**
     * Format the history of transaction in corresponding predefined skeleton of string.
     * @param account
     * @param type
     * @param amount
     * @param balance
     * @param acc
     * @return Formatted String
     */
    public String preformatHistory(String account, Type.Transaction type, double amount, double balance, String... acc) {
        String key = acc.length == Defaults.DEFAULT_INT ? account : acc[0];
        String formattedHistory = String.format("%s %s %f", key, type.name(), amount);
        
        this.history = formattedHistory;
        return this.history;
    }

    @Override
    public String toString() {
        return String.format("[%s]: %s", this.timestamps, this.history);
    }
}
