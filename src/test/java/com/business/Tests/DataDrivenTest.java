package com.business.Tests;

import com.business.Utilities.Base;
import com.business.Utilities.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class DataDrivenTest extends Base {


    // step 1   - Declare testData as List of Maps
    List<Map<String, String>> testData;

    //step 2  - Create object of ExcelUtil class
    @BeforeMethod
    public void getTestData() {
        ExcelUtil excelutil = new ExcelUtil("./src/test/resources/SalaryCalculator.xlsx", 0);
        testData = excelutil.getDataList();
    }


    @Test()

    public void singleData() {
        extentLogger=report.createTest("DataDrivenTest");
        // step 3
        try {
            for (Map<String, String> calcData : testData) {
                driver.get("https://www.calculator.net/salary-calculator.html");
                pages.salaryCalculator.clearAllFields();
                pages.salaryCalculator.salaryAmount.sendKeys(calcData.get("Amount"));
                Assert.assertEquals(pages.salaryCalculator.salaryAmount.getAttribute("value"), calcData.get("Amount"));
                Select select = new Select(pages.salaryCalculator.hourDropdown);
                select.selectByVisibleText(calcData.get("per"));
                pages.salaryCalculator.hoursPerWeek.sendKeys(calcData.get("perWeek"));
                Assert.assertEquals(pages.salaryCalculator.hoursPerWeek.getAttribute("value"), calcData.get("perWeek"));
                pages.salaryCalculator.daysPerWeek.sendKeys(calcData.get("daysPerWeek"));
                Assert.assertEquals(pages.salaryCalculator.daysPerWeek.getAttribute("value"), calcData.get("daysPerWeek"));
                pages.salaryCalculator.holidaysPerYear.sendKeys(calcData.get("holidays"));
                Assert.assertEquals(pages.salaryCalculator.holidaysPerYear.getAttribute("value"), calcData.get("holidays"));
                pages.salaryCalculator.vacationDays.sendKeys(calcData.get("vacations"));
                Assert.assertEquals(pages.salaryCalculator.vacationDays.getAttribute("value"), calcData.get("vacations"));
                WebElement tableCell = driver.findElement(By.xpath("//table[@class='cinfoT']/tbody/tr[9]/td[2]"));
                extentLogger.info("Verify the result");
                Assert.assertEquals(tableCell.getText(), calcData.get("Annual"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

