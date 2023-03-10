package AlertInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertIntro {

    @Test
    public void alertAcceptAndGetText() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement alertButton = driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        //button[contains(text(),'click for'
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        String actualJSAlertText = alert.getText().trim();//get the text from ALERT POP-UP //this is pop-up i cannot inspect
        String expectedJSAlertText = "I am a JS Alerts"; //so i cannot use getText from Browser utils
       // Assert.assertEquals(actualJSAlertText, expectedJSAlertText);
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertEquals(actualJSAlertText,expectedJSAlertText,"There is a comparison problem");
        Thread.sleep(3000);
        alert.accept();//it clicks OK button
        WebElement message = driver.findElement(By.cssSelector("#result"));
        String actualMessage = BrowserUtils.getText(message);//this is webelement, so i can use browser utils
        String expectedMessage = "You successfully clicked an alert";
        Assert.assertEquals(actualMessage, expectedMessage);
        softAssert.assertAll();
    }

    @Test
    public void AlertDismiss() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(3000);
        WebElement alertButton = driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement message = driver.findElement(By.cssSelector("#result"));
        String actualMessage = BrowserUtils.getText(message);//this is webelement, so i can use browser utils
        String expectedMessage = "You clicked: Cancels";
        //Assert.assertEquals(actualMessage, expectedMessage);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualMessage,expectedMessage);
        Thread.sleep(3000);
        softAssert.assertAll();
    }

    @Test
    public void sendKeys() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(3000);
        WebElement jsPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPrompt.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        alert.sendKeys("I love UI automation");
        Thread.sleep(3000);
        alert.accept();
        WebElement message = driver.findElement(By.cssSelector("#result"));
        String actualMessage = BrowserUtils.getText(message);//this is webelement, so i can use browser utils
        String expectedMessage = "You entered: I love UI automation";
        Assert.assertEquals(actualMessage, expectedMessage);
    }




}
