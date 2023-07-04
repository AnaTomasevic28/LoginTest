package Ponedeljak12_06.Practice.Domaci.Base;

import Ponedeljak12_06.Practice.Domaci.Pages.HomePage;
import Ponedeljak12_06.Practice.Domaci.Pages.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class Base {

    public WebDriver driver;
    public WebDriverWait waiter;
    public HomePage homePage;
    public ProfilePage profilePage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver ().setup ();
        driver = new ChromeDriver ();
        waiter = new WebDriverWait (driver, Duration.ofSeconds (10));
        homePage = new HomePage (driver);
        profilePage = new ProfilePage (driver);

    }

    public void clickOnButton(WebElement button){
        button.click ();
    }

    @AfterClass
    public void tearDown(){
        driver.quit ();
    }
}
