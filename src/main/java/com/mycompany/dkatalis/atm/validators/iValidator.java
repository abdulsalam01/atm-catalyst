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
public interface iValidator {
    boolean validate(String[] parts, Transaction transaction);
    void setNext(iValidator next);
}
