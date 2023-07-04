package Ponedeljak_05_06.Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LogIN4 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver ().setup ();
        WebDriver driver = new ChromeDriver ();
        driver.manage ().window ().maximize ();

        driver.get ("https://practicetestautomation.com/");

        WebElement practice = driver.findElement (By.id ("menu-item-20"));
        practice.click ();

        WebElement logInPage = driver.findElement (By.xpath ("/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a"));
        Thread.sleep (2000);
        logInPage.click ();

        WebElement usernameField = driver.findElement (By.id ("username"));
        usernameField.sendKeys ("Student");

        WebElement passwordField = driver.findElement (By.id ("password"));
        passwordField.sendKeys ("Password123");

        WebElement submitButton = driver.findElement (By.id ("submit"));
        submitButton.click ();

        WebElement errorMassage = driver. findElement (By.id ("error"));
        Assert.assertTrue (errorMassage.isDisplayed ());

        String error = "Your username is invalid!";
        Assert.assertEquals (errorMassage.getText (), error);

        Assert.assertEquals (driver.getCurrentUrl (), "https://practicetestautomation.com/practice-test-login/");


    }
}
