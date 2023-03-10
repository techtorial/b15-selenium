package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {

    public static void main(String[] args) {
        //driver.get() //driver.getTitle()
        System.setProperty("webdriver.chrome.driver","chromedriver");
        //windows user will add chromedriver.exe
        WebDriver driver=new ChromeDriver();//create an object
        driver.manage().window().maximize(); //maximize
        driver.get("https://www.amazon.com/"); //navigate to website
        System.out.println(driver.getTitle()); //get the title
        String actualTitle=driver.getTitle();
        String expectedTitle="Amazon.com. Spend less. Smile more.";
        if(actualTitle.equals(expectedTitle)){ //validation here
            System.out.println("Your test is passed");
        }else{
            System.out.println("Your test is failed");
        }
        //driver.getCurrentUrl()
        driver.get("https://www.techtorialacademy.com/");
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.techtorialacademy.com/";
        String actualTitleTechtorial=driver.getTitle();
        String expectedTitleTechtorial="Home";

        if(actualUrl.equals(expectedUrl)){
            System.out.println("Url is passed");
        }else{
            System.out.println("Url is failed");
        }

        if(actualTitleTechtorial.equals(expectedTitleTechtorial)){
            System.out.println("Title is passed");
        }else{
            System.out.println("Title is failed");
        }
        driver.close();

    }
}
