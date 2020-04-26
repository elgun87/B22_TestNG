package com.business.Tests;

import com.business.Utilities.DBUtils;
import com.mongodb.DB;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBC_tasks {
    /**
     * Connect to DB
     * Verify employee id 105 belongs to Kamil Austin;
     */

    @Test
    public void nameTestById() throws SQLException {
        DBUtils.createConnectionToHrDB();
        String query = "select first_name,last_name from employees where employee_id=105;";
        ResultSet resultSet = DBUtils.executeQuery(query);
        resultSet.next();
        String name = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        Assert.assertEquals(name, "Kamil");
        Assert.assertEquals(lastName, "Austin");
        // OR WE CAN store result in the List of Maps
        List<Map<String, Object>> resultAsListOfMaps = DBUtils.executeQueryAndGetResultMap(query);
        Object name2 = resultAsListOfMaps.get(0).get("first_name");
        Object lastName2 = resultAsListOfMaps.get(0).get("last_name");
        Assert.assertEquals(name2, "Kamil");
        Assert.assertEquals(lastName2, "Austin");

    }


}
