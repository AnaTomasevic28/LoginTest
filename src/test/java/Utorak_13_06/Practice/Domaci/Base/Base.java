package Utorak_13_06.Practice.Domaci.Base;

import Ponedeljak12_06.Practice.Domaci.Pages.HomePage;
import Ponedeljak12_06.Practice.Domaci.Pages.ProfilePage;
import Utorak_13_06.Practice.Base.ExcelReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class Base {
    public WebDriver driver;
    public WebDriverWait waiter;
    JavascriptExecutor js;
    public ExcelReader excelReader;
    public HomePage homePage;
    public ProfilePage profilePage;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver ().setup ();
        driver = new ChromeDriver ();
        waiter = new WebDriverWait (driver, Duration.ofSeconds (10));
        excelReader = new ExcelReader ("src/test/java/Utorak_13_06/Practice/Domaci/TestDataHeroku.xlsx");
        js = (JavascriptExecutor) driver;
        homePage = new HomePage (driver);
        profilePage = new ProfilePage (driver);

    }

    public void clickOnButton(WebElement button){
        button.click ();
    }
    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @AfterClass
    public void tearDown(){
        driver.quit ();
    }
}
