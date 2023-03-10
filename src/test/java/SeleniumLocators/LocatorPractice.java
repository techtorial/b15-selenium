package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorPractice {

    public static void main(String[] args) {
        //1-Setup automation
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
        //2-Automation process
        WebElement firstName=driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Ahmet");

        WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname]"));
        lastName.sendKeys("Baldir");

        WebElement email=driver.findElement(By.xpath("//input[@placeholder='E-Mail']"));
        email.sendKeys("ahmet12314234@gmail.com");

        WebElement phone=driver.findElement(By.xpath("//input[@type='tel']"));
        phone.sendKeys("123432423");

        WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("ahmet1234");

        WebElement passwordConfirm=driver.findElement(By.xpath("//input[@id='input-confirm']"));
        passwordConfirm.sendKeys("ahmet1234");

        WebElement privacyButton=driver.findElement(By.xpath("//input[@name='agree']"));
        privacyButton.click();

        WebElement continueButton=driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        WebElement header=driver.findElement(By.xpath("//h1[contains(text(),'Your Account')]"));
        String actualHeader=header.getText().trim();
        String expectedHeader="Your Account Has Been Created!";
        System.out.println(actualHeader.equals(expectedHeader) ? "PASSED" : "FAILED");

        driver.quit();





    }

}
