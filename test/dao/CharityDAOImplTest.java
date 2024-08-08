/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import entity.Charity;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import utils.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Unit tests for the CharityDAOImpl class.
 * This class tests the database operations for Charity entities using mocks.
 */
public class CharityDAOImplTest {

    private CharityDAO charityDAO;
    private QueryRunner queryRunner;

    @Mock
    private Connection connection;

    /**
     * Sets up the test environment before each test method.
     * This method initializes the DAO and mocks necessary components.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Mock the QueryRunner
        queryRunner = mock(QueryRunner.class);

        // Mock the DbUtil.getConnection() method
        mockStatic(DbUtil.class);
        when(DbUtil.getConnection()).thenReturn(connection);

        // Initialize the DAO
        charityDAO = new CharityDAOImpl();
        ((CharityDAOImpl) charityDAO).queryRunner = queryRunner; // Inject mocked QueryRunner
    }

    /**
     * Tests the insertCharity method of the CharityDAOImpl class.
     * This test verifies that a new charity is inserted into the database.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testInsertCharity() throws SQLException {
        Charity charity = new Charity("charityUser", "password", "charity@example.com", "1234567890", "Charity", 1);

        when(queryRunner.update(any(Connection.class), anyString(), any(), any(), any(), any(), any(), any())).thenReturn(1);

        int rowsAffected = charityDAO.insertCharity(charity);
        assertEquals(1, rowsAffected);

        // Verify that the queryRunner.update() method was called with correct parameters
        verify(queryRunner).update(eq(connection), eq("insert into Charity (userName, password, email, phone, userType, locationID) values (?, ?,?,?,?,?);"),
                eq(charity.getUsername()), eq(charity.getPassword()), eq(charity.getEmail()), eq(charity.getPhone()), eq(charity.getUserType()), eq(charity.getLocationID()));
    }

    /**
     * Tests the selectCharityByEmail method of the CharityDAOImpl class.
     * This test verifies that a charity is selected by its email.
     *
     * @throws SQLException if a database access error occurs
     */
    @Test
    public void testSelectCharityByEmail() throws SQLException {
        Charity expectedCharity = new Charity("charityUser", "password", "charity@example.com", "1234567890", "Charity", 1);

        when(queryRunner.query(any(Connection.class), anyString(), any(BeanHandler.class), anyString())).thenReturn(expectedCharity);

        Charity actualCharity = charityDAO.selectCharityByEmail("charity@example.com");
        assertNotNull(actualCharity);
        assertEquals(expectedCharity, actualCharity);

        // Verify that the queryRunner.query() method was called with correct parameters
        verify(queryRunner).query(eq(connection), eq("select * from Charity where email = ?;"), any(BeanHandler.class), eq("charity@example.com"));
    }
}
