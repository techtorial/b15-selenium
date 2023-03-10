package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectPractice {

    @Test
    public void validateFirstOptionAndPrintAllOptions() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/codefish/Documents/SeleniumB15/src/test/resources/Techtorialhtml.html");//("file:///Users/codefish/Desktop/Techtorialhtml.html");
        WebElement countryBox=driver.findElement(By.xpath("//select[@name='country']"));
        Select country=new Select(countryBox);
        String actualFirstOption=country.getFirstSelectedOption().getText().trim();//UNITED STATES
        String expectedFirstOption="UNITED STATES";
        Assert.assertEquals(actualFirstOption,expectedFirstOption);
        List<WebElement> allTheCountryOptions=country.getOptions();
          int counter=0;
           for(WebElement countryName:allTheCountryOptions){
               System.out.println(countryName.getText().trim());
               counter++;
           }
        System.out.println(counter);
           country.selectByVisibleText("BAHAMAS ");
           Thread.sleep(3000);
           country.selectByValue("207");
           Thread.sleep(3000);
           country.selectByIndex(263);
    }

    @Test
    public void multiSelect() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/codefish/Documents/SeleniumB15/src/test/resources/Techtorialhtml.html");
        WebElement countryBox=driver.findElement(By.cssSelector(".select"));
        Select country=new Select(countryBox);
        country.selectByVisibleText("One");
        Thread.sleep(2000);
        country.selectByValue("3");
        Thread.sleep(2000);
        country.selectByIndex(4);
        Thread.sleep(2000);
       // country.deselectByVisibleText("One");
        country.deselectByValue("1");
        Thread.sleep(3000);
        country.deselectAll();
    }


    @Test
    public void validateOrderMessage(){
                 /*
1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneWayButton=driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();
        WebElement passengerBox=driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passenger=new Select(passengerBox);
        passenger.selectByIndex(3);//4 passanger
        WebElement departingBox=driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select depart=new Select(departingBox);
        String actualFirstOption=depart.getFirstSelectedOption().getText().trim();
        String expectedFirstOption="Acapulco";
        Assert.assertEquals(actualFirstOption,expectedFirstOption);
        depart.selectByVisibleText("Paris");
        WebElement fromMonthBox=driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select fromMonth=new Select(fromMonthBox);
        fromMonth.selectByValue("8");
        WebElement fromDayBox=driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select fromDay=new Select(fromDayBox);
        fromDay.selectByIndex(14);
        WebElement toPortBox=driver.findElement(By.xpath("//select[@name='toPort']"));
        Select toPort=new Select(toPortBox);
        toPort.selectByVisibleText("San Francisco");
        WebElement toMonthBox=driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select toMonth=new Select(toMonthBox);
        toMonth.selectByValue("12");
        WebElement toDayBox=driver.findElement(By.xpath("//select[@name='toDay']"));
        Select toDay=new Select(toDayBox);
        toDay.selectByIndex(14);
        WebElement serviceClass=driver.findElement(By.xpath("//input[@value='First']"));
        serviceClass.click();
        WebElement airlineCarrierBox=driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlineCarrier=new Select(airlineCarrierBox);
       List<WebElement> actualAllOptions= airlineCarrier.getOptions(); //4 options
        List<String> expectedAllOptions= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines",
                "Pangea Airlines");
        for(int i=0;i<actualAllOptions.size();i++){
            Assert.assertEquals(actualAllOptions.get(i).getText().trim(),expectedAllOptions.get(i));
        }
        airlineCarrier.selectByVisibleText("Unified Airlines");
        WebElement continueButton=driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();
        WebElement message=driver.findElement(By.xpath("//font[@size='4']"));
        String actualMessage=message.getText().trim();
        String expectedMessage="After flight finder - No Seats Available";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
    @Test
    public void shortCutSelectClass(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneWayButton=driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();
        WebElement passengerBox=driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passengerBox,"3","index");
        WebElement departingBox=driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select depart=new Select(departingBox);
        String actualFirstOption=depart.getFirstSelectedOption().getText().trim();
        String expectedFirstOption="Acapulco";
        Assert.assertEquals(actualFirstOption,expectedFirstOption);
        BrowserUtils.selectBy(departingBox,"Paris","text");
        WebElement fromMonthBox=driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(fromMonthBox,"8","value");
        WebElement fromDayBox=driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(fromDayBox,"14","index");
        WebElement toPortBox=driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowserUtils.selectBy(toPortBox,"San Francisco","text");
        WebElement toMonthBox=driver.findElement(By.xpath("//select[@name='toMonth']"));
        BrowserUtils.selectBy(toMonthBox,"12","value");
        WebElement toDayBox=driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowserUtils.selectBy(toDayBox,"15","index");
        WebElement serviceClass=driver.findElement(By.xpath("//input[@value='First']"));
        serviceClass.click();
        WebElement airlineCarrierBox=driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlineCarrier=new Select(airlineCarrierBox);
        List<WebElement> actualAllOptions= airlineCarrier.getOptions(); //4 options
        List<String> expectedAllOptions= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines",
                "Pangea Airlines");
        for(int i=0;i<actualAllOptions.size();i++){
            Assert.assertEquals(actualAllOptions.get(i).getText().trim(),expectedAllOptions.get(i));
        }
        airlineCarrier.selectByVisibleText("Unified Airlines");
        WebElement continueButton=driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();
        WebElement message=driver.findElement(By.xpath("//font[@size='4']"));
      //  String actualMessage=message.getText().trim();
        String actualMessage=BrowserUtils.getText(message);
        String expectedMessage="After flight finder - No Seats Available";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
}
