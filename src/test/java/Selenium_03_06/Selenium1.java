package Selenium_03_06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver ().setup ();
        WebDriver driver = new ChromeDriver ();
        driver.manage ().window ().maximize ();
        driver.get ("https://www.google.com");
        System.out.println (driver.getCurrentUrl ());
        driver.navigate ().to ("https://youtube.com");
        driver.navigate ().refresh ();
        System.out.println (driver.getCurrentUrl ());
        driver.navigate ().back ();
        driver.navigate ().forward ();
        driver.quit ();
    }
}
