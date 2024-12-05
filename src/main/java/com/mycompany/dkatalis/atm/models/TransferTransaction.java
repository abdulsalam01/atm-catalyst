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
public class TransferTransaction extends Transaction {

    @Override
    public double transaction(double amount, String... target) throws Exception {
        Type.Transaction transactionSelfType = Type.Transaction.TRANSFER;
        Type.Transaction transactionTargetType = Type.Transaction.OWED;        

        double balance = syncBalance(amount, transactionSelfType);
        double balanceTarget = syncBalance(amount, transactionTargetType, target);

        syncHistory(transactionSelfType, amount, balance);
        syncHistory(transactionTargetType, amount, balanceTarget, target);

        return balance;
    }

}
