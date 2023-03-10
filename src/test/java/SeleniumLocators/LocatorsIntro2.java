package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro2 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();//optional
        driver.navigate().to("file:///Users/codefish/Downloads/Techtorial.html");

        //LINKTEXT LOCATOR
        WebElement javaLink=driver.findElement(By.linkText("Java"));//a tag with the text
        javaLink.click();
        WebElement header=driver.findElement(By.tagName("h1"));
        System.out.println(header.getText().trim().equals("Java") ? "Passed" : "Failed");
        Thread.sleep(2000);//to pause system for 2 sec then I can see what is going on
        driver.navigate().back();

        /*
        1-Click Selenium and validate(ternary) header -->Selenium automates browsers. That's it!
        2-Go back to the main page
        3-Click Cucumber and validate(ternary) header -->Tools & techniques that elevate teams to greatness
        4-Go back to the main page
        5-Click TestNG and validate(ternary) header -->TestNG
        6-Go back to the main page
        7-Validate(ternary) the url is "file:///Users/codefish/Downloads/Techtorial.html"
         */

        WebElement seleniumLink=driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        WebElement headerSelenium=driver.findElement(By.tagName("h1"));
        System.out.println(headerSelenium.getText().trim().equals("Selenium automates browsers. That's it!") ? "Passed" : "Failed");
        driver.navigate().back();
        WebElement cucumberLink=driver.findElement(By.linkText("Cucumber"));
        cucumberLink.click();
        WebElement headerCucumber=driver.findElement(By.className("font-light")); //go and find the header
        System.out.println(headerCucumber.getText().trim().equals("Tools & techniques that elevate teams to greatness") ? "Passed":"Failed");
        driver.navigate().back();
        String actualUrl=driver.getCurrentUrl().trim();
        String expectedUrl="file:///Users/codefish/Downloads/Techtorial.html";
        System.out.println(actualUrl.equals(expectedUrl) ? "Passed" : "Failed");

        //PARTIAL LINK TEXT LOCATOR: //must have a tag and text

        WebElement restApi=driver.findElement(By.partialLinkText("Rest"));
        //WebElement restApi2=driver.findElement(By.linktext("Rest-api");
        restApi.click();
        String actualUrlRestApi=driver.getCurrentUrl();
        String expectedUrlRestApi="https://rest-assured.io/";
        System.out.println(actualUrlRestApi.equals(expectedUrlRestApi) ? "Passed" :"Failed");
        driver.navigate().back();
        driver.close();





    }
}
