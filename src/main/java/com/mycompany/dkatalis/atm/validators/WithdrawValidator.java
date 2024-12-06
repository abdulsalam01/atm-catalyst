/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dkatalis.atm.validators;

import com.mycompany.dkatalis.atm.models.Transaction;
import com.mycompany.dkatalis.atm.constants.Type;

/**
 *
 * @author abdulsalam
 */
public class WithdrawValidator extends Validator {
    @Override
    public boolean validate(String[] parts, Transaction transaction) {
        // Validate if the type is `WITHDRAW`.
        // Validate input length, should be 2.
        // Validate input of second parameters, should be number.
        // Validate input of second parameters, should be less than current balance.
        if (parts[0].equals(Type.Transaction.WITHDRAW.name().toLowerCase())) {
            if (parts.length != 2 || !parts[1].matches("\\d+")) {
                System.out.println("Usage: withdraw [amount]");
                return false;
            }
            if (Double.parseDouble(parts[1]) > transaction.getCurrentBalance()) {
                return false;
            }            
        }
        
        return super.validate(parts, transaction);
    }
}
