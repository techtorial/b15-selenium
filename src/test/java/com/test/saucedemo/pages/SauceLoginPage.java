package com.test.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLoginPage {

    public SauceLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#user-name")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(tagName = "h3")
    WebElement message;



}
