package Ponedeljak12_06.Practice.Domaci.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
    public WebDriver driver;

    WebElement title;
    WebElement congradulationsMessage;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTitle() {
        return driver.findElement (By.xpath ("//*[@id=\"content\"]/div/h3"));
    }

    public WebElement getCongradulationsMessage() {
        return driver.findElement(By.xpath ("//*[@id=\"content\"]/div/p"));
    }

    //---------------------------------------------------

    public String getTitleText(){
        return getTitle ().getText ();
    }

    public String getCongradulationsMessageText(){
         return getCongradulationsMessage ().getText ();
    }



}
