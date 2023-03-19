package com.test.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class ProductPage {

    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".inventory_item_name")
    List<WebElement> allProducts;

    @FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
    WebElement description;

    @FindBy(xpath = "//div[@class='inventory_details_price']")
    WebElement price;

    public void chooseProduct(String productName,String expectedDescr,String expectedPrice){

        for(WebElement product:allProducts){
            if(BrowserUtils.getText(product).contains(productName)){
                product.click();
                break;
            }
        }
        Assert.assertTrue(BrowserUtils.getText(description).contains(expectedDescr));
        Assert.assertEquals(BrowserUtils.getText(price),expectedPrice);
    }
}
