package Utorak_13_06.Practice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class LoginPage {

    public WebDriver driver;
    WebElement usernameField;
    WebElement passwordField;
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameField() {
        return driver.findElement (By.id ("user-name"));
    }

    public WebElement getPasswordField() {
        return driver.findElement (By.id ("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement (By.id ("login-button"));
    }
    //-----------------------------------------------------------

    public void enterUsername(String username){
        getUsernameField ().clear ();
        getUsernameField ().sendKeys (username);
    }
    public void enterPassword(String password){
        getPasswordField ().clear ();
        getPasswordField ().sendKeys (password);
    }

    public void clickLoginButton(){
        getLoginButton ().click ();
    }
}
