package Ponedeljak12_06.Practice.Tests;

import Ponedeljak12_06.Practice.Base.BaseTest;
import Ponedeljak12_06.Practice.Pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver.manage ().window ().maximize ();
        driver.get ("https://practicetestautomation.com/");

    }

    @Test
    public void userCanLogin(){
        sidebarPage.clickOnPractice ();
        practicePage.clickOnTestLoginPage ();
        loginPage.enterUsername (validUsername);
        loginPage.enterPassword (validPassword);
        loginPage.clickSubmit ();

        Assert.assertTrue (ulogovaniPage.getLogedInMassage ().isDisplayed ());
        Assert.assertEquals (ulogovaniPage.getCongradulationsMessage ().getText (), "Congratulations student. You successfully logged in!");
        Assert.assertTrue (ulogovaniPage.getLogOutButton ().isDisplayed ());

    }

    @Test
    public void invalidUsername() throws InterruptedException {
        sidebarPage.clickOnPractice ();
        practicePage.clickOnTestLoginPage ();
        loginPage.enterUsername (invalidUsername);
        loginPage.enterPassword (validPassword);
        loginPage.clickSubmit ();

        Assert.assertEquals (driver.getCurrentUrl (), loginPage.urlLogInPage);
        waitForVisiability (loginPage.getErrorMessage ());
        Assert.assertTrue (loginPage.getErrorMessage ().isDisplayed ());
        Assert.assertEquals (loginPage.getErrorMessage ().getText (), loginPage.errorMessageUsername);

    }

    @Test
    public void invalidPassword(){
        sidebarPage.clickOnPractice ();
        practicePage.clickOnTestLoginPage ();
        loginPage.enterUsername (validUsername);
        loginPage.enterPassword (invalidPassword);
        loginPage.clickSubmit ();

        Assert.assertEquals (driver.getCurrentUrl (), loginPage.urlLogInPage);
        Assert.assertTrue (loginPage.getErrorMessage ().isDisplayed ());
        Assert.assertEquals (loginPage.getErrorMessage ().getText (), loginPage.errorMessagePassword);
    }

    @Test
    public void emptyUsernameField(){
        sidebarPage.clickOnPractice ();
        practicePage.clickOnTestLoginPage ();
        loginPage.enterPassword (validPassword);
        loginPage.clickSubmit ();

        Assert.assertEquals (driver.getCurrentUrl (), loginPage.urlLogInPage);
        Assert.assertTrue (loginPage.getErrorMessage ().isDisplayed ());
        Assert.assertEquals (loginPage.getErrorMessage ().getText (), loginPage.errorMessageUsername);
    }

    @Test
    public void emptyPasswordField(){
        sidebarPage.clickOnPractice ();
        practicePage.clickOnTestLoginPage ();
        loginPage.enterUsername (validUsername);
        loginPage.clickSubmit ();

        Assert.assertEquals (driver.getCurrentUrl (), loginPage.urlLogInPage);
        Assert.assertTrue (loginPage.getErrorMessage ().isDisplayed ());
        Assert.assertEquals (loginPage.getErrorMessage ().getText (), loginPage.errorMessagePassword);
    }

    @Test
    public void emptyFields(){
        sidebarPage.clickOnPractice ();
        practicePage.clickOnTestLoginPage ();
        loginPage.clickSubmit ();

        Assert.assertEquals (driver.getCurrentUrl (), loginPage.urlLogInPage);
        Assert.assertTrue (loginPage.getErrorMessage ().isDisplayed ());
        Assert.assertEquals (loginPage.getErrorMessage ().getText (), loginPage.errorMessageUsername);
    }

    @Test
    public void upperCaseUsername(){
        sidebarPage.clickOnPractice ();
        practicePage.clickOnTestLoginPage ();
        loginPage.enterUsername ("STUDENT");
        loginPage.enterPassword (validPassword);
        loginPage.clickSubmit ();

        Assert.assertEquals (driver.getCurrentUrl (), loginPage.urlLogInPage);
        Assert.assertTrue (loginPage.getErrorMessage ().isDisplayed ());
        Assert.assertEquals (loginPage.getErrorMessage ().getText (), loginPage.errorMessageUsername);
    }

    @Test
    public void upperCasePassword(){
        sidebarPage.clickOnPractice ();
        practicePage.clickOnTestLoginPage ();
        loginPage.enterUsername (validUsername);
        loginPage.enterPassword ("PASSWORD123");
        loginPage.clickSubmit ();

        Assert.assertEquals (driver.getCurrentUrl (), loginPage.urlLogInPage);
        Assert.assertTrue (loginPage.getErrorMessage ().isDisplayed ());
        Assert.assertEquals (loginPage.getErrorMessage ().getText (), loginPage.errorMessagePassword);
    }

}
