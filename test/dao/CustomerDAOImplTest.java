/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import entity.Customer;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tangy
 */
public class CustomerDAOImplTest {
    
    public CustomerDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of selectAllCustomer method, of class CustomerDAOImpl.
     */
    @Test
    public void testSelectAllCustomer() {
        System.out.println("selectAllCustomer");
        CustomerDAOImpl instance = new CustomerDAOImpl();
        List<Customer> expResult = null;
        List<Customer> result = instance.selectAllCustomer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCustomer method, of class CustomerDAOImpl.
     */
    @Test
    public void testDeleteCustomer() {
        System.out.println("deleteCustomer");
        String email = "";
        CustomerDAOImpl instance = new CustomerDAOImpl();
        int expResult = 0;
        int result = instance.deleteCustomer(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCustomer method, of class CustomerDAOImpl.
     */
    @Test
    public void testUpdateCustomer() {
        System.out.println("updateCustomer");
        Customer customer = null;
        CustomerDAOImpl instance = new CustomerDAOImpl();
        int expResult = 0;
        int result = instance.updateCustomer(customer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertCustomer method, of class CustomerDAOImpl.
     */
    @Test
    public void testInsertCustomer() {
        System.out.println("insertCustomer");
        Customer customer = null;
        CustomerDAOImpl instance = new CustomerDAOImpl();
        int expResult = 0;
        int result = instance.insertCustomer(customer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectCustomerByEmail method, of class CustomerDAOImpl.
     */
    @Test
    public void testSelectCustomerByEmail() {
        System.out.println("selectCustomerByEmail");
        String email = "";
        CustomerDAOImpl instance = new CustomerDAOImpl();
        Customer expResult = null;
        Customer result = instance.selectCustomerByEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserIDByEmail method, of class CustomerDAOImpl.
     */
    @Test
    public void testGetUserIDByEmail() {
        System.out.println("getUserIDByEmail");
        String email = "";
        CustomerDAOImpl instance = new CustomerDAOImpl();
        int expResult = 0;
        int result = instance.getUserIDByEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserTypeByUserID method, of class CustomerDAOImpl.
     */
    @Test
    public void testGetUserTypeByUserID() {
        System.out.println("getUserTypeByUserID");
        Customer customer = null;
        CustomerDAOImpl instance = new CustomerDAOImpl();
        String expResult = "";
        String result = instance.getUserTypeByUserID(customer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
