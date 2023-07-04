package Ponedeljak_05_06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver ().setup ();
        WebDriver driver = new ChromeDriver ();

        driver.manage ().window ().maximize ();

        driver.get ("https://www.google.com/");

        Thread.sleep (3000);
        driver.navigate ().refresh ();

        WebElement element1 = driver.findElement (By.xpath ("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea"));
        element1.sendKeys ("youtube");

        Thread.sleep (2000);

        element1.sendKeys (Keys.ENTER);
        Thread.sleep (5000);

        driver.quit ();



    }
}
