package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JPetStore {

    @Test
    public void validateCostMathFunctionality() throws InterruptedException {
        /*
        1-Navigate to the website "https://petstore.octoperf.com/actions/Catalog.action"
        2-Choose one category and put the product_id and name as a map format(Only one of the category) then print out
        3-Go to the main menu and choose 2 different category and choose one item from there
        4-Add them into the card
        5-Validate the total cost equals to the price at the bottom shows.
        6-Quit
         */
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
//        WebDriverManager.edgedriver().setup();
//        WebDriver driver=new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://petstore.octoperf.com/actions/Catalog.action");
        WebElement fish=driver.findElement(By.xpath("//area[@alt='Fish']"));
        fish.click();
        List<WebElement> allProductIds=driver.findElements(By.xpath("//td[1]"));
        List<WebElement> allNames=driver.findElements(By.xpath("//td[2]"));
        Map<String, String> listOfFishes=new HashMap<>();
        for(int i=0;i<allNames.size();i++){
            listOfFishes.put(BrowserUtils.getText(allProductIds.get(i)),BrowserUtils.getText(allNames.get(i)));
        }
        System.out.println(listOfFishes);
        Thread.sleep(3000);
        driver.navigate().back();
        WebElement dog=driver.findElement(By.xpath("//area[@alt='Dogs']"));
        dog.click();
        Thread.sleep(3000);
        WebElement dolmation=driver.findElement(By.xpath("//td[.='Dalmation']//preceding-sibling::td//a"));
        dolmation.click();
        Thread.sleep(3000);
        WebElement addToCard=driver.findElement(By.xpath("//td[contains(text(),'Spotless')]//..//td[5]//a"));
        addToCard.click();
        Thread.sleep(3000);
    }

}
