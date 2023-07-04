package Utorak_13_06.Practice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SidebarPage {
    public WebDriver driver;
    WebElement humburgerButton;
    WebElement cartButton;
    WebElement title;
    WebElement twiterButton;
    WebElement linkedinButton;
    WebElement facebookButton;
    WebElement footer;

    public SidebarPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHumburgerButton() {
        return driver.findElement (By.id ("react-burger-menu-btn"));
    }

    public WebElement getCartButton() {
        return driver.findElement (By.id("shopping_cart_container"));
    }

    public WebElement getTitle() {
        return driver.findElement (By.className ("app_logo"));
    }
    public WebElement getTwiterButton() {
        return driver.findElement (By.className ("social_twitter"));
    }

    public WebElement getLinkedinButton() {
        return driver.findElement (By.className ("social_linkedin"));
    }

    public WebElement getFacebookButton() {
        return driver.findElement (By.xpath ("/html/body/div/div/footer/ul/li[2]/a"));
    }

    public WebElement getFooter() {
        return driver.findElement (By.className ("footer_copy"));
    }
//---------------------------------------------------------------------

    public void clickOnHumburgerButton(){
        getHumburgerButton ().click ();
    }
    public void clickOnCartButton(){
        getCartButton ().click ();
    }
    public void getTitleText(){
        getTitle ().getText ();
    }
    public void clickOnTwiterButton(){
        getTwiterButton ().click ();
    }
    public void clickOnLinkedInButton(){
        getLinkedinButton ().click ();
    }
    public void clickOnFacebookButton(){
        getFacebookButton ().click ();
    }
    public void getFooterText(){
        getFooter ().getText ();
    }

}
