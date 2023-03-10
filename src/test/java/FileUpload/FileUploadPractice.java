package FileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FileUploadPractice {

    @Test
    public void practice1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        WebElement chooseFileButton=driver.findElement(By.cssSelector("#file-upload"));
        chooseFileButton.sendKeys("/Users/codefish/Downloads/usa.png");
        WebElement fileUploadButton=driver.findElement(By.cssSelector("#file-submit"));
      // fileUploadButton.click();
        fileUploadButton.submit();
        WebElement attachment=driver.findElement(By.cssSelector("#uploaded-files"));
        String actualMessage= BrowserUtils.getText(attachment);
        String expectedMessage="usa.png";
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/upload/");
        WebElement chooseFile=driver.findElement(By.cssSelector(".upload_txt"));
        chooseFile.sendKeys("/Users/codefish/Downloads/usa.png");
        WebElement text=driver.findElement(By.xpath("//div[@id='uploadmode3']//following-sibling::span//b"));
        String actualText=BrowserUtils.getText(text);
        String expectedText="Select file to send(max 196.45 MB)";
        Assert.assertEquals(actualText,expectedText);
        WebElement box=driver.findElement(By.xpath("//a[.='terms of service']//preceding-sibling::input"));
        box.click();
        WebElement submitButton=driver.findElement(By.xpath("//button[@id='submitbutton']"));
        submitButton.click();
        Thread.sleep(2000);
        WebElement message=driver.findElement(By.tagName("h3"));
        String actualMessage=BrowserUtils.getText(message);
        String expectedMessage="1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
}
