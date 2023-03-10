package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {

    //ID LOCATOR
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/codefish/Documents/SeleniumB15/src/test/resources/Techtorialhtml.html");//("file:///Users/codefish/Desktop/Techtorialhtml.html");
        WebElement header=driver.findElement(By.id("techtorial1"));
        String actualHeader=header.getText().trim();//Techtorial Academy
        String expectedHeader="Techtorial Academy";
        System.out.println(actualHeader);
        System.out.println(actualHeader.equals(expectedHeader)?"Passed":"Failed");
        WebElement paragraph=driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText().trim());

        //NAME LOCATOR
        WebElement firstName=driver.findElement(By.name("firstName"));
        firstName.sendKeys("Ahmet");
        WebElement lastName=driver.findElement(By.name("lastName"));
        lastName.sendKeys("Baldir");
        WebElement phone=driver.findElement(By.name("phone"));
        phone.sendKeys("31123123");
        WebElement email=driver.findElement(By.id("userName"));
        email.sendKeys("ahmet@gmail.com");
        WebElement adress=driver.findElement(By.name("address1"));
        adress.sendKeys("423432 Midway");
        WebElement city=driver.findElement(By.name("city"));
        city.sendKeys("Chicago");
        WebElement state=driver.findElement(By.name("state"));
        state.sendKeys("IL");
        WebElement postalCode=driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("540540");
        Thread.sleep(3000);

        //CLASS LOCATOR:
        WebElement checkboxesLabel=driver.findElement(By.className("checkboxes"));
        System.out.println(checkboxesLabel.getText());
        WebElement javaBox=driver.findElement(By.id("cond1"));
        System.out.println(javaBox.isSelected()); //false
        if(javaBox.isDisplayed()&&!javaBox.isSelected()){
            javaBox.click();
        }
        System.out.println(javaBox.isSelected()); //true

        WebElement seleniumBox=driver.findElement(By.id("cond2"));
        System.out.println(seleniumBox.isSelected()); //true
        if(seleniumBox.isDisplayed() && !seleniumBox.isSelected()){
            seleniumBox.click();
        }
        System.out.println(seleniumBox.isSelected());//true
        System.out.println(seleniumBox.isDisplayed());

        WebElement testNG=driver.findElement(By.id("cond3"));
        if(testNG.isDisplayed() && !testNG.isSelected()){
            testNG.click();
        }

        //TAG NAME LOCATOR:

        WebElement version=driver.findElement(By.tagName("u"));
        String actualVersion=version.getText().trim();
        String expectedVersion="Use Java Version";
        if(actualVersion.equals(expectedVersion)){
            System.out.println("Validation is passed");
        }else{
            System.out.println("Validation is failed");
        }
    }
}
