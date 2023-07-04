package Petak_09_06;

import org.testng.annotations.*;

public class Selenium9 {

    //Before class se izvrsava samo jednom na pocetku
    @BeforeClass
    public void beforeClass() {
        System.out.println("************");
        System.out.println("Ispis iz before class");
        System.out.println("************");
    }

    //Before method se izvrsava pre svake test metode
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("============");
        System.out.println("Ispis iz before method");
        System.out.println("============");
    }

    @Test (priority = 10)
    public void test1() {
        System.out.println("+++++++++++++");
        System.out.println("Ovo je 1. test");
        System.out.println("+++++++++++++");
    }

    @Test (priority = 20)
    public void test2() {
        System.out.println("+++++++++++++");
        System.out.println("Ovo je 2. test");
        System.out.println("+++++++++++++");
    }

    @Test (priority = 30)
    public void test3() {
        System.out.println("+++++++++++++");
        System.out.println("Ovo je 3. test");
        System.out.println("+++++++++++++");
    }

    @Test (priority = 25)
    public void test4() {
        System.out.println("Test koji se izvrsava nakon drugog, a pre treceg testa");
    }

    //After method se izvrsava posle svake test metode
    @AfterMethod
    public void afterMethod() {
        System.out.println("-------------------");
        System.out.println("Ispis iz after method");
        System.out.println("-------------------");
    }

    //After class se izvrsava samo jednom na kraju
    @AfterClass
    public void afterClass() {
        System.out.println("````````````");
        System.out.println("Ispis iz after class");
        System.out.println("````````````");
    }


}
