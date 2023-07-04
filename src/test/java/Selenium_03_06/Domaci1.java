package Selenium_03_06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//Domaci Zadatak 1:
//Otici na YouTube preko Google pretrage, kada pristupite YouTube-u, odabrati pesmu po vasem izboru.
public class Domaci1 {
    public static void main(String[] args) {

        WebDriverManager. chromedriver ().setup ();
        WebDriver driver = new ChromeDriver ();
        driver.manage ().window ().maximize ();

        driver.get ("https://www.google.com/");

        WebElement googleSearch = driver.findElement (By.xpath ("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea"));
        googleSearch.sendKeys ("youtube");

        WebElement searchButton = driver.findElement (By.xpath ("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
        searchButton.click ();

        WebElement youtubeLink = driver.findElement (By.xpath ("/html/body/div[6]/div/div[11]/div[1]/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div[1]/a/h3"));
        youtubeLink.click ();

        WebElement youtubeSearch = driver.findElement (By.xpath ("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[2]/ytd-searchbox/form/div[1]/div[1]/input"));
        youtubeSearch.sendKeys ("drivers on the storm");

        WebElement youtubeLupa = driver.findElement (By.xpath ("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[2]/ytd-searchbox/button"));
        youtubeLupa.click ();

        // do ovog momenta sve radi. Pesmu nece da pusti. Vrv se, kao sto je Vladimir rekao,
        // sporije ucitava sajt nego sto njemu treba da izvrsi sledeci red koda.

        driver.manage ().timeouts ().implicitlyWait (5, TimeUnit.SECONDS);
        // ovo je vrv jedan nacin,da se to prevazidje i sa ovim hoce da pusti pesmu

        WebElement song = driver.findElement (By.xpath ("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[1]/div[1]/ytd-thumbnail/a/yt-image/img"));
        song.click();

    }


}
