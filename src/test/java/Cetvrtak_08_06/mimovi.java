package Cetvrtak_08_06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class mimovi {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver ().setup ();
        WebDriver driver = new ChromeDriver ();

        driver.manage ().window ().maximize ();

        driver.get("https://imgflip.com/memegenerator");

        WebElement uploadNewTemplateButton = driver.findElement (By.id ("mm-show-upload"));
        uploadNewTemplateButton.click ();

        String image = "C:\\Users\\Ana\\Desktop\\PRINTSC\\selenium.png";

        Thread.sleep (2000);
        WebElement upload = driver.findElement (By.id ("mm-upload-file-btn"));
        Assert.assertTrue (upload.isDisplayed ());
        Thread.sleep (5000);
        upload.sendKeys (image);
//
//        WebElement uploadButton = driver.findElement (By.id ("mm-upload-btn"));
//        uploadButton.click ();
    }
}
