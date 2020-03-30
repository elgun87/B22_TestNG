package com.business.Tests;

import com.business.Utilities.Base;
import com.business.Utilities.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest extends Base {


    // step 1   - Declare testData as List of Maps


    //step 2  - Create object of ExcelUtil class and initialize List to the method from Util class
    @DataProvider(name = "SalaryDetails")
    public Object[] getTestData() {
        ExcelUtil excelutil = new ExcelUtil("./src/test/resources/SalaryCalculator.xlsx", "salary");
        Object[][] testData = excelutil.getDataArray();
        return testData;
    }


    // step 3  Iterate and feet the fields
    @Test(dataProvider = "SalaryDetails")
    public void singleData(String amount, String hoursPerWeek, String daysPerWeek, String holidaysPerYear, String vacationsPerYear,
                           String annual) {

        driver.get("https://www.calculator.net/salary-calculator.html");
        pages.salaryCalculator.clearAllFields();
        pages.salaryCalculator.salaryAmount.sendKeys(amount);
        pages.salaryCalculator.hoursPerWeek.sendKeys(hoursPerWeek);
        pages.salaryCalculator.daysPerWeek.sendKeys(daysPerWeek);
        pages.salaryCalculator.holidaysPerYear.sendKeys(holidaysPerYear);
        pages.salaryCalculator.vacationDays.sendKeys(vacationsPerYear);
        pages.salaryCalculator.calculateBtn.click();
        WebElement tableCell = driver.findElement(By.xpath("//table[@class='cinfoT']//tr[9]//td[2]"));
        Assert.assertEquals(tableCell.getText(), annual);
    }
}





