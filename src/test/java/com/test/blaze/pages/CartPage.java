package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class CartPage {

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(tagName = "td") //4
    List<WebElement> allInformation;

    public void validateProductInformation(String title,String price){
        List<String> expectedInformation= Arrays.asList("",title,price,"");
        for(int i=1;i<allInformation.size()-1;i++){
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedInformation.get(i));
        }
    }

    //picture,title,price,delete  -->4
    //"",title,price,"" -->4

}
