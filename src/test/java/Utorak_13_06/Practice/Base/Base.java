package Utorak_13_06.Practice.Base;

import Utorak_13_06.Practice.Pages.HomePage;
import Utorak_13_06.Practice.Pages.LoginPage;
import Utorak_13_06.Practice.Pages.ProductPage;
import Utorak_13_06.Practice.Pages.SidebarPage;
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
    public JavascriptExecutor js;
    public ExcelReader exelReader;
    public LoginPage loginPage;
    public SidebarPage sidebarPage;
    public HomePage homePage;
    public ProductPage productPage;


    @BeforeClass
    public void setUp() throws IOException {
        driver = new ChromeDriver ();
        WebDriverManager.chromedriver ().setup ();
        waiter = new WebDriverWait (driver, Duration.ofSeconds (10));
        js = (JavascriptExecutor) driver;
        exelReader = new ExcelReader ("C:\\Users\\Ana\\Desktop\\TestData.xlsx");
        loginPage = new LoginPage (driver);
        sidebarPage = new SidebarPage (driver);
        homePage = new HomePage (driver);
        productPage = new ProductPage (driver);

    }

    public void clickOnElement(WebElement element){
        element.click ();
    }

    @AfterClass
    public void clean(){
//        driver.quit ();
    }
}
