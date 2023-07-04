package Ponedeljak12_06.Practice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;
    WebElement usernameField;
    WebElement passwordField;
    WebElement submitButton;
    WebElement errorMessage;
    public String errorMessageUsername = "Your username is invalid!";
    public String errorMessagePassword = "Your password is invalid!";

    public WebElement getErrorMessage() {
        return driver.findElement (By.id ("error"));
    }

    public String urlLogInPage = "https://practicetestautomation.com/practice-test-login/";


    public WebElement getUsernameField() {
        return driver.findElement (By.id ("username"));
    }

    public WebElement getPasswordField() {
        return driver.findElement (By.id ("password"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement (By.id ("submit"));
    }
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //------------------------------------------------

    public void enterUsername(String username){
        getUsernameField ().clear ();
        getUsernameField ().sendKeys (username);
    }

    public void enterPassword(String password){
        getPasswordField ().clear ();
        getPasswordField ().sendKeys (password);
    }

    public void clickSubmit(){
        getSubmitButton ().click ();
    }

}
