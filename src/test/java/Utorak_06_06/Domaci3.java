package Utorak_06_06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Domaci3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver ().setup ();
        WebDriver driver = new ChromeDriver ();

        driver.manage ().window ().maximize ();

        driver.get ("https://demoqa.com/login");

        WebDriverWait waiter = new WebDriverWait (driver, Duration.ofSeconds (10));

        Cookie logInCookie1 = new Cookie ("userName", "Anchi");
        Cookie logInCookie2 = new Cookie ("userID", "91e8334b-80fe-4b7f-9d8d-06d420fc70c6");
        Cookie logInCookie3 = new Cookie ("expires", "2023-06-14T16%3A56%3A07.599Z");
        Cookie logInCookie4 = new Cookie ("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkFuY2hpIiwicGFzc3dvcmQiOiJQYXZsZTIwMTcqIiwiaWF0IjoxNjg2MTU2OTY3fQ.f8DutYbHshI12VLV-XbuVlpjztL4K1rZJahLNR7EfRs");

        driver.manage ().addCookie (logInCookie1);
        driver.manage ().addCookie (logInCookie2);
        driver.manage ().addCookie (logInCookie3);
        driver.manage ().addCookie (logInCookie4);
        driver.navigate ().refresh ();

        WebElement profileLink = driver.findElement (By.linkText ("profile"));
        profileLink.click ();

        //waiter.until (ExpectedConditions.urlToBe ("https://demoqa.com/profile"));

        WebElement goToBookstoreButton = driver.findElement (By.cssSelector (".text-left.button"));
        Assert.assertTrue (goToBookstoreButton.isDisplayed ());

       // waiter.until (ExpectedConditions.elementToBeClickable (driver.findElement (By.cssSelector (".text-left.button"))));

        driver.manage ().window ().fullscreen ();

        //driver.manage ().window ().setSize (new Dimension (2000, 1080));

        goToBookstoreButton.click ();

        driver.manage ().window ().maximize ();

        WebElement bookSpeekingJava = driver.findElement (By.id ("see-book-Speaking JavaScript"));
        Assert.assertTrue (bookSpeekingJava.isDisplayed ());
        //bookSpeekingJava.sendKeys (Keys.DOWN);

        JavascriptExecutor js = (JavascriptExecutor) driver;
       // js.executeScript("window.scrollBy(0,250)", "");
        js.executeScript("arguments[0].scrollIntoView(true);", bookSpeekingJava);

        bookSpeekingJava.click ();


        WebElement addToCollectionButton = driver.findElement (By.cssSelector (".text-right.fullButton"));
        Assert.assertTrue (addToCollectionButton.isDisplayed ());
        js.executeScript("arguments[0].scrollIntoView(true);", addToCollectionButton);
        addToCollectionButton.click ();

        WebElement backToBookstoreButton = driver.findElement (By.cssSelector (".text-left.fullButton"));
        Assert.assertTrue (backToBookstoreButton.isDisplayed ());

        Thread.sleep (5000);

        driver.switchTo ().alert ().accept ();

        Thread.sleep (3000);
        backToBookstoreButton.click();

        WebElement bookDesigning = driver.findElement (By.id ("see-book-Designing Evolvable Web APIs with ASP.NET"));
        Assert.assertTrue (bookDesigning.isDisplayed ());
        bookDesigning.click ();

       // WebElement addButton = driver.findElement (By.xpath ("//*[@id=\"addNewRecordButton\"]"));
      //  Assert.assertTrue (addToCollectionButton.isDisplayed ());

        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement (By.cssSelector (".text-right.fullButton")));

        waiter.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.cssSelector (".text-right.fullButton")));
        driver.findElement(By.cssSelector (".text-right.fullButton")).click();

        Thread.sleep (5000);
        driver.switchTo ().alert ().accept ();

        driver.manage ().deleteAllCookies ();
        driver.navigate ().refresh ();

        WebElement logInButton = driver.findElement (By.id ("login"));
        logInButton.click ();

        WebElement userNameField = driver.findElement (By.id ("userName"));
        String validUserName = "Anchi";
        userNameField.sendKeys (validUserName);

        WebElement passwordField = driver.findElement (By.id ("password"));
        String validPassword = "Pavle2017*";
        passwordField.sendKeys (validPassword);

        waiter.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.id ("login")));
        driver.findElement(By.id ("login")).click();

        Thread.sleep (3000);
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement (By.xpath ("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]/span")));
        WebElement profilePage = driver.findElement (By.xpath ("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]/span"));
        Thread.sleep (5000);
        profilePage.click ();


        Thread.sleep (3000);

        WebElement bookSpeekingJava1 = driver.findElement (By.id ("see-book-Speaking JavaScript"));
        WebElement bookDesigning1 = driver.findElement (By.id ("see-book-Designing Evolvable Web APIs with ASP.NET"));
        Assert.assertTrue(bookSpeekingJava1.isDisplayed ());
        Assert.assertTrue (bookDesigning1.isDisplayed ());


    }
}
