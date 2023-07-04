package Utorak_06_06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Cookies {
    public static void main(String[] args) throws InterruptedException {

        //Dragoljub

        /*
         *         WebDriverManager.chromedriver().setup();
                   WebDriver driver = new ChromeDriver();
                   driver.manage().window().maximize();
                   driver.get("https://wordpress.com/");

                   Cookie loginCookie = new Cookie("wordpress_logged_in", "dragoljubqa%7C1780684786%7CdIxEK1ropfnFROP41VS57DQKrf9EYdEgb1N4MGUtSni%7Ca037608ee077d06e08e16029d3884cf658d11c4a44c3011f6a789d9510c64682");
                   driver.manage().addCookie(loginCookie);
                   driver.navigate().refresh();

         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://wordpress.com/");

        WebElement logInButton = driver.findElement(By.linkText("Log In"));
        logInButton.click();

        //Thread.sleep(5000);
        wdwait.until(ExpectedConditions.urlToBe("https://wordpress.com/log-in/"));
        WebElement usernameOrEmail = driver.findElement(By.id("usernameOrEmail"));
        String username = "anchi456";
        String email = "anamilenkovic15@gmail.com";

        usernameOrEmail.sendKeys(username);

        WebElement continueButton = driver.findElement(By.className("login__form-action"));
        continueButton.click();

        //Thread.sleep(5000);
        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("password"))));
        WebElement password = driver.findElement(By.id("password"));
        String validPassword = "pavledunja";
        password.sendKeys(validPassword);

        //WebElement loginButton = driver.findElement(By.className("login__form-action"));

        continueButton.click();

        //--------Ulogovani smo

        //Thread.sleep(5000);
        wdwait.until(ExpectedConditions.urlToBe("https://wordpress.com/read"));
        WebElement profileButton = driver.findElement(By.cssSelector(".gravatar.masterbar__item-me-gravatar"));
        Assert.assertTrue(profileButton.isDisplayed());

        profileButton.click();

        Thread.sleep(2000);

        //wdwait.until(ExpectedConditions.urlToBe ("https://wordpress.com/me"));
        WebElement profileName = driver.findElement(By.className("profile-gravatar__user-display-name"));
        Assert.assertEquals(profileName.getText(), username);

        WebElement logOutButton = driver.findElement(By.className("sidebar__me-signout-text"));
        Assert.assertTrue(logOutButton.isDisplayed ());

        driver.manage ().deleteAllCookies ();
        driver.navigate ().refresh ();

        Thread.sleep (2000);

        String urlLogIn = "https://wordpress.com/log-in?redirect_to=%2Fme";
        Assert.assertEquals (driver.getCurrentUrl (),urlLogIn );

        WebElement logInMessage = driver.findElement (By.className ("login__form-header"));
        Assert.assertTrue (logInMessage.isDisplayed ());


    }
}
