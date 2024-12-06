/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dkatalis.atm.validators;

import com.mycompany.dkatalis.atm.models.Auth;
import com.mycompany.dkatalis.atm.models.Transaction;

/**
 *
 * @author abdulsalam
 */
public class LoginValidator extends Validator {

    @Override
    public boolean validate(String[] parts, Transaction transaction) {
        if (!Auth.isLoggedIn()) {
            return false;
        }
        
        return super.validate(parts, transaction);
    }    
}
