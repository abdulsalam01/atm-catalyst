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
public class Customer {

    private String name;
    private double balance;
    private Type.Transaction type;

    public Customer(String name, double balance, Type.Transaction type) {
        this.name = name;
        this.balance = balance;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Type.Transaction getType() {
        return type;
    }

    public void setType(Type.Transaction type) {
        this.type = type;
    }    
}
