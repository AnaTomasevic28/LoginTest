package Ponedeljak12_06.Practice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UlogovaniPage {

    public WebDriver driver;
    WebElement logedInMassage;
    WebElement congradulationsMessage;
    WebElement logOutButton;

    public WebElement getLogedInMassage() {
        return driver.findElement (By.className ("post-title"));
    }

    public WebElement getCongradulationsMessage() {
        return driver.findElement (By.className ("has-text-align-center"));
    }

    public WebElement getLogOutButton() {
        return driver.findElement (By.linkText ("Log out"));
    }

    public UlogovaniPage(WebDriver driver) {
        this.driver = driver;
    }
    //-----------------------------------------------------

    public void clickOnLogOutButton(){
        getLogOutButton ().click ();
    }

}
