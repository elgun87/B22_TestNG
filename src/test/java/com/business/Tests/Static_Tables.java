package com.business.Tests;

import com.business.Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

public class Static_Tables extends Base {
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
     *      tbody                              HTML STARTS INDEX FROM 1 , BUT JAVA FROM 0  !
     *           tr
     *             th
     *             th
     */


    @Test
    public void findWholeTable() {
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement table1 = driver.findElement(By.id("table1"));
        System.out.println(table1.getText());
    }

    @Test
    public void findAllHeaders() {
        driver.get("https://the-internet.herokuapp.com/tables");
        // (wholeTableXpath //th )
        List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@id='table1']//th"));
        for (WebElement header : allHeaders) {
            System.out.println(header.getText() + " ");
        }
        // Find 3rd header in table .
        WebElement header3 = allHeaders.get(2);
        Assert.assertEquals(header3.getText(), "Email");
    }

    @Test
    public void findCertainHeader() {
        driver.get("https://the-internet.herokuapp.com/tables");
        // Find 3rd header in table direct !
        WebElement header3 = driver.findElement(By.xpath("//table[@id='table1']//th[3]"));
        System.out.println(header3.getText());
        Assert.assertEquals(header3.getText(), "Email");
    }


    @Test
    public void FindRows() {
        driver.get("https://the-internet.herokuapp.com/tables");
        //  Find  ALL ROWS IN TABLE
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        // find size of All rows
        int size = allRows.size();
        System.out.println(size);  // -> 4
        // print all cells of rows in one line with loop
        for (WebElement row : allRows) {
            System.out.println(row.getText());
        }
        //      Find  3rd row in a table with it's cells
        WebElement row3 = allRows.get(2);
        System.out.println(row3.getText());
        String expected = "Doe Jason jdoe@hotmail.com $100.00 http://www.jdoe.com edit delete";
        Assert.assertTrue(row3.getText().equalsIgnoreCase(expected));
    }

    @Test
    public void findAllCellsOfCertainRow() {
        driver.get("https://the-internet.herokuapp.com/tables");
        // Find 3rd Row
        WebElement row3 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]"));
        String expected = "Doe Jason jdoe@hotmail.com $100.00 http://www.jdoe.com edit delete";
        Assert.assertTrue(row3.getText().equals(expected));
    }


    @Test
    /** Print the element in c0ordinates:
     * row= 2 ; column =4; verify value is = "$51.00"
     */

    public void findCertainCell_WithRowAndColumnCoordinates() {
        driver.get("http://the-internet.herokuapp.com/tables");
        // find all rows
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        //  find row 2
        WebElement row2 = allRows.get(1);
        // find all columns in row 2
        List<WebElement> allCellsInRow2 = row2.findElements(By.tagName("td"));
        // find column 4
        WebElement row2column4 = allCellsInRow2.get(3);
        Assert.assertEquals(row2column4.getText(), "$51.00");
    }


    @Test
    public void findCertainCell_withRowAndColumnCoordinates() {
        driver.get("https://the-internet.herokuapp.com/tables");
        // Find cell at row 2 column 4
        WebElement row3column4 =driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td[4]"));
        Assert.assertEquals(row3column4.getText(), "$51.00");
    }

    @Test
    public void findCells_InCertainColumn () {
        driver.get("https://the-internet.herokuapp.com/tables");
        //FInd all cells of Column 2 in table
        List <WebElement> column3 = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
        for (WebElement cell : column3){
            System.out.println(cell.getText());
        }
    }

}
