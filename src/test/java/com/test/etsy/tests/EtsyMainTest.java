package com.test.etsy.tests;

import com.test.etsy.pages.MainPageEtsy;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EtsyMainTest extends TestBaseEtsy {

    /*
    1-Navigate to the website from ConfigReader --> provide value in configuration.properties
    2-Search for "iphone 13 case"
    3-Make sure all of the headers contains iphone or 13 or Case
    4-Activate after method driver.quit
     */
    @Parameters({"searchWord","brand","model","casePhone"})
    @Test
    public void validateSearchFunctionality(String searchWord,String brand,String model,String casePhone){
        MainPageEtsy mainPageEtsy=new MainPageEtsy(driver);
        mainPageEtsy.searchData(searchWord);
        mainPageEtsy.validateHeaders(brand,model,casePhone);
    }


}
