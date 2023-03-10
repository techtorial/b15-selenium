package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathLocator {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement abTesting=driver.findElement(By.linkText("A/B Testing"));
        abTesting.click();
        WebElement paragraph=driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));
        System.out.println(paragraph.getText().trim());
        WebElement elementalSelenium=driver.findElement(By.xpath("//a[contains(text(),'Elemental Selenium')]"));
        System.out.println(elementalSelenium.getText().trim());
        Thread.sleep(3000);
        WebElement elementalSelenium2=driver.findElement(By.xpath("//a[.='Elemental Selenium']"));
        elementalSelenium2.click();

    }

}
