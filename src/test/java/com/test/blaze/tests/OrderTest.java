package com.test.blaze.tests;

import com.test.blaze.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrderTest extends TestBaseBlaze{

    /*
    1-Navigate to the website "https://www.demoblaze.com/#"
    2-Click the Laptops from homepage(firstPage)
    3-Click MacBook Pro from the list with Loop(LaptopPage)
    4-Click Add to cart button
    5-Validate the text and click ok button(you already have method)
    6-Click Cart Button top(WebElement can be in MainPage)
    7-Validate the Name of Product and Price(no need test class for it just method)
    8-Click Place Order and provide all the information(ORDER PAGE)
    9-Validate the Thank you message and click OK
    10-Validate the url is "https://www.demoblaze.com/index.html"

     */
//    WebDriver driver;
//    @BeforeMethod
//    public void setup(){
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.demoblaze.com/#");
//    }

    @Test
    public void validateOrderFunctionality() throws InterruptedException {
        MainPageBlaze mainPageBlaze=new MainPageBlaze(driver);
        mainPageBlaze.clickLaptopsButton();
        LaptopPage laptopPage=new LaptopPage(driver);
        laptopPage.chooseLaptop("MacBook Pro");
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.clickAddToCardButton(driver,"Product added");
        mainPageBlaze.clickCartButton();
        CartPage cartPage=new CartPage(driver);
        cartPage.validateProductInformation("MacBook Pro","1100");
        OrderPage orderPage =new OrderPage(driver);
        orderPage.clickOrderButton();
        orderPage.ValidateOrderFunctionality("Ahmet","Turkia","Ankara",
                "24534534","12","2025",
                "Thank you for your purchase!");
        Assert.assertEquals(driver.getCurrentUrl().trim(),"https://www.demoblaze.com/index.html");
    }


}
