package com.business.Pages;

import com.business.Utilities.DriverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    /**
     * All page object classes must have the special constructor which inside that constructor using Pagefactory
     * we will  pass the driver object.
     *
     * @FindBy annotation comes form testNg used for store located element.
     * If there is some common actions which are repeated lots of time, then in page class we can create a method
     * for the repeated actions (for example: login);
     */

    public HomePage() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement username;
    @FindBy(id = "ctl00_MainContent_password")
    public WebElement passWord;
    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement submitBtn;

    public void login(String login, String pass) {
        this.username.sendKeys(login);
        this.passWord.sendKeys(pass);
        this.submitBtn.click();
    }


}
