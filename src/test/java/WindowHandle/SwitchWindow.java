package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {

    @Test
    public void switchPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        WebElement clickHere=driver.findElement(By.linkText("Click Here"));
        clickHere.click();
        String mainPageID=driver.getWindowHandle();//pageId of the class
        System.out.println(mainPageID);//CDwindow-5C5FF6A3B45F063F8D3494FE7BFE288C
        Set<String> allPagesId=driver.getWindowHandles();
        System.out.println(allPagesId);
        for(String id:allPagesId){
            //this is used for only 2 tabs/windows
            if(!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }
        WebElement header=driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
    }


    @Test
    public void practice1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement button2Window=driver.findElement(By.cssSelector("#newTabBtn"));
        button2Window.click();
        String mainPageId=driver.getWindowHandle();//mainpageiD
        Set<String> allPagesID=driver.getWindowHandles(); //will give me allPagesId
        for(String id:allPagesID){
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
            }
        }
        WebElement header=driver.findElement(By.xpath("//h1[contains(text(),'AlertsDemo')]"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="AlertsDemo";
        Assert.assertEquals(actualHeader,expectedHeader);
        String actualTitle=driver.getTitle();
        String expectedTitle="AlertsDemo - H Y R Tutorials";
        Assert.assertEquals(actualTitle,expectedTitle);
        WebElement clickMe=driver.findElement(By.cssSelector("#alertBox"));
        clickMe.click();
    }
}


