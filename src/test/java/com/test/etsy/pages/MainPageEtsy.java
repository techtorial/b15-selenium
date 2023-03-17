package com.test.etsy.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class MainPageEtsy {

    public MainPageEtsy(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#global-enhancements-search-query")
    WebElement searchBar;

    @FindBy(xpath = "//li//h3")
    List<WebElement> allHeaders;

    public void searchData(String searchWord) {
        searchBar.sendKeys(searchWord, Keys.ENTER);
    }

    public void validateHeaders(String brand, String model, String casePhone) {
        for (WebElement header : allHeaders) {
            String word=BrowserUtils.getText(header).toLowerCase();
            Assert.assertTrue(word.contains(brand) || word.contains(model) || word.contains(casePhone));
        }
    }

}
