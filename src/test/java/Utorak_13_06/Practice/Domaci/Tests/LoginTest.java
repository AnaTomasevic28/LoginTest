package Utorak_13_06.Practice.Domaci.Tests;

import Utorak_13_06.Practice.Domaci.Base.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class LoginTest extends Base {
    String startUrl;
    String validUsername;
    String validPassword;
    String loginUrl;
    String logedInUrl;
    String invalidUsername;
    String invalidPassword;
    String uppercaseUsername;
    String uppercasePassword;

    String expectedTitleText;
    String expectedMessageText;

    @BeforeMethod
    public void pageSetUp(){
        driver.manage ().window ().maximize ();
        startUrl = excelReader.getStringData ("URL", 1, 2);
        validUsername = excelReader.getStringData ("Username", 1, 0);
        validPassword = excelReader.getStringData ("Password", 1,0);
        loginUrl = excelReader.getStringData ("URL", 1,0);
        logedInUrl = excelReader.getStringData ("URL", 1,1);
        invalidUsername = excelReader.getStringData ("Username", 1,1);
        invalidPassword = excelReader.getStringData ("Password", 1,1);
        uppercaseUsername = excelReader.getStringData ("Username", 1,2);
        uppercasePassword = excelReader.getStringData ("Password", 1,2);
        expectedTitleText = excelReader.getStringData ("Messages", 1,0);
        expectedMessageText = excelReader.getStringData ("Messages", 1,1);
        driver.get (startUrl);
        homePage.goToLoginPage ();
        //clickOnButton (homePage.getBasicAuthButton ());
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
        driver.get ("https://" + ":" + validPassword + "@" + loginUrl);
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
        driver.get ("https://" + validUsername + "@" + loginUrl);
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
