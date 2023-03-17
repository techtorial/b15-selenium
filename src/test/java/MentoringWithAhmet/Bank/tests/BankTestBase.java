package MentoringWithAhmet.Bank.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.DriverHelper;

public class BankTestBase {

    /*
TASK:

 1-Click Customer Login
 2-Find Harry Potter from the List
 3-Click Login
 4-Validate the "Welcome Your Harry Potter" from header
 5-Click Deposit and put 500
 6-Validate "Deposit Successful
 7-Click Withdrawl and put 300
 8-Validate "Transaction successful"
 9-Get the balance from the Customer Page(200)
 10-Click Transaction
 11-get the 500 and 300 from the table and substract them
 12-Validate balance from customer page amount(200) equals to transaction amount(500-300).
 12-Quit the driver
 */
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverHelper.getDriver();//singleton
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.getScreenShot(driver, "Bank");
        //  driver.quit();
    }
}
