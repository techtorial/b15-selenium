package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GetAttribute {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement makeAppointmentButton = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeAppointmentButton.click();

        WebElement demoUsername=driver.findElement(By.xpath("//input[@aria-describedby='demo_username_label']"));
        System.out.println(demoUsername.getText().trim());//John Doe //this will not work
        System.out.println(demoUsername.getAttribute("value"));
        System.out.println(demoUsername.getAttribute("placeholder"));

    }
}
