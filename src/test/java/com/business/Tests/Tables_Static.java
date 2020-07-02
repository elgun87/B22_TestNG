package com.business.Tests;

import com.business.Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

public class Tables_Static extends Base {
    /**
     * TABLES
     * Table in Website has a tag --> table
     * Table made of rows and columns
     * tbody : table body
     * tr :row
     * td : columns
     * ------------
     * thead : header of the table, usually contains the columns names.
     * tr: row         tr  -> INDEX STARTS FROM 1
     * th: header      th -> INDEX STARTS FROM 1
     * table
     * tbody                              HTML STARTS INDEX FROM 1 , BUT JAVA FROM 0  !
     * tr
     * th
     * th
     */

    String homePage = "https://the-internet.herokuapp.com/tables";

    @Test
    public void find_All_Headers_And_Get_Names() {
        extentLogger = extentReports.createTest("find_All_Headers_And_Get_Names");
        driver.get(homePage);
        // wholeTableXpath //th
        List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@id='table1']//th"));
        for (WebElement header : allHeaders) {
            System.out.println(header.getText() + " ");
        }
        // Find 3rd header in table and get name .
        WebElement header3 = allHeaders.get(2);
        Assert.assertEquals(header3.getText(), "Email");
    }

    @Test
    public void find_Certain_Header_direct_in_HTML() {
        extentLogger = extentReports.createTest("find_Certain_Header_direct_in_HTML");
        driver.get(homePage);
        // Find 3rd header in table direct !
        WebElement header3 = driver.findElement(By.xpath("//table[@id='table1']//th[3]"));
        System.out.println(header3.getText());
        Assert.assertEquals(header3.getText(), "Email");
    }


    @Test
    public void find_All_Rows_And_Get_All_Values() {
        extentLogger = extentReports.createTest("find_All_Rows_And_Get_All_Values");
        driver.get(homePage);
        //  Find  ALL ROWS IN TABLE
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        // find size of All rows in table
        int size = allRows.size();
        // print all cells of rows as columns in row
        for (WebElement row : allRows) {
            System.out.println(row.getText());
        }
        // Find  3rd row in a table with it's cells
        System.out.println(allRows.get(2).getText());
        String expected = "Doe Jason jdoe@hotmail.com $100.00 http://www.jdoe.com edit delete";
        Assert.assertTrue(allRows.get(2).getText().equalsIgnoreCase(expected));
    }

    @Test
    public void find_All_Cells_in_Certain_Row_direct_in_HTML() {
        extentLogger = extentReports.createTest("find_All_Cells_in_Certain_Row_direct_in_HTML");
        driver.get(homePage);
        // Find 3rd Row and get all values
        WebElement row3 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]"));
        String expected = "Doe Jason jdoe@hotmail.com $100.00 http://www.jdoe.com edit delete";
        Assert.assertTrue(row3.getText().equals(expected));
    }


    @Test
    /** Print the element in c0ordinates:
     * row= 2 ; column =4; verify value is = "$51.00"
     */
    public void find_Certain_Value_With_Row_And_Column_Coordinates() {
        extentLogger = extentReports.createTest("find_Certain_Value_With_Row_And_Column_Coordinates");
        driver.get(homePage);
        // find all rows
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        //  find row 2
        WebElement row2 = allRows.get(1);
        // find all columns in row 2
        List<WebElement> allColumnsInRow2 = row2.findElements(By.tagName("td"));
        // find column 4
        WebElement column4InRow2 = allColumnsInRow2.get(3);
        Assert.assertEquals(column4InRow2.getText(), "$51.00");
    }


    @Test
    public void find_Certain_Value_with_Row_And_Column_Coordinates_direct_in_HTML() {
        extentLogger = extentReports.createTest("find_Certain_Value_with_Row_And_Column_Coordinates_direct_in_HTML");
        driver.get(homePage);
        // Find cell at row 2 column 4
        WebElement row3column4 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td[4]"));
        Assert.assertEquals(row3column4.getText(), "$51.00");
    }

    @Test
    public void find_All_Values_In_Certain_Column_direct_In_HTML() {
        extentLogger = extentReports.createTest("find_All_Values_In_Certain_Column_direct_In_HTML");
        driver.get(homePage);
        //FInd all cells of Column 2 in table
        List<WebElement> column2 = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
        for (WebElement value : column2) {
            System.out.println(value.getText());
        }
    }

    @Test
    public void find_All_Values_In_All_Columns() {
        extentLogger = extentReports.createTest("find_All_Values_In_All_Columns");
        driver.get(homePage);
        //FInd all cells in all Columns
        List<WebElement> column2 = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td"));
        for (WebElement value : column2) {
            System.out.println(value.getText());
        }
    }
}
