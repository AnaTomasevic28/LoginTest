package Ponedeljak12_06.Practice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticePage {

    public WebDriver driver;
    WebElement testLoginPageButon;
    WebElement testExceptionsButton;

    public WebElement getTestLoginPageButon() {
        return driver.findElement (By.linkText ("Test Login Page"));
    }

    public WebElement getTestExceptionsButton() {
        return driver.findElement (By.linkText ("Test Exceptions"));
    }

    public PracticePage(WebDriver drvier) {
        this.driver = drvier;
    }

    //------------------------------------------------

    public void clickOnTestLoginPage(){
        getTestLoginPageButon ().click ();
    }

    public void clickOnTestExceptions(){
        getTestExceptionsButton ().click ();
    }



}

