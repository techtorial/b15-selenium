package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OpenChartTestNGPractice {
    //TASK1
    //1-Login successfully with "demo" username and "demo" password and validate title
    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
        Thread.sleep(2000);
        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void negativeLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demogdfgf");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demofdgdfg");
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
        Thread.sleep(3000);
        WebElement message=driver.findElement(By.xpath("//div[@id='alert']"));
        String actualMessage=message.getText().trim();
        String expectedMessage="No match for Username and/or Password.";
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void validateProductButton() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
        Thread.sleep(3000);
        WebElement xButton=driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();
        WebElement catalogButton=driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        Thread.sleep(2000);
        WebElement productsButton=driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(productsButton.isDisplayed());
    }

    @Test
    public void validateBoxesFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
        Thread.sleep(3000);
        WebElement xButton=driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();
        WebElement catalogButton=driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        Thread.sleep(2000);
        WebElement productsButton=driver.findElement(By.xpath("//a[.='Products']"));
        productsButton.click();
        List<WebElement> allBoxes=driver.findElements(By.xpath("//input[@type='checkbox']"));

         for(int i=1;i<allBoxes.size();i++){
             Thread.sleep(1000);
             Assert.assertTrue(allBoxes.get(i).isDisplayed());
             Assert.assertTrue(allBoxes.get(i).isEnabled());
             Assert.assertFalse(allBoxes.get(i).isSelected()); //box is not selected so it will return false
             allBoxes.get(i).click();
             Assert.assertTrue(allBoxes.get(i).isSelected());//true
             allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
         }
    }

    @Test
    public void validateProductNameFunctionalityDescending() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
        Thread.sleep(3000);
        WebElement xButton=driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();
        WebElement catalogButton=driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        Thread.sleep(2000);
        WebElement productsButton=driver.findElement(By.xpath("//a[.='Products']"));
        productsButton.click();
        WebElement productNameButton=driver.findElement(By.cssSelector(".asc"));
        productNameButton.click();
        Thread.sleep(2000);
        List<WebElement> productNames=driver.findElements(By.xpath("//td[@class='text-start']"));//11elements

        List<String> actualNames=new ArrayList<>();
        List<String> expectedNames=new ArrayList<>();

        for(int i=1;i<productNames.size();i++){//10 elements
            actualNames.add(productNames.get(i).getText().toLowerCase().trim()); //mostly for comparison like asc, desc (to upper or lower)
            expectedNames.add(productNames.get(i).getText().toLowerCase().trim());
        }
        Collections.sort(expectedNames);//sorting for ascending
        Collections.reverse(expectedNames);//making quarantee it is descending order
        System.out.println(expectedNames);
        System.out.println(actualNames);
        Assert.assertEquals(actualNames,expectedNames);

    }

    @Test
    public void validateProductNameFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
        Thread.sleep(3000);
        WebElement xButton=driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();
        WebElement catalogButton=driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalogButton.click();
        Thread.sleep(2000);
        WebElement productsButton=driver.findElement(By.xpath("//a[.='Products']"));
        productsButton.click();
        List<WebElement> allNames=driver.findElements(By.xpath("//td[@class='text-start']"));

        List<String> actualNames=new ArrayList<>();
        List<String> expectedNames=new ArrayList<>();

        for(int i=1;i<allNames.size();i++){
            actualNames.add(allNames.get(i).getText().toLowerCase().trim()); //10 elements  same order
            expectedNames.add(allNames.get(i).getText().toLowerCase().trim());//10 elements same order
        }
        Collections.sort(expectedNames);
        Assert.assertEquals(actualNames,expectedNames);

    }







}
