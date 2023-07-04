package Ponedeljak_05_06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver ().setup ();
        WebDriver driver = new ChromeDriver ();
        driver.manage ().window ().maximize ();

        driver.get ("https://practicetestautomation.com/");

        WebElement practice = driver.findElement (By.id ("menu-item-20"));
        practice.click ();

        WebElement logInPage = driver.findElement (By.linkText ("Test Login Page"));
        Thread.sleep (2000);
        logInPage.click ();

        String validUsername = "stident";
        WebElement usernameField = driver.findElement (By.id ("username"));
        usernameField.sendKeys (validUsername);

        String validPassword = "Password123";
        WebElement passwordField = driver.findElement (By.id ("password"));
        passwordField.sendKeys(validPassword);

        WebElement submitButton = driver.findElement (By.id ("submit"));
        submitButton.click ();

        WebElement logOut = driver.findElement (By.cssSelector (".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color"));
        Assert.assertTrue (logOut.isDisplayed ());

        WebElement header = driver.findElement (By.className ("post-header"));
        Assert.assertTrue (header.isDisplayed ());

        Assert.assertEquals (header.getText (), "Logged In Successfully");

        WebElement poruka = driver.findElement (By.className ("has-text-align-center"));

        Assert.assertTrue (poruka.isDisplayed ());
        Assert.assertEquals (poruka.getText (), "Congratulations student. You successfully logged in!");

        logOut.click ();

        Assert.assertEquals (driver.getCurrentUrl (), "https://practicetestautomation.com/practice-test-login/");


    }
}
