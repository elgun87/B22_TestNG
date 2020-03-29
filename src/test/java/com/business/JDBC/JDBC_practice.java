package com.business.JDBC;

import com.business.Utilities.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.prefs.BackingStoreException;

public class JDBC_practice {
    /**
     *           CONNECTION INFORMATION
     * Url:
     * String URL ="jdbc:postgresql://localhost:5432/hr"
     * Username and Password :
     * String dbUsername="postgres";
     * String dbPassword ="abc";
     */

    String url = "jdbc:postgresql://room-reservation-qa.cxvqfpt4mc2y.us-east-1.rds.amazonaws.com:5432/hr";
    String username = "hr";
    String password = "hr";
    Statement statement;
    Connection connection;
    ResultSet resultSet;

    @BeforeMethod
    public void establishConnection() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    @Test
    public void jdbcTest1() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM employees order by first_name asc;");
        resultSet.next();
        /* Get  first_name and last_name in 1st occurred row */
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        System.out.println(firstName + " " + lastName);
        /*  Get all first_names and last_names  from Employees table */
        while (resultSet.next()) {
            System.out.println(resultSet.getString("first_name") +
                    " " + resultSet.getString("last_name"));
        }
    }

    @AfterMethod
    public void closingConnections() throws SQLException {
        // Close the connection (must)
        resultSet.close();
        statement.close();
        connection.close();
    }
}


