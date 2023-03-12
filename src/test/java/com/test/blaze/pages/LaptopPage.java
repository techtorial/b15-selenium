package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class LaptopPage {

    public LaptopPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".hrefch")
    List<WebElement> allLaptops;

    public void chooseLaptop(String brand) throws InterruptedException {
        Thread.sleep(2000);
        for(WebElement laptop:allLaptops){
            if(BrowserUtils.getText(laptop).contains(brand)){
                laptop.click();
                break;
            }
        }
    }
}
