package com.business.Tests;

import com.business.Utilities.ConfigReader;
import com.business.Utilities.DBUtils;
import com.mongodb.DB;
import org.junit.Test;
import org.testng.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBC_practice {

    private String hrdbURL = ConfigReader.getProperty("hrdbUrl");
    private String hrdbUsername = ConfigReader.getProperty("hrdbUser");
    private String hrdbPassword = ConfigReader.getProperty("hrdbPassword");


    @Test
    public void dataBaseTesting() throws SQLException {
        DBUtils.createConnection(hrdbURL, hrdbUsername, hrdbPassword);
        ResultSet result = DBUtils.executeQuery("SELECT first_name from employees ;");
        List<String> names = new ArrayList<>();
        while (result.next()) {
            names.add(result.getString("first_name"));
        }
        for (String name : names) {
            System.out.println(name);
        }
        Assert.assertTrue(names.contains("John"));

    }


}
