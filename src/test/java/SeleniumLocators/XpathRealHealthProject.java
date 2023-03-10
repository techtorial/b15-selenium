package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathRealHealthProject {

          /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->DONE
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.

           */

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement makeAppointmentButton = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeAppointmentButton.click();

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("John Doe");

        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='btn-login']"));
        loginButton.click();

        WebElement facility = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys("Hongkong CURA Healthcare Center");

        WebElement applyButton = driver.findElement(By.xpath("//input[@name='hospital_readmission']"));
        if (!applyButton.isSelected() && applyButton.isDisplayed() && applyButton.isEnabled()) {
            applyButton.click();
        }
        WebElement medicaid = driver.findElement(By.xpath("//input[@value='Medicaid']"));
        medicaid.click();

        WebElement date = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        date.sendKeys("05/02/2023");

        WebElement comment = driver.findElement(By.xpath("//textarea"));
        comment.sendKeys("Hello");

        WebElement bookAppointmentButton = driver.findElement(By.xpath("//button[contains(text(),'Book Appointment')]"));
        bookAppointmentButton.click();

        WebElement confirmationHeader = driver.findElement(By.xpath("//h2[.='Appointment Confirmation']"));
        String actualHeader = confirmationHeader.getText().trim();
        String expectedHeader = "Appointment Confirmation";
        System.out.println(actualHeader.equals(expectedHeader) ? "Passed" : "Failed");
         //CTRL + ALT + L
         //COMMAND+OPTION + L

        WebElement mainPageButton=driver.findElement(By.xpath("//a[contains(text(),'Go to Homepage')]"));
        mainPageButton.click();
        System.out.println(driver.getCurrentUrl().trim());
        Thread.sleep(3000);

        driver.close();
    }
}
