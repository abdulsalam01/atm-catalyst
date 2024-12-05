/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.dkatalis.atm.models;

import com.mycompany.dkatalis.atm.constants.Type;
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
public class AuthTest {
    
    public AuthTest() {
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
     * Test of setLogin method, of class Auth.
     */
    @Test
    public void testSetLogin() {
        System.out.println("setLogin");

        String account = "Bob";
        Auth.setLogin(account);

        assertTrue(Auth.isLoggedIn());        
    }

    /**
     * Test of setLogout method, of class Auth.
     */
    @Test
    public void testSetLogout() {
        System.out.println("setLogout");

        Auth.setLogout();

        assertFalse(Auth.isLoggedIn());
    }


    /**
     * Test of getCurrentSession method, of class Auth.
     */
    @Test
    public void testGetCurrentSession() {
        System.out.println("getCurrentSession");

        Auth.setLogin("Bob");
        Customer expResult = new Customer("Bob", 0, Type.Transaction.OWED);
        Customer result = Auth.getCurrentSession();

        assertEquals(expResult.getName(), result.getName());
    }

    /**
     * Test of getCurrentAccount method, of class Auth.
     */
    @Test
    public void testGetCurrentAccount() {
        System.out.println("getCurrentAccount");

        String expResult = null;
        String result = Auth.getCurrentAccount();

        assertEquals(expResult, result);
    }

    /**
     * Test of isLoggedIn method, of class Auth.
     */
    @Test
    public void testIsLoggedIn() {
        System.out.println("isLoggedIn");
        
        boolean expResult = false;
        boolean result = Auth.isLoggedIn();
        
        assertEquals(expResult, result);
    }
    
}
