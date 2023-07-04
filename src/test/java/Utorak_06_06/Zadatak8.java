package Utorak_06_06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak8 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver ().setup ();
        WebDriver driver = new ChromeDriver ();

        driver.manage ().window ().maximize ();

        driver.get ("https://crop-circle.imageonline.co/#circlecropresult");

        String imageLocation = "C:\\Users\\Ana\\Desktop\\image.png";

        WebElement uploadButton = driver.findElement (By.id ("inputImage"));

        uploadButton.sendKeys (imageLocation);



    }
}
