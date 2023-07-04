package Selenium_03_06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Selenium2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver ().setup ();
        WebDriver driver = new ChromeDriver ();
        driver.manage ().window ().maximize ();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ("window.open()");
        js.executeScript ("window.open()");
        js.executeScript ("window.open()");

        ArrayList<String> listaTabova = new ArrayList<> (driver.getWindowHandles ());
//        System.out.println (listaTabova.get (0));
//        System.out.println (listaTabova.get (1));
//        System.out.println (listaTabova.get (2));

        driver.switchTo ().window (listaTabova.get (0));
        driver.navigate ().to ("https://www.google.com//");

        driver.switchTo ().window (listaTabova.get (1));
        driver.navigate ().to ("https://www.youtube.com//");

        driver.switchTo ().window (listaTabova.get (2));
        driver.navigate ().to ("https://www.joberty.com//");

        driver.switchTo ().window (listaTabova.get (3));
        driver.navigate ().to ("https://www.helloworld.com//");

        /*
        driver.close ();  // zatvara tab na kom se nalazimo, mora se zatvoriti svaki tab posebno

        driver.switchTo ().window (listaTabova.get (2));
        driver.close ();

        driver.switchTo ().window (listaTabova.get (1));
        driver.close ();
         */
        driver.quit ();  // zatvara ceo browser odjednom






    }
}
