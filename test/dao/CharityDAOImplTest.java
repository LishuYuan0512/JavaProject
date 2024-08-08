/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import entity.Charity;
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
public class CharityDAOImplTest {
    
    public CharityDAOImplTest() {
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
     * Test of insertCharity method, of class CharityDAOImpl.
     */
    @Test
    public void testInsertCharity() {
        System.out.println("insertCharity");
        Charity charity = null;
        CharityDAOImpl instance = new CharityDAOImpl();
        int expResult = 0;
        int result = instance.insertCharity(charity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectCharityByEmail method, of class CharityDAOImpl.
     */
    @Test
    public void testSelectCharityByEmail() {
        System.out.println("selectCharityByEmail");
        String email = "";
        CharityDAOImpl instance = new CharityDAOImpl();
        Charity expResult = null;
        Charity result = instance.selectCharityByEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
