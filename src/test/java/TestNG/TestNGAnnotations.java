package TestNG;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeSuite //it will run before everything -->clear the cookies and caches
    public void beforeSuite(){
        System.out.println("I am beforeSuite Annotation");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("I am BeforeTest annotation");
    }

    @BeforeClass
    public void beforeClass(){//it runs before every class and people use to launch their browser driver=DriverHelper.getDriver()
        System.out.println("I am beforeClass annotation");
    }

    @BeforeMethod
    public void beforeMethod(){//it runs before every test annotation and it is good to use for setting up your automation
        //TESTBASE CLASS
        System.out.println("I am before Method annotation");
    }
    @Test
    public void test(){
        System.out.println("I am test annotation");
    }

    @Test //it executes the codes
    public void test1(){
        System.out.println("I am second test annotation");
    }

    @AfterMethod //it runs after every test annotation and it is good use for screenshot and quit your driver.
    public void afterMethod(){
        System.out.println("I am after method annotation");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("I am after class annotation");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("I am after Test annotation");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("I am after suite annotation");
    }

}
