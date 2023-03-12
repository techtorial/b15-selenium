package TestNG;

import org.testng.annotations.Test;
import utils.DriverHelper;

public class TestNGIntro {

  @Test(priority =2 ) //test annotation -->
  public void test1(){
    System.out.println("I am test1");
  }

  @Test(priority = 1,invocationCount = 20)
  public void test2(){
    System.out.println("I am test2");
  }

  @Test(priority = 3)
  public void test3(){
    System.out.println("I am test3");
  }
}
