package Cetvrtak_08_06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Zadatak8 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver ().setup ();
        WebDriver driver = new ChromeDriver ();

        driver.manage ().window ().maximize ();

        driver.get ("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");

        Cookie cookie4 = new Cookie ("session-id", "138-3268257-5868109");

        WebElement cartBeforeAdding = driver.findElement (By.id ("nav-cart-count"));
        Assert.assertEquals (cartBeforeAdding.getText (), "0");


        WebElement addToCartButton = driver.findElement (By.id ("add-to-cart-button"));
        addToCartButton.click ();

        WebElement cartAfterAdding = driver.findElement (By.id ("nav-cart-count"));
        Assert.assertEquals (cartAfterAdding.getText (), "1");

        //driver.manage ().deleteCookie (cookie4);
        driver.manage ().deleteCookieNamed ("session-id");
        driver.navigate ().refresh ();

        Thread.sleep (2000);
        WebElement cart = driver.findElement (By.id ("nav-cart-count-container"));
        cart.click ();

        WebElement message = driver.findElement (By.cssSelector (".a-row.sc-your-amazon-cart-is-empty"));
        Assert.assertTrue (message.isDisplayed ());

        Assert.assertEquals (message.getText (), "Your Amazon Cart is empty");

        WebElement cartNumber = driver.findElement (By.id ("nav-cart-count"));
        Assert.assertEquals (cartNumber.getText (), "0");


    }
}
