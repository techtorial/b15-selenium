package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.swing.*;
import java.time.Duration;

public class SpruceInterviewQuestion {

    @Test
    public void validateFishProduct() throws InterruptedException {

        /*
        1-Navigate to the website "https://www.thespruceeats.com/"
        2-Under Ingredients tab --> choose Fish&SeaFood option
        3-ScrollDown to the search bar (Use JS Method)
        4-Send the data: "Fish for dinner"
        5-On the left side choose 4 star up option
        6-From popular: Choose the Editor's choice option
        7-Validate the name of product is "6-Ingredient Roasted Salmon Fillets"
        8-Quit or close your driver

        PURPOSE: *Apply Action class method
                 *Apply How to find the unique element for real website
                 *Apply JS scroll Method
                 *Apply TestNG Assertion(validation)
                 *Getting used to UI real interview question types
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.thespruceeats.com/");
        WebElement ingredient=driver.findElement(By.xpath("//span[.='Ingredients']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(ingredient).perform();
        WebElement fishAndSeaFood=driver.findElement(By.xpath("//a[contains(text(),'Fish & Seafood')]"));
        actions.click(fishAndSeaFood).perform();
        Thread.sleep(3000);
        WebElement searchBar=driver.findElement(By.cssSelector("#search-form-input"));
        Thread.sleep(3000);
        BrowserUtils.scrollWithJS(driver,searchBar);
        Thread.sleep(3000);
        searchBar.sendKeys("Fish for dinner", Keys.ENTER);
        WebElement fourStar=driver.findElement(By.xpath("//label[@for='starRating_score_4Star']"));
        fourStar.click();
        WebElement editorsChoice=driver.findElement(By.xpath("//label[@for='pop_search_editor']"));
        editorsChoice.click();
        Thread.sleep(3000);
        WebElement nameOfProduct=driver.findElement(By.xpath("//span[contains(text(),'Salmon Fillets')]"));
        Assert.assertEquals(BrowserUtils.getText(nameOfProduct),"6-Ingredient Roasted Salmon Fillets");
        Thread.sleep(5000);

        driver.quit();


    }
}
