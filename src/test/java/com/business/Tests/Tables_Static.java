package com.business.Tests;

import com.business.Utilities.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static Logger log = LogManager.getLogger(Tables_Static.class.getName());
    String homePage = "https://the-internet.herokuapp.com/tables";

    @Test
    public void find_All_Headers_And_Get_Names() {

        driver.get(homePage);
        List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@id='table1']//th"));
        for (WebElement header : allHeaders) {
            log.info(header.getText());
        }
        // Find 3rd header in table and get name .
        WebElement header3 = allHeaders.get(2);
        Assert.assertEquals(header3.getText(), "Email");
    }

    @Test
    public void find_Certain_Header_direct_in_HTML() {

        driver.get(homePage);
        // Find 3rd header in table direct !
        WebElement header3 = driver.findElement(By.xpath("//table[@id='table1']//th[3]"));
        log.info(header3.getText());
        Assert.assertEquals(header3.getText(), "Email");
    }


    @Test   // NOTE: Here getText() method reads all values from row.
    public void find_All_Rows_And_Get_All_Values() {

        driver.get(homePage);
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        int size = allRows.size();
        for (WebElement row : allRows) {
            log.info(row.getText());  // will print all cell in a row
        }
        // Find  3rd row in a table with it's cells
        log.info(allRows.get(2).getText());
        String expected = "Doe Jason jdoe@hotmail.com $100.00 http://www.jdoe.com edit delete";
        Assert.assertTrue(allRows.get(2).getText().equalsIgnoreCase(expected));
    }

    @Test  // Note each row is a WebElement as row (not WebElements)
    public void find_All_Cells_in_Certain_Row_direct_in_HTML() {

        driver.get(homePage);
        // Find 3rd Row and get all values -
        WebElement row3 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]"));
        String expected = "Doe Jason jdoe@hotmail.com $100.00 http://www.jdoe.com edit delete";
        Assert.assertTrue(row3.getText().equals(expected));
    }

    @Test
    public void allCells_In_Certain_Row() {

        driver.get(homePage);
        //Get values of all cells in table
        List<WebElement> allCellsInRow_2 = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[2]/td"));
        for (WebElement cell : allCellsInRow_2) {
            // log.info(cell.getText());
            log.info(cell.getText());
        }
    }

    @Test
    /** Verify
     * row= 2 ; cell =4; verify value is = "$51.00"
     */
    public void find_Certain_Value_With_Row_And_Column_Coordinates() {

        driver.get(homePage);
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        List<WebElement> allCellsInRow2 = allRows.get(1).findElements(By.tagName("td"));
        WebElement row2cell4 = allCellsInRow2.get(3);
        Assert.assertEquals(row2cell4.getText(), "$51.00");
    }


    @Test
    public void find_Certain_Value_with_Row_And_Column_Coordinates_direct_in_HTML() {
        driver.get(homePage);
        // Find cell at row 2 column 4
        WebElement row2column4 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td[4]"));
        Assert.assertEquals(row2column4.getText(), "$51.00");
    }

    @Test
    public void find_All_Values_In_Certain_Column_direct_In_HTML() {
        driver.get(homePage);
        //FInd all cells of Column 2 in table
        List<WebElement> column2Values = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
        for (WebElement value : column2Values) {
            log.info(value.getText());
        }
    }

    @Test
    public void find_All_Cells_In_Table() {
        driver.get(homePage);
        //Get values of all cells in table
        List<WebElement> allCells = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td"));
        for (WebElement cell : allCells) {
            log.info(cell.getText());
        }
    }

}
