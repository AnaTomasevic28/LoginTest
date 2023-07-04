package Ponedeljak12_06.Practice.Domaci.Tests;

import Ponedeljak12_06.Practice.Domaci.Base.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Base {
    String validUsername = "admin";
    String validPassword = "admin";
    String invalidUsername = "123";
    String invalidPassword = "456";
    String uppercaseUsername = "ADMIN";
    String uppercasePassword = "ADMIN";
    String loginUrl = "the-internet.herokuapp.com/basic_auth";
    String logedInUrl = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
    String expectedTitleText = "Basic Auth";
    String expectedMessageText = "Congratulations! You must have the proper credentials.";

    @BeforeMethod
    public void pageSetUp(){
        driver.manage ().window ().maximize ();
        driver.get ("https://the-internet.herokuapp.com/");
        clickOnButton (homePage.getBasicAuthButton ());
    }
    @Test
    public void userCanLogIn(){
        driver.get ("https://" + validUsername + ":" + validPassword + "@" + loginUrl);

        Assert.assertEquals (driver.getCurrentUrl (), logedInUrl);
        Assert.assertEquals (profilePage.getTitleText (), expectedTitleText);
        Assert.assertEquals (profilePage.getCongradulationsMessageText (), expectedMessageText);
    }

    @Test
    public void userCannotLoginWithInvalidUsername(){
        driver.get ("https://" + invalidUsername + ":" + validPassword + "@" + loginUrl);
        Assert.assertNotEquals (driver.getCurrentUrl (), logedInUrl);
        boolean logedIn = false;
        try{
            logedIn = profilePage.getTitle().isDisplayed();
        } catch (Exception e){
        }
        Assert.assertFalse (logedIn);
        boolean logedInMessage = false;
        try{
            logedInMessage = profilePage.getCongradulationsMessage ().isDisplayed ();
        }catch (Exception e){
        }
        Assert.assertFalse (logedInMessage);
    }

    @Test
    public void userCannotLoginWithInvalidPassword(){
        driver.get ("https://" + validUsername + ":" + invalidPassword + "@" + loginUrl);
        Assert.assertNotEquals (driver.getCurrentUrl (), logedInUrl);
        boolean logedIn = false;
        try{
            logedIn = profilePage.getTitle().isDisplayed();
        } catch (Exception e){
        }
        Assert.assertFalse (logedIn);
        boolean logedInMessage = false;
        try{
            logedInMessage = profilePage.getCongradulationsMessage ().isDisplayed ();
        }catch (Exception e){
        }
        Assert.assertFalse (logedInMessage);
    }

    @Test
    public void userCannotLoginWithInvalidPasswordAndUsername(){
        driver.get ("https://" + invalidUsername + ":" + invalidPassword + "@" + loginUrl);
        Assert.assertNotEquals (driver.getCurrentUrl (), logedInUrl);
        boolean logedIn = false;
        try{
            logedIn = profilePage.getTitle().isDisplayed();
        } catch (Exception e){
        }
        Assert.assertFalse (logedIn);
        boolean logedInMessage = false;
        try{
            logedInMessage = profilePage.getCongradulationsMessage ().isDisplayed ();
        }catch (Exception e){
        }
        Assert.assertFalse (logedInMessage);
    }

    @Test
    public void userCannotLoginWithUpperCaseUsername(){
        driver.get ("https://" + uppercaseUsername + ":" + validPassword + "@" + loginUrl);
        Assert.assertNotEquals (driver.getCurrentUrl (), logedInUrl);
        boolean logedIn = false;
        try{
            logedIn = profilePage.getTitle().isDisplayed();
        } catch (Exception e){
        }
        Assert.assertFalse (logedIn);
        boolean logedInMessage = false;
        try{
            logedInMessage = profilePage.getCongradulationsMessage ().isDisplayed ();
        }catch (Exception e){
        }
        Assert.assertFalse (logedInMessage);
    }

    @Test
    public void userCannotLoginWithUpperCasePassword(){
        driver.get ("https://" + validUsername + ":" + uppercasePassword + "@" + loginUrl);
        Assert.assertNotEquals (driver.getCurrentUrl (), logedInUrl);
        boolean logedIn = false;
        try{
            logedIn = profilePage.getTitle().isDisplayed();
        } catch (Exception e){
        }
        Assert.assertFalse (logedIn);
        boolean logedInMessage = false;
        try{
            logedInMessage = profilePage.getCongradulationsMessage ().isDisplayed ();
        }catch (Exception e){
        }
        Assert.assertFalse (logedInMessage);
    }
    @Test
    public void userCannotLoginWithUpperCaseUsernameAndPassword(){
        driver.get ("https://" + uppercaseUsername + ":" + uppercasePassword + "@" + loginUrl);
        Assert.assertNotEquals (driver.getCurrentUrl (), logedInUrl);
        boolean logedIn = false;
        try{
            logedIn = profilePage.getTitle().isDisplayed();
        } catch (Exception e){
        }
        Assert.assertFalse (logedIn);
        boolean logedInMessage = false;
        try{
            logedInMessage = profilePage.getCongradulationsMessage ().isDisplayed ();
        }catch (Exception e){
        }
        Assert.assertFalse (logedInMessage);
    }

    @Test
    public void userCannotLoginWithoutUsername(){
        driver.get ("https://" + ":" + uppercasePassword + "@" + loginUrl);
        Assert.assertNotEquals (driver.getCurrentUrl (), logedInUrl);
        boolean logedIn = false;
        try{
            logedIn = profilePage.getTitle().isDisplayed();
        } catch (Exception e){
        }
        Assert.assertFalse (logedIn);
        boolean logedInMessage = false;
        try{
            logedInMessage = profilePage.getCongradulationsMessage ().isDisplayed ();
        }catch (Exception e){
        }
        Assert.assertFalse (logedInMessage);
    }

    @Test
    public void userCannotLoginWithoutPassword(){
        driver.get ("https://" + uppercaseUsername + "@" + loginUrl);
        Assert.assertNotEquals (driver.getCurrentUrl (), logedInUrl);
        boolean logedIn = false;
        try{
            logedIn = profilePage.getTitle().isDisplayed();
        } catch (Exception e){
        }
        Assert.assertFalse (logedIn);
        boolean logedInMessage = false;
        try{
            logedInMessage = profilePage.getCongradulationsMessage ().isDisplayed ();
        }catch (Exception e){
        }
        Assert.assertFalse (logedInMessage);
    }

    @Test
    public void userCannotLoginWithoutUsernameAndPassword(){
        driver.get ("https://" + loginUrl);
        Assert.assertNotEquals (driver.getCurrentUrl (), logedInUrl);
        boolean logedIn = false;
        try{
            logedIn = profilePage.getTitle().isDisplayed();
        } catch (Exception e){
        }
        Assert.assertFalse (logedIn);
        boolean logedInMessage = false;
        try{
            logedInMessage = profilePage.getCongradulationsMessage ().isDisplayed ();
        }catch (Exception e){
        }
        Assert.assertFalse (logedInMessage);
    }

}
