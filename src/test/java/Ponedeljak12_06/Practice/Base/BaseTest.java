package Ponedeljak12_06.Practice.Base;

import Ponedeljak12_06.Practice.Pages.LoginPage;
import Ponedeljak12_06.Practice.Pages.PracticePage;
import Ponedeljak12_06.Practice.Pages.SidebarPage;
import Ponedeljak12_06.Practice.Pages.UlogovaniPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public SidebarPage sidebarPage;
    public PracticePage practicePage;
    public LoginPage loginPage;
    public UlogovaniPage ulogovaniPage;
    public String validUsername = "student";
    public String validPassword ="Password123";
    public String invalidUsername = "123";
    public String invalidPassword = "PASSWORD";

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver ().setup ();
        driver = new ChromeDriver ();
        wait = new WebDriverWait (driver, Duration.ofSeconds (10));

        sidebarPage = new SidebarPage (driver);
        practicePage = new PracticePage (driver);
        loginPage = new LoginPage (driver);
        ulogovaniPage = new UlogovaniPage (driver);


    }

    public void waitForUrl(String URL){
    wait.until (ExpectedConditions.urlToBe (URL));
    }

    public void waitForVisiability(WebElement element){
        wait.until(ExpectedConditions.visibilityOf (element));
    }

    public void waitForClikability(WebElement element){
        wait.until (ExpectedConditions.elementToBeClickable (element));
    }

    public void clickOnElement(WebElement element){
        element.click ();
    }

    public boolean elementIsPresent(WebElement element){
        boolean nonExistingElement = false;
        try {
            nonExistingElement = element.isDisplayed ();
        } catch (Exception e){

        }
        return nonExistingElement;

    }

    public void openNewTab(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
    }

    public void saveImage(WebElement element) throws IOException {
        wait.until(ExpectedConditions.attributeContains(element, "src", "imgflip.com"));
        String link = element.getAttribute("src");
        URL imageURL = new URL(link);
        BufferedImage saveImage = ImageIO.read(imageURL);
        String location = "C:\\Users\\drago\\Desktop\\";
        ImageIO.write(saveImage, "png", new File ( location + System.currentTimeMillis() + ".png"));
    }
    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
