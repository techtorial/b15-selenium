package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class PracticeActions {

    @Test
    public void validateMessageAndColor(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement dragger=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropBox=driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(dragger,dropBox).perform();
        String actualMessage= BrowserUtils.getText(dropBox);
        String expectedMessage="Dropped!";
        Assert.assertEquals(actualMessage,expectedMessage);
        String actualColor=dropBox.getCssValue("background-color");
        String expectedColor="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor,expectedColor);
    }

    @Test
    public void validateNotAcceptableFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement acceptButton=driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        acceptButton.click();
        Thread.sleep(2000);
        WebElement notAcceptableDragger=driver.findElement(By.cssSelector("#notAcceptable"));
        String actualName=BrowserUtils.getText(notAcceptableDragger);
        String expectedName="Not Acceptable";//this will come from documentation
        Assert.assertEquals(actualName,expectedName);
        WebElement dropBox=driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));//parent-child
        String actualBoxName=BrowserUtils.getText(dropBox);
        String expectedBoxName="Drop here";
        Assert.assertEquals(actualBoxName,expectedBoxName);
        Actions actions=new Actions(driver);
        actions.clickAndHold(notAcceptableDragger).moveToElement(dropBox).release().perform();
        String actualBoxNameAfter=BrowserUtils.getText(dropBox);
        String expectedBoxNameAfter="Drop here";
        Assert.assertEquals(actualBoxNameAfter,expectedBoxNameAfter);
    }
}
