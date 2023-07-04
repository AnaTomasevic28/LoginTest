package Petak_09_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Zadatak9 {
        WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver =  new ChromeDriver ();

        driver.manage ().window ().maximize ();

        driver.get("https://practicetestautomation.com/");

        WebElement practiceButton = driver.findElement (By.id ("menu-item-20"));
        practiceButton.click ();

        WebElement testLoginPage = driver.findElement (By.linkText ("Test Login Page"));
        testLoginPage.click ();
    }

@Test
    public void test1() throws InterruptedException {

    String validUsername = "student";
    Thread.sleep (2000);
    WebElement userNameField = driver.findElement (By.id ("username"));
    userNameField.sendKeys (validUsername);

    String validPassword = "Password123";
    WebElement passwordField = driver.findElement (By.id ("password"));
    passwordField.sendKeys (validPassword);

    WebElement submitButton = driver.findElement (By.id ("submit"));
    submitButton.click ();

    WebElement message = driver.findElement (By.className ("post-title"));
    Assert.assertEquals (message.getText (), "Logged In Successfully");

    WebElement logOutButton = driver.findElement (By.cssSelector (".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color"));
    Assert.assertTrue (logOutButton.isDisplayed ());

    }

    @Test
    public void test2(){
        WebElement submitButton = driver.findElement (By.id ("submit"));
        submitButton.click ();

        WebElement errorMessage = driver.findElement (By.id ("error"));
        Assert.assertTrue (errorMessage.isDisplayed ());

        Assert.assertEquals (errorMessage.getText (), "Your username is invalid!");

    }

    @Test
    public void test3() throws InterruptedException {

        String validUsername = "student";
        Thread.sleep (2000);
        WebElement userNameField = driver.findElement (By.id ("username"));
        userNameField.sendKeys (validUsername);

        WebElement submitButton = driver.findElement (By.id ("submit"));
        submitButton.click ();

        Thread.sleep (2000);
        WebElement errorMessage = driver.findElement (By.id ("error"));
        Assert.assertTrue (errorMessage.isDisplayed ());

        Assert.assertEquals (errorMessage.getText (), "Your password is invalid!");

    }

    @Test
    public void test4() throws InterruptedException {
        String validPassword = "Password123";
        WebElement passwordField = driver.findElement (By.id ("password"));
        passwordField.sendKeys (validPassword);

        WebElement submitButton = driver.findElement (By.id ("submit"));
        submitButton.click ();

        Thread.sleep (2000);
        WebElement errorMessage = driver.findElement (By.id ("error"));
        Assert.assertTrue (errorMessage.isDisplayed ());

        Assert.assertEquals (errorMessage.getText (), "Your username is invalid!");
    }

    @Test
    public  void test5() throws InterruptedException {
        String validUsername = "student";
        Thread.sleep (2000);
        WebElement userNameField = driver.findElement (By.id ("username"));
        userNameField.sendKeys (validUsername);

        WebElement passwordField = driver.findElement (By.id ("password"));
        passwordField.sendKeys ("Password");

        WebElement submitButton = driver.findElement (By.id ("submit"));
        submitButton.click ();

        Thread.sleep (2000);
        WebElement errorMessage = driver.findElement (By.id ("error"));
        Assert.assertTrue (errorMessage.isDisplayed ());

        Assert.assertEquals (errorMessage.getText (), "Your password is invalid!");
    }

    @Test
    public void test6() throws InterruptedException {
        Thread.sleep (2000);
        WebElement userNameField = driver.findElement (By.id ("username"));
        userNameField.sendKeys ("USERNAME");

        String validPassword = "Password123";
        WebElement passwordField = driver.findElement (By.id ("password"));
        passwordField.sendKeys (validPassword);

        WebElement submitButton = driver.findElement (By.id ("submit"));
        submitButton.click ();

        Thread.sleep (2000);
        WebElement errorMessage = driver.findElement (By.id ("error"));
        Assert.assertTrue (errorMessage.isDisplayed ());

        Assert.assertEquals (errorMessage.getText (), "Your username is invalid!");

    }

    @Test
    public void test7() throws InterruptedException {
        Thread.sleep (2000);
        WebElement userNameField = driver.findElement (By.id ("username"));
        userNameField.sendKeys ("USERNAME");

        WebElement passwordField = driver.findElement (By.id ("password"));
        passwordField.sendKeys ("Password");

        WebElement submitButton = driver.findElement (By.id ("submit"));
        submitButton.click ();

        Thread.sleep (2000);
        WebElement errorMessage = driver.findElement (By.id ("error"));
        Assert.assertTrue (errorMessage.isDisplayed ());

        Assert.assertEquals (errorMessage.getText (), "Your username is invalid!");

    }

@AfterMethod
    public void afterMethod(){

    driver.quit ();

    }

}
