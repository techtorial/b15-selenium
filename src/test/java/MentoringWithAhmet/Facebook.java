package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Facebook {

    @Test
    public void creatingFacebookAccount() throws InterruptedException {

        /*
        1-Navigate to the website "https://www.facebook.com/"
        2-Click Create New Account Button
        3-Fill all the boxes
        4-Choose Custom Gender
        5-Choose any pronoun you want from
        6-Click Sign up button
        7-In general facebook has a protection to automate create account  so once you
        click sign up button if there is a message then validate it. If no, just close or quit

           PURPOSE:
               1-This task can come during the interview
               2-How to deal with dynamic elements(real -- > > > > interview question)

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.facebook.com/");
        WebElement createNewAccountButton=driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        createNewAccountButton.click();
        WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Ahmet");
        WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Baldir123");
        WebElement email=driver.findElement(By.xpath("//input[@name='reg_email__']"));
        email.sendKeys("ahmet12354@gmail.com");
        WebElement confirm_email=driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        confirm_email.sendKeys("ahmet12354@gmail.com");
        WebElement password=driver.findElement(By.cssSelector("#password_step_input"));
        password.sendKeys("ahmet123");
        WebElement month=driver.findElement(By.cssSelector("#month"));
        month.sendKeys("May");
        WebElement day=driver.findElement(By.cssSelector("#day"));
        day.sendKeys("13");
        WebElement year=driver.findElement(By.cssSelector("#year"));
        year.sendKeys("1991");
        WebElement customButton=driver.findElement(By.xpath("//label[contains(text(),'Custom')]"));
        customButton.click();
        WebElement pronoun=driver.findElement(By.xpath("//select[@name='preferred_pronoun']"));
        pronoun.sendKeys("He: Wish him a happy birthday!");
        WebElement signUpButton=driver.findElement(By.xpath("//button[@name='websubmit']"));
        signUpButton.click();
        Thread.sleep(10000);
        WebElement message=driver.findElement(By.id("reg_error_inner"));
        String actualMessage=message.getText().trim();
        String expectedMessage="Please choose a more secure password. It should be longer than 6 characters, unique to you, and difficult for others to guess.";
        Assert.assertEquals(actualMessage,expectedMessage);
        }
}
