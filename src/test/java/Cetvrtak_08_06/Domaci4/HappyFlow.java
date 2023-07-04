package Cetvrtak_08_06.Domaci4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//Domaci Zadatak 1:
//Otici na sajt Herkouapp(https://the-internet.herokuapp.com/) i napisati sto vise test case-eva za log-in fun
//kciju (Basic Auth).

public class HappyFlow {
    public static void main(String[] args) {

        WebDriverManager.chromedriver ().setup ();
        WebDriver driver = new ChromeDriver ();

        driver.manage ().window ().maximize ();

        driver.get ("https://the-internet.herokuapp.com/");

        String validUserName = "admin";
        String validPassword = "admin";

        WebElement basicAuthLink = driver.findElement (By.linkText ("Basic Auth"));
        basicAuthLink.click ();

        String urlForLogIn = "the-internet.herokuapp.com/basic_auth";

        driver.get ("https://" + validUserName + ":" + validPassword + "@" + urlForLogIn);

        WebElement message = driver.findElement (By.xpath ("//*[@id=\"content\"]/div/p"));
        Assert.assertEquals (message.getText (), "Congratulations! You must have the proper credentials.");

        String urlWhenLogedIn = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
        Assert.assertEquals (driver.getCurrentUrl (), urlWhenLogedIn);


    }
}
