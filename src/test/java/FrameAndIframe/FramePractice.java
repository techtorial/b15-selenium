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

public class FramePractice {
    /*
     1-Navigate To the website "https://the-internet.herokuapp.com/iframe"
     2-Validate the header "An iFrame containing the TinyMCE WYSIWYG Editor"
     3-Clear the message and send "I love Selenium"
     4-Click Elemental Selenium link
     5-Validate the header "Elemental Selenium"

     */
    @Test
    public void iframePractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        WebElement header=driver.findElement(By.tagName("h3"));
        String actualHeader= BrowserUtils.getText(header);
        String expectedHeader="An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actualHeader,expectedHeader);
        Thread.sleep(3000);
        driver.switchTo().frame("mce_0_ifr");
        WebElement box=driver.findElement(By.cssSelector("#tinymce"));
        box.clear();
        box.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        WebElement elementalSelenium=driver.findElement(By.linkText("Elemental Selenium"));
        elementalSelenium.click();
        BrowserUtils.switchByTitle(driver,"Using Selenium like a Pro");
        WebElement seleniumHeader=driver.findElement(By.xpath("//h1"));
        String actualSeleniumHeader=BrowserUtils.getText(seleniumHeader);
        String expectedSeleniumHeader="Elemental Selenium";
        Assert.assertEquals(actualSeleniumHeader,expectedSeleniumHeader);





    }
}
