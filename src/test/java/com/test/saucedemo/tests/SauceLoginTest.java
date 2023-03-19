package com.test.saucedemo.tests;

import com.test.saucedemo.pages.SauceLoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class SauceLoginTest extends SauceTestBase {

//    @DataProvider(name = "negativeLogin")
//    public Object[][] getUserInfo() {
//        return new Object[][]{
//                {"standard_user", "", "Epic sadface: Password is required"},
//                {"", "secret_sauce", "Epic sadface: Username is required"},
//                {"sdsd", "sdsds", "Epic sadface: Username and password do not match any user in this service"}
//        };
//    }

    @Test
    public void validatePositiveLogin() {
        SauceLoginPage sauceLoginPage = new SauceLoginPage(driver);
        sauceLoginPage.loginPositive(ConfigReader.readProperty("QA_username"),
                ConfigReader.readProperty("QA_password"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test(dataProvider = "negativeLogin",dataProviderClass =AllData.class )
    public void validateNegativeLogin(String username, String password, String message) {
        SauceLoginPage sauceLoginPage = new SauceLoginPage(driver);
        sauceLoginPage.loginNegative(username, password, message);

    }



}
