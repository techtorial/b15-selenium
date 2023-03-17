package com.test.bank.tests;

import com.test.bank.pages.LoginBankPage;
import com.test.bank.pages.ManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.time.Duration;

public class ManagerTest {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.readProperty("QA_url"));
    }

    @Test
    public void validateBankFunctionalityForManager() throws InterruptedException {

    /*
1-Navigate to the website https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
2-Click Bank Manager Login
3-Click Add Customer
4-Fill the blanks and click add customer button
5-Get the text from pop-up and VALIDATE account successuflly and click OK
6-Click Open Account
7-Choose your name from the list
8-Choose any currency you want from list
9-Get the text from pop-up and VALIDATE account successuflly created contains and click OK
10-Click Customers Button
11-Search your name on the searchBar
12-Validate your firstname,lastName,PostCode and click delete
13-driver.quit
14-Proud of yourself
 */
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        LoginBankPage loginBankPage=new LoginBankPage(driver);
        loginBankPage.clickManagerButton();
        ManagerPage managerPage=new ManagerPage(driver);
        managerPage.validateAddingCustomerFunctionality(driver,ConfigReader.readProperty("QA_firstName"),
                ConfigReader.readProperty("QA_lastName"),ConfigReader.readProperty("QA_postCode"),
                                                        "Customer added successfully");
        managerPage.validateOpenAccountFunctionality(driver,"Ahmet Baldir","Dollar",
                                                        "Account created successfully");
    //    managerPage.validateCustomerInformationAndDeleteFunctionality("Ahmet","Baldir","60123");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
