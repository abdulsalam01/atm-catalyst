/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dkatalis.atm.models;

import com.mycompany.dkatalis.atm.constants.Defaults;
import com.mycompany.dkatalis.atm.constants.Type;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author abdulsalam
 */
public class Auth {

    private static Map<String, Customer> customer = new HashMap<>();
    private static boolean loggedIn;
    private static String account;

    public static void setLogin(String account) {
        if (Auth.isLoggedIn()) {
            return;
        }

        String normalizeAccount = account.toLowerCase();
        if (Auth.customer.get(normalizeAccount) == null) {
            Auth.setMember(account);
        }

        Auth.account = normalizeAccount;
        Auth.loggedIn = true;
    }

    public static void setLogout() {
        Auth.account = Defaults.DEFAULT_STRING;
        Auth.loggedIn = Defaults.DEFAULT_BOOLEAN;
    }

    public static void setMember(String account) {
        String normalizeAccount = account.toLowerCase();
        Customer newCustomer = new Customer(
                account,
                Defaults.DEFAULT_DOUBLE,
                Type.Transaction.INITIAL
        );

        Auth.customer.put(normalizeAccount, newCustomer);
    }
    
    public static Customer getCurrentSession() {
        return Auth.isLoggedIn() ? Auth.customer.get(Auth.account) : null;
    }

    public static String getCurrentAccount() {
        return Auth.account;
    }

    public static boolean isLoggedIn() {
        return Auth.loggedIn;
    }
}
