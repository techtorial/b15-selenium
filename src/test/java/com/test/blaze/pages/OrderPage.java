package com.test.blaze.pages;

import com.test.blaze.tests.OrderTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class OrderPage {

    public OrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrderButton;

    @FindBy(css = "#name")
    WebElement name;

    @FindBy(xpath = "//input[@id='country']")
    WebElement country;

    @FindBy(xpath = "//input[@id='city']")
    WebElement city;

    @FindBy(xpath = "//input[@id='card']")
    WebElement creditCard;

    @FindBy(xpath = "//input[@id='month']")
    WebElement month;

    @FindBy(xpath = "//input[@id='year']")
    WebElement year;

    @FindBy(xpath = "//button[.='Purchase']")
    WebElement purchaseButton;

    @FindBy(xpath = "//h2[contains(text(),'Thank you')]")
    WebElement thankMessage;

    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;

    public void clickOrderButton() {
        placeOrderButton.click();
    }

    public void ValidateOrderFunctionality(String name, String country, String city, String creditCard, String month,
                                           String year, String expectedMessage) throws InterruptedException {

        this.name.sendKeys(name);
        Thread.sleep(1000);
        this.country.sendKeys(country);
        Thread.sleep(1000);
        this.city.sendKeys(city);
        Thread.sleep(1000);
        this.creditCard.sendKeys(creditCard);
        Thread.sleep(1000);
        this.month.sendKeys(month);
        Thread.sleep(1000);
        this.year.sendKeys(year);
        Thread.sleep(1000);
        purchaseButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(thankMessage), expectedMessage);
        Thread.sleep(1000);
        okButton.click();
    }
}
