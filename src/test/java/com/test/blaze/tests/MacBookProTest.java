package com.test.blaze.tests;

import com.test.blaze.pages.LaptopPage;
import com.test.blaze.pages.MacBookProPage;
import com.test.blaze.pages.MainPageBlaze;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class MacBookProTest extends TestBaseBlaze {
//    WebDriver driver;
//    @BeforeMethod
//    public void setup(){
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//       driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.demoblaze.com/#");
//    }
@Parameters({"laptopBrand","laptopPrice","message","description"})
    @Test
    public void validateMacBookProductInfo(String laptopBrand,String laptopPrice,String message,String description) throws InterruptedException {
        MainPageBlaze mainPageBlaze=new MainPageBlaze(driver);
        mainPageBlaze.clickLaptopsButton();
        LaptopPage laptopPage=new LaptopPage(driver);
        laptopPage.chooseLaptop(laptopBrand);
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.validateProductInformation(laptopBrand,laptopPrice, description);
        macBookProPage.clickAddToCardButton(driver,message);
    }

//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }
}
