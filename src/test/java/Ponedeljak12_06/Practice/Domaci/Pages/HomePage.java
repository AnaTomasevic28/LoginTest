package Ponedeljak12_06.Practice.Domaci.Pages;

import Ponedeljak12_06.Practice.Domaci.Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public WebDriver driver;
    WebElement basicAuthButton;

    public WebElement getBasicAuthButton() {
        return driver.findElement (By.linkText ("Basic Auth"));
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //----------------------------------------------

    public void goToLoginPage(){
         getBasicAuthButton ().click ();
    }

}
