package FrameAndIframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class NestedFrame {

    @Test
    public void NestedFramePractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(3000);
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
        WebElement topFrame=driver.findElement(By.name("frame-top"));
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame("frame-left");
        WebElement left=driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        String actualText= BrowserUtils.getText(left);
        String expectedText="LEFT";
        Assert.assertEquals(actualText,expectedText);
        driver.switchTo().parentFrame();//1 above the  //TOP FRAME
        driver.switchTo().frame("frame-middle");  //MIDDLE FRAME
        WebElement middle=driver.findElement(By.cssSelector("#content"));
        String actualMiddleText=BrowserUtils.getText(middle);
        String expectedMiddleText="MIDDLE";
        Assert.assertEquals(actualMiddleText,expectedMiddleText);
        driver.switchTo().parentFrame(); //TOP FRAME
        driver.switchTo().frame("frame-right"); //RIGHT FRAME
        WebElement right=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        String actualRightText=BrowserUtils.getText(right);
        String expectedRightText="RIGHT";
        Assert.assertEquals(actualRightText,expectedRightText);
//        driver.switchTo().parentFrame();//TOP FRAME
//        driver.switchTo().parentFrame();//MAIN HTML
        driver.switchTo().defaultContent(); //directly to the main html
        driver.switchTo().frame("frame-bottom");//BOTTOm
        WebElement bottom=driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        String actualBottomText=BrowserUtils.getText(bottom);
        String exepcetedBottomText="BOTTOM";
        Assert.assertEquals(actualBottomText,exepcetedBottomText);

    }
}
