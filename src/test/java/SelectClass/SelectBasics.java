package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectBasics {

    //SELECT CLASS IS ALL ABOUT DROP DOWN
    //Drop box must HAVE SELECT TAG NAME
    @Test
    public void practiceSelect() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement dropDown=driver.findElement(By.linkText("Dropdown"));//a tag and text
        dropDown.click();

        //location of the box
        WebElement optionBox=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select options=new Select(optionBox);//provide location of the box inside of Select Object
        System.out.println(options.getFirstSelectedOption().getText().trim());
        options.selectByValue("1"); //value
        Thread.sleep(3000);
        options.selectByVisibleText("Option 2"); //visible text
        Thread.sleep(3000);
        options.selectByIndex(1);
        Thread.sleep(3000);
        List<WebElement> allTheOptions=options.getOptions();
        List<String> expectedOptions= Arrays.asList("Please select an option","Option 1","Option 2");
        for(int i=0;i<allTheOptions.size();i++){
            Assert.assertEquals(allTheOptions.get(i).getText().trim(),expectedOptions.get(i));
        }

    }
}
