package WaitTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class ExplicitlyWait {

    WebDriver driver;
    @Test
    public void validateTheText(){
        driver= DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement loading=driver.findElement(By.linkText("Dynamic Loading"));
        loading.click();
        WebElement example1=driver.findElement(By.partialLinkText("Example 1"));
        example1.click();
        WebElement button=driver.findElement(By.tagName("button"));
        button.click();
        WebElement text=driver.findElement(By.id("finish"));
       WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
        text=wait.until(ExpectedConditions.visibilityOf(text));
        Assert.assertEquals(BrowserUtils.getText(text),"Hello World!");
    }

    @Test
    public void validateText2(){
        driver= DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement control=driver.findElement(By.xpath("//a[.='Dynamic Controls']"));
        control.click();
        WebElement checkbox=driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox.click();
        WebElement removeButton=driver.findElement(By.xpath("//button[.='Remove']"));
        removeButton.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement message=driver.findElement(By.xpath("//p[@id='message']"));
        message=wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertEquals(BrowserUtils.getText(message),"It's gone!");
    }


}
