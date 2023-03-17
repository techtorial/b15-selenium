package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

    @DataProvider(name = "couples")
    public Object[][] getData(){
        return new Object[][]{
                {"Ahmet","Ayse","blue"},
                {"Mr.M","Mrs.M","brown"},
                {"Ivana","Mr.Darko","black"},
                {"Gulmira","Mr.V","blue"},
                {"Mr.B","Mrs.Juliana","black"}
        };
    }

    @Test(dataProvider = "couples")
    public void test1(String firstCouple,String secondCouple,String eyeColor){
        System.out.println(firstCouple + secondCouple+eyeColor);

    }

//    @Test
//    public void test2(){
//        System.out.println("Mr.M" + "Mrs.M");
//    }
//
//    @Test
//    public void test3(){
//        System.out.println("Ivana"+"Mr.Darko");
//    }
//
//    @Test
//    public void test4(){
//        System.out.println("Gulmira" + "Mr.V");
//    }
//
//    @Test
//    public void test5(){
//        System.out.println("Mr.B" + "Ms.Juliana");
//    }


}
