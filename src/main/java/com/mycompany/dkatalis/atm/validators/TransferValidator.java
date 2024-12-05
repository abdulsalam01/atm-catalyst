/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dkatalis.atm.validators;

import com.mycompany.dkatalis.atm.models.Transaction;
import com.mycompany.dkatalis.atm.constants.Type;
import com.mycompany.dkatalis.atm.models.Auth;

/**
 *
 * @author abdulsalam
 */
public class TransferValidator extends Validator {

    @Override
    public boolean validate(String[] parts, Transaction transaction) {
        if (parts[0].equals(Type.Transaction.TRANSFER.name().toLowerCase())) {            
            if (parts.length != 3 || !parts[2].matches("\\d+")) {
                System.out.println("Usage: transfer [target] [amount]");
                return false;
            }            
            if (Double.parseDouble(parts[2]) > transaction.getCurrentBalance()) {
                return false;
            }
            if (parts[1].equals(Auth.getCurrentAccount())) {
                return false;
            }
        }
        
        return super.validate(parts, transaction);
    }
}
