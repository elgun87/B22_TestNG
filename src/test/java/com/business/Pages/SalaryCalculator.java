package com.business.Pages;

import com.business.Utilities.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalaryCalculator {


    public SalaryCalculator() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(id = "camount")
    public WebElement salaryAmount;
    @FindBy(xpath = "//select[@name='cunit']")
    public WebElement hourDropdown;
    @FindBy(id = "chours")
    public WebElement hoursPerWeek;
    @FindBy(id = "cdays")
    public WebElement daysPerWeek;
    @FindBy(id = "cdays")
    public WebElement holidaysPerYear;
    @FindBy(id = "cvacation")
    public WebElement vacationDays;
    @FindBy(xpath = "//input[@value='Calculate']")
    public WebElement calculateBtn;


    public void clearAllFields() {
        salaryAmount.clear();
        hoursPerWeek.clear();
        daysPerWeek.clear();
        holidaysPerYear.clear();
        vacationDays.clear();
    }
}
