package com.cyber.pages;


import com.cyber.utilities.Driver;
import com.cyber.utilities.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.cyber.utilities.Driver.getDriver;


public class Login_Page {
WebDriverWait wait;
    public Login_Page() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(name = "_username")
    public WebElement userNameLocator;

    @FindBy(name = "_password")
    public WebElement passwordLocator;

    @FindBy(id = "_submit")
    public WebElement loginButtonLocator;

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[1]")
    public WebElement userFullNameLocator;


    public void logIn(String userName, String password) {
this.userNameLocator.sendKeys(userName);
this.passwordLocator.sendKeys(password);
wait=new WebDriverWait(Driver.getDriver(),10);
    wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
loginButtonLocator.click();
        SeleniumUtils.waitForPageToLoad(10);


    }


}
