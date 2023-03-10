package AlertInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class Practice {


   @Test()
    public void practiceAlert(){
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");
       WebElement confirmButton=driver.findElement(By.cssSelector("#confirmBox"));
       confirmButton.click();
       Alert alert=driver.switchTo().alert();
       String actualMessage=alert.getText();//will give you the text from Pop-up
       String expectedMessage="Press a button!";
       Assert.assertEquals(actualMessage,expectedMessage);
       alert.dismiss();//it clicks cancel button
       WebElement resultMessage=driver.findElement(By.cssSelector("#output"));
       String actualResultMessage= BrowserUtils.getText(resultMessage);
       String expectedResultMessage="You pressed Cancel in confirmation popup";
       Assert.assertEquals(actualResultMessage,expectedResultMessage);
       WebElement promptBox=driver.findElement(By.cssSelector("#promptBox"));
       promptBox.click();
       alert.sendKeys("Ahmet");
       alert.accept();
      resultMessage=driver.findElement(By.cssSelector("#output"));
      String actualResultMessagePrompt= BrowserUtils.getText(resultMessage);
      String expectedResultMessagePrompt="You entered text Ahmet in propmt popup";
      Assert.assertEquals(actualResultMessagePrompt,expectedResultMessagePrompt);


   }
}
