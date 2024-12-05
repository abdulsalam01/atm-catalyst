/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dkatalis.atm.validators;

import com.mycompany.dkatalis.atm.models.Transaction;

/**
 *
 * @author abdulsalam
 */
abstract class Validator implements iValidator {

    private iValidator next;

    public void setNext(iValidator next) {
        this.next = next;
    }
    
    public boolean validate(String[] parts, Transaction transact) {
        if (next != null) {
            return next.validate(parts, transact);
        }
        
        return true;
    }
}
