package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DreamCar {
    /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
     */
    @Test
    public void validateHeadersOfTheCar() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.cars.com/");
        WebElement newUsed=driver.findElement(By.cssSelector("#make-model-search-stocktype"));
        BrowserUtils.selectBy(newUsed,"New","text");
        WebElement make=driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(make,"lexus","value");
        WebElement model=driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(model,"lexus-rx_350","value");
        WebElement priceBox=driver.findElement(By.cssSelector("#make-model-max-price"));
        Select price=new Select(priceBox);
        String actualPrice=BrowserUtils.getText(price.getFirstSelectedOption());
        String expectedPrice="No max price";
        Assert.assertEquals(actualPrice,expectedPrice);
        WebElement distance=driver.findElement(By.cssSelector("#make-model-maximum-distance"));
        BrowserUtils.selectBy(distance,"3","index");
        WebElement zipCode=driver.findElement(By.cssSelector("#make-model-zip"));
        zipCode.clear();
        zipCode.sendKeys("60056");
        WebElement searchButton=driver.findElement(By.xpath("//button[@data-linkname='search-new-make']"));
        searchButton.click();
        WebElement header=driver.findElement(By.xpath("//h1[contains(text(),'New Lexus RX 350 for sale')]"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="New Lexus RX 350 for sale";
        Assert.assertEquals(actualHeader,expectedHeader);
        Thread.sleep(2000);
        WebElement sorted=driver.findElement(By.cssSelector("#sort-dropdown"));
        BrowserUtils.selectBy(sorted,"Lowest price","text");
         Thread.sleep(2000);
        List<WebElement> allHeaders=driver.findElements(By.xpath("//h2[@class='title']"));
        for(WebElement title:allHeaders){
            Assert.assertTrue(BrowserUtils.getText(title).contains("Lexus RX 350"));
        }
//
       List<String> numbers= Arrays.asList("1","2","11","5","21","35");
        List<Integer> numbers2=Arrays.asList(1,2,11,5,21,35);
       
        Collections.sort(numbers);
        System.out.println(numbers);
        Collections.sort(numbers2);
        System.out.println(numbers2);






    }
}
