package com.test.saucedemo.tests;

import org.testng.annotations.DataProvider;

public class AllData {

    @DataProvider(name = "negativeLogin")
    public Object[][] getUserInfo() {
        return new Object[][]{
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"sdsd", "sdsds", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @DataProvider(name = "TestingProductLinks")
    public Object[][] getProductData(){
        return new Object[][]{

                {"Sauce Labs Backpack","Sly Pack","$29.99"},
                {"Sauce Labs Bike Light","lighting modes","$9.99"},
                {"Sauce Labs Bolt T-Shirt","ringspun combed cotton","$15.99"},
                {"Sauce Labs Fleece Jacket","fleece jacket","$49.99"},
                {"Sauce Labs Onesie","3-snap bottom closure","$7.99"},
                {"Test.allTheThings() T-Shirt (Red)","Super-soft and comfy","$15.99"}

        };
    }

}
