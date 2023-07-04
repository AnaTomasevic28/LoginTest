package Utorak_13_06.Practice.Tests;

import Utorak_13_06.Practice.Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestsLogin extends Base {
//    String username1 = "standard_user";
//    String username2 = "locked_out_user";
//    String username3 = "problem_user";
//    String username4 = "performance_glitch_user";
//    String password = "secret_sauce";
    String logedInUrl = "https://www.saucedemo.com/inventory.html";

    @BeforeMethod
    public void pageSetUp(){
        driver.manage ().window ().maximize ();
        driver.get ("https://www.saucedemo.com/");
    }

    @Test(priority = 10)
    public void userCanLogin(){
        loginPage.enterUsername (exelReader.getStringData ("UsernameAndPassword", 1, 0));
        loginPage.enterPassword (exelReader.getStringData ("UsernameAndPassword", 1, 1));
        loginPage.clickLoginButton ();

        Assert.assertEquals (driver.getCurrentUrl(), logedInUrl);
        Assert.assertTrue (driver.findElement (By.id ("react-burger-menu-btn")).isDisplayed ());
        Assert.assertTrue (driver.findElement (By.className ("shopping_cart_link")).isDisplayed ());
    }
    @Test(priority = 20)
    public void userCanGoToFacebook() throws InterruptedException {
        userCanLogin ();
        sidebarPage.clickOnFacebookButton ();
        ArrayList<String> listaTabova = new ArrayList<> (driver.getWindowHandles ());
        driver.switchTo().window (listaTabova.get (1));
        Thread.sleep (2000);
        Assert.assertEquals (driver.getCurrentUrl (), "https://www.facebook.com/saucelabs");
        Assert.assertTrue (driver.findElement (By.xpath ("/html/body/div[1]/div/div[1]/div/div[5]/div/div/div[1]/div/div[2]/div/div/div/div[2]")).isDisplayed ());
    }

    @Test
    public void userCanAddToCartProduct(){
        userCanLogin ();
        for (int i = 0; i < homePage.getProductTitle ().size (); i++) {
            if (homePage.getProductTitle ().get (i).getText ().equalsIgnoreCase (exelReader.getStringData ("NaziviProizvoda", 5, 0))){
                homePage.getProductTitle ().get (i).click ();
            }
        }
        productPage.clickAddToCartButton ();
        Assert.assertEquals (sidebarPage.getCartButton ().getText (), "1");
        Assert.assertEquals (productPage.getRemoveButton ().getText (), "Remove");
    }
}
