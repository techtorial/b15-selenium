package MentoringWithAhmet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class techlist {

    /*
1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox).
7-Select Automation tools you are familiar with (multiple checkboxes).
8-Select Continent(Send Keys).
9-Click on Submit button.
10-Close the webpage
Try your own logic and automate it without any help.
     */
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","chromedriver");
        //1-Step is : Setting up your automation
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //2-You need a driver to make a connection between page and intellij
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        //3-Navigate to the website
        WebElement firstName=driver.findElement(By.name("firstname"));
        firstName.sendKeys("Ahmet");
        WebElement lastName=driver.findElement(By.name("lastname"));
        lastName.sendKeys("Baldir");
        WebElement gender=driver.findElement(By.id("sex-0"));
        gender.click();
        WebElement experience=driver.findElement(By.id("exp-4"));
        experience.click();
        WebElement date=driver.findElement(By.id("datepicker"));
        date.sendKeys("08/13/2022");
        WebElement automation=driver.findElement(By.id("profession-1"));

        if(automation.isDisplayed() && !automation.isSelected()){
            automation.click();
        }

        WebElement tool=driver.findElement(By.id("tool-2"));
        tool.click();
        WebElement continent=driver.findElement(By.id("continents"));
        continent.sendKeys("North America");
        WebElement button=driver.findElement(By.className("btn-info"));
        button.click();


    }
}
