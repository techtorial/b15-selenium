package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageBlaze {

       /*
    1-Navigate to the website "https://www.demoblaze.com/#"
    2-Click the Laptops from homepage(firstPage)
    3-Click MacBook Pro from the list with Loop(LaptopPage)
    4-Validate the header="MacBook Pro"(MacBook Pro Page)
    5-Validate the price=$1100 *includes tax(MacBook Pro Page)
    6-Validate the product Descr="Product description(MacBook Pro Page)
Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and
15-inch model with the Touch Bar, a thin, multi-touchstrip display that sits above the MacBook Pro's keyboard."
    7-Click the Add to card Button and validate the alert text="Product added" then click "OK" button(MacBook Pro Page)
     */
    public MainPageBlaze(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Laptops")
    WebElement laptopsButton;

    @FindBy(id = "cartur")
    WebElement cartButton;

    public void clickLaptopsButton(){
        laptopsButton.click();
    }

    public void clickCartButton(){
        cartButton.click();
    }










}
