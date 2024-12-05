/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.dkatalis.atm.validators;

import com.mycompany.dkatalis.atm.models.Transaction;
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
public class LoginValidatorTest {
    
    public LoginValidatorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of validate method, of class LoginValidator.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        
        String[] parts = {"login", "bob"};
        Transaction transaction = null;
        LoginValidator instance = new LoginValidator();
        boolean expResult = false;
        boolean result = instance.validate(parts, transaction);

        assertEquals(expResult, result);
    }
    
}
