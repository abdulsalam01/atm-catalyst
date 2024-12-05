/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.dkatalis.atm.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author abdulsalam
 */
public class TransferTransactionTest {
    
    public TransferTransactionTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        Auth.setLogin("Bob");
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of transaction method, of class TransferTransaction.
     */
    @Test
    public void testTransaction() throws Exception {
        System.out.println("transaction");
        
        double amount = 0.0;
        String[] target = {"transfer", "abdul", "100"};
        TransferTransaction instance = new TransferTransaction();
        double expResult = 0.0;
        double result = instance.transaction(amount, target);

        assertEquals(expResult, result, 0);
    }
    
}
