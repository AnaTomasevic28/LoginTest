package Petak_09_06.Domaci5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAddBook {

    WebDriver driver;
    JavascriptExecutor js;
    String validUsername = "Anchi";
    String validPassword = "Pavle2017*";
    String profileUrl = "https://demoqa.com/profile";

    @BeforeClass
    public void setUpMethod(){
        WebDriverManager.chromedriver ().setup ();

    }

    @BeforeMethod
    public void preDodavanja(){

        driver = new ChromeDriver ();
        driver.manage ().window ().maximize ();

        driver.get ("https://demoqa.com/login");

        WebElement userNameField = driver.findElement (By.id ("userName"));
        userNameField.sendKeys (validUsername);

        WebElement passwordField = driver.findElement (By.id ("password"));
        passwordField.sendKeys (validPassword);

        WebElement logInButton = driver.findElement (By.id ("login"));
        logInButton.click ();
    }

    @Test
    public void dodajJednuKnjigu() throws InterruptedException {

        js = (JavascriptExecutor) driver;

        Thread.sleep (2000);

        WebElement goToBookStoreButton = driver.findElement (By.cssSelector (".text-left.button"));
        js.executeScript("arguments[0].scrollIntoView(true);", goToBookStoreButton);
        goToBookStoreButton.click ();

        Thread.sleep (2000);

        WebElement book1 = driver.findElement (By.id ("see-book-Git Pocket Guide"));
        book1.click ();

        Thread.sleep (2000);

        WebElement addToMyCollectionButton = driver.findElement (By.cssSelector (".text-right.fullButton"));
        js.executeScript("arguments[0].scrollIntoView(true);", addToMyCollectionButton);
        addToMyCollectionButton.click ();

        Thread.sleep (2000);

        driver.switchTo ().alert ().accept ();

        Thread.sleep (2000);

        WebElement profileLink = driver.findElement (By.xpath ("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]/span"));
        js.executeScript ("arguments[0].scrollIntoView(true);", profileLink);
        profileLink.click ();

        Assert.assertEquals (driver.getCurrentUrl (), profileUrl);

        Thread.sleep (2000);

        WebElement theBook1 = driver.findElement (By.id ("see-book-Git Pocket Guide"));
        Assert.assertTrue (theBook1.isDisplayed ());

    }

    @Test
    public void dodajDveKnjige() throws InterruptedException {

        js = (JavascriptExecutor) driver;

        Thread.sleep (2000);

        WebElement goToBookStoreButton = driver.findElement (By.cssSelector (".text-left.button"));
        js.executeScript("arguments[0].scrollIntoView(true);", goToBookStoreButton);
        goToBookStoreButton.click ();

        Thread.sleep (2000);

        WebElement book1 = driver.findElement (By.id ("see-book-Git Pocket Guide"));
        book1.click ();

        Thread.sleep (2000);

        WebElement addToMyCollectionButton = driver.findElement (By.cssSelector (".text-right.fullButton"));
        js.executeScript("arguments[0].scrollIntoView(true);", addToMyCollectionButton);
        addToMyCollectionButton.click ();

        Thread.sleep (2000);

        driver.switchTo ().alert ().accept ();

        WebElement backToTheBookstoreButton = driver.findElement (By.xpath ("//*[@id=\"addNewRecordButton\"]"));
        backToTheBookstoreButton.click ();

        WebElement book2 = driver.findElement (By.linkText ("Learning JavaScript Design Patterns"));
        book2.click ();

        Thread.sleep (2000);

        WebElement addToMyCollectionButton1 = driver.findElement (By.cssSelector (".text-right.fullButton"));
        js.executeScript("arguments[0].scrollIntoView(true);", addToMyCollectionButton1);
        addToMyCollectionButton1.click ();

        Thread.sleep (2000);
        driver.switchTo ().alert ().accept ();

        WebElement profileLink = driver.findElement (By.xpath ("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]/span"));
        js.executeScript ("arguments[0].scrollIntoView(true);", profileLink);
        profileLink.click ();

        Assert.assertEquals (driver.getCurrentUrl (), profileUrl);

        Thread.sleep (2000);

        WebElement theBook1 = driver.findElement (By.id ("see-book-Git Pocket Guide"));
        Assert.assertTrue (theBook1.isDisplayed ());

        WebElement theBook2 = driver.findElement (By.linkText ("Learning JavaScript Design Patterns"));
        Assert.assertTrue (theBook2.isDisplayed ());

    }

    @Test
    public void dodajTriKnjige() throws InterruptedException {

        js = (JavascriptExecutor) driver;

        Thread.sleep (2000);

        WebElement goToBookStoreButton = driver.findElement (By.cssSelector (".text-left.button"));
        js.executeScript("arguments[0].scrollIntoView(true);", goToBookStoreButton);
        goToBookStoreButton.click ();

        Thread.sleep (2000);

        WebElement book1 = driver.findElement (By.id ("see-book-Git Pocket Guide"));
        book1.click ();

        Thread.sleep (2000);

        WebElement addToMyCollectionButton = driver.findElement (By.cssSelector (".text-right.fullButton"));
        js.executeScript("arguments[0].scrollIntoView(true);", addToMyCollectionButton);
        addToMyCollectionButton.click ();

        Thread.sleep (2000);

        driver.switchTo ().alert ().accept ();

        WebElement backToTheBookstoreButton = driver.findElement (By.xpath ("//*[@id=\"addNewRecordButton\"]"));
        backToTheBookstoreButton.click ();

        WebElement book2 = driver.findElement (By.linkText ("Learning JavaScript Design Patterns"));
        book2.click ();

        Thread.sleep (2000);

        WebElement addToMyCollectionButton1 = driver.findElement (By.cssSelector (".text-right.fullButton"));
        js.executeScript("arguments[0].scrollIntoView(true);", addToMyCollectionButton1);
        addToMyCollectionButton1.click ();

        Thread.sleep (2000);
        driver.switchTo ().alert ().accept ();

        WebElement backToTheBookstoreButton1 = driver.findElement (By.xpath ("//*[@id=\"addNewRecordButton\"]"));
        backToTheBookstoreButton1.click ();

        WebElement book3 = driver.findElement (By.id ("see-book-Designing Evolvable Web APIs with ASP.NET"));
        js.executeScript ("arguments[0].scrollIntoView(true);", book3);
        book3.click ();

        WebElement addToMyCollectionButton2 = driver.findElement (By.cssSelector (".text-right.fullButton"));
        js.executeScript("arguments[0].scrollIntoView(true);", addToMyCollectionButton2);
        addToMyCollectionButton2.click ();

        Thread.sleep (2000);
        driver.switchTo ().alert ().accept ();

        WebElement profileLink = driver.findElement (By.xpath ("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]/span"));
        js.executeScript ("arguments[0].scrollIntoView(true);", profileLink);
        profileLink.click ();

        Assert.assertEquals (driver.getCurrentUrl (), profileUrl);

        Thread.sleep (2000);

        WebElement theBook1 = driver.findElement (By.id ("see-book-Git Pocket Guide"));
        Assert.assertTrue (theBook1.isDisplayed ());

        WebElement theBook2 = driver.findElement (By.linkText ("Learning JavaScript Design Patterns"));
        Assert.assertTrue (theBook2.isDisplayed ());

        WebElement theBook3 = driver.findElement (By.id ("see-book-Designing Evolvable Web APIs with ASP.NET"));
        Assert.assertTrue (theBook3.isDisplayed ());

    }

    @Test
    public void dodajCetiriKnjige() throws InterruptedException {
        js = (JavascriptExecutor) driver;

        Thread.sleep (2000);

        WebElement goToBookStoreButton = driver.findElement (By.cssSelector (".text-left.button"));
        js.executeScript("arguments[0].scrollIntoView(true);", goToBookStoreButton);
        goToBookStoreButton.click ();

        Thread.sleep (2000);

        WebElement book1 = driver.findElement (By.id ("see-book-Git Pocket Guide"));
        book1.click ();

        Thread.sleep (2000);

        WebElement addToMyCollectionButton = driver.findElement (By.cssSelector (".text-right.fullButton"));
        js.executeScript("arguments[0].scrollIntoView(true);", addToMyCollectionButton);
        addToMyCollectionButton.click ();

        Thread.sleep (2000);

        driver.switchTo ().alert ().accept ();

        WebElement backToTheBookstoreButton = driver.findElement (By.xpath ("//*[@id=\"addNewRecordButton\"]"));
        backToTheBookstoreButton.click ();

        WebElement book2 = driver.findElement (By.linkText ("Learning JavaScript Design Patterns"));
        book2.click ();

        Thread.sleep (2000);

        WebElement addToMyCollectionButton1 = driver.findElement (By.cssSelector (".text-right.fullButton"));
        js.executeScript("arguments[0].scrollIntoView(true);", addToMyCollectionButton1);
        addToMyCollectionButton1.click ();

        Thread.sleep (2000);
        driver.switchTo ().alert ().accept ();

        WebElement backToTheBookstoreButton1 = driver.findElement (By.xpath ("//*[@id=\"addNewRecordButton\"]"));
        backToTheBookstoreButton1.click ();

        WebElement book3 = driver.findElement (By.id ("see-book-Designing Evolvable Web APIs with ASP.NET"));
        js.executeScript ("arguments[0].scrollIntoView(true);", book3);
        book3.click ();

        WebElement addToMyCollectionButton2 = driver.findElement (By.cssSelector (".text-right.fullButton"));
        js.executeScript("arguments[0].scrollIntoView(true);", addToMyCollectionButton2);
        addToMyCollectionButton2.click ();

        Thread.sleep (2000);
        driver.switchTo ().alert ().accept ();

        WebElement backToTheBookstoreButton2 = driver.findElement (By.xpath ("//*[@id=\"addNewRecordButton\"]"));
        backToTheBookstoreButton2.click ();

        WebElement book4 = driver.findElement (By.id ("see-book-Speaking JavaScript"));
        js.executeScript("arguments[0].scrollIntoView(true);", book4);
        book4.click ();

        WebElement addToMyCollectionButton3 = driver.findElement (By.cssSelector (".text-right.fullButton"));
        js.executeScript("arguments[0].scrollIntoView(true);", addToMyCollectionButton3);
        addToMyCollectionButton3.click ();

        Thread.sleep (1000);
        driver.switchTo ().alert ().accept ();

        WebElement profileLink = driver.findElement (By.xpath ("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]/span"));
        js.executeScript ("arguments[0].scrollIntoView(true);", profileLink);
        profileLink.click ();

        Assert.assertEquals (driver.getCurrentUrl (), profileUrl);

        Thread.sleep (2000);

        WebElement theBook1 = driver.findElement (By.id ("see-book-Git Pocket Guide"));
        Assert.assertTrue (theBook1.isDisplayed ());

        WebElement theBook2 = driver.findElement (By.linkText ("Learning JavaScript Design Patterns"));
        Assert.assertTrue (theBook2.isDisplayed ());

        WebElement theBook3 = driver.findElement (By.id ("see-book-Designing Evolvable Web APIs with ASP.NET"));
        Assert.assertTrue (theBook3.isDisplayed ());

        WebElement theBook4 = driver.findElement (By.id ("see-book-Speaking JavaScript"));
        Assert.assertTrue (theBook4.isDisplayed ());

    }



    @AfterMethod
    public void izlogujSe() throws InterruptedException {

        WebElement deleteAllBooksButton = driver.findElement (By.xpath ("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[3]/button"));
        js.executeScript ("arguments[0].scrollIntoView(true);", deleteAllBooksButton);
        deleteAllBooksButton.click ();

        WebElement confirmDeletingButton = driver.findElement (By.id ("closeSmallModal-ok"));
        confirmDeletingButton.click ();

        Thread.sleep (2000);
        driver.switchTo ().alert ().accept ();

        WebElement logOutButton = driver.findElement (By.xpath ("//*[@id=\"submit\"]"));
        logOutButton.click ();

        driver.quit ();
    }

}
