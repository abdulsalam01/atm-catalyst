/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dkatalis.atm.models;

import com.mycompany.dkatalis.atm.constants.Type;

/**
 *
 * @author abdulsalam
 */
public class WithdrawTransaction extends Transaction {

    @Override
    public double transaction(double amount, String... target) throws Exception {
        Type.Transaction transactionType = Type.Transaction.WITHDRAW;
        double balance = syncBalance(amount, transactionType);

        syncHistory(transactionType, amount, balance);
        return balance;
    }

}
