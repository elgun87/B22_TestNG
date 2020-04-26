package com.business.Tests;

import com.business.Utilities.ConfigReader;
import com.business.Utilities.DBUtils;
import com.mongodb.DB;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.transform.sax.SAXSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBC_stepByStep {
    //Connection info:
    //jdbc:postgresql:(jdbc db driver)//ip where db is : 5432(port) + /hr (dbname)
    private String hrdbURL = ConfigReader.getProperty("hrdbUrl");
    private String hrdbUsername = ConfigReader.getProperty("hrdbUser");  //hr
    private String hrdbPassword = ConfigReader.getProperty("hrdbPassword");  //hr


    @Test(enabled = false)
    public void dataBaseTesting() throws SQLException {
        DBUtils.createConnection(hrdbURL, hrdbUsername, hrdbPassword);
        ResultSet resultEmployees = DBUtils.executeQuery("SELECT first_name from employees ;");
        resultEmployees.next(); //if we don't use while loop,then we need to skip first row always.
        List<String> names = new ArrayList<>();
        while (resultEmployees.next()) {
            names.add(resultEmployees.getString("first_name"));
        }
        for (String name : names) {
            System.out.println(name);
        }
        Assert.assertTrue(names.contains("John"));

        // Countries table
        ResultSet countriesRes = DBUtils.executeQuery("select * from countries ;");
        while (countriesRes.next()) {
            System.out.println(countriesRes.getObject("country_id") + " - "
                    + countriesRes.getObject("country_name") + " - "
                    + countriesRes.getObject("region_id"));
        }
        countriesRes.last(); // -> points to last row (void method)
        int rowCount = countriesRes.getRow(); //Before checking rows count MUST point to last row!
        System.out.println("Total rows count in table is " + rowCount); // 25
        DBUtils.destroy(); // close connection
    }


    @Test
    public void metadataTesting() throws SQLException {
        DBUtils.createConnection(hrdbURL, hrdbUsername, hrdbPassword);
        String query = "select * from employees;";
        // Using DBUtil get ROWSCOUNT in the result
        int rowsCountInResult = DBUtils.executeQueryAndGetRowsCount(query);
        System.out.println("total row count is :" + rowsCountInResult);
        // Using DBUtil get total COLUMNSCOUNT in the result
        int columnsCount = DBUtils.executeQueryAndGetColumnsCount(query);
        System.out.println("total columns count is :" + columnsCount);
        // Using DBUtil class get COLUMNSNAMES in the result
        List<String> columnNames = DBUtils.executeQueryAndGetColumnsNames(query);
        System.out.println(columnNames);
        // Using DBUtil class get ALL VALUES IN GIVEN COLUMN in result
        List<String> names = DBUtils.executeQueryAndGetColumnValues(query, "last_name");
        System.out.println(names);
        // Using DBUtil get RESULT AS LIST OF LISTS (each row is one list)
        List<List<Object>> resultAsList = DBUtils.executeQueryAndGetResultAsList(query);
        for (int i = 0; i < resultAsList.size(); i++) {
            System.out.println(resultAsList.get(i).toString());
        }



        /*ResultSet metadata
        using without DBUtil class, if we have UTIL class no need to this*/
        ResultSet resultset = DBUtils.executeQuery(query);
        ResultSetMetaData rsMetadata = resultset.getMetaData();
        // gets total columns count in result
        System.out.println("Columns count " + rsMetadata.getColumnCount());
        // gets column name by the given index 2
        System.out.println("Column name of 2 " + rsMetadata.getColumnName(2));
        // get all column names
        for (int i = 1; i <= rsMetadata.getColumnCount(); i++) {
            System.out.print(rsMetadata.getColumnName(i) + " " + "\t");
        }
        System.out.println();

        DBUtils.destroy();
    }


}
