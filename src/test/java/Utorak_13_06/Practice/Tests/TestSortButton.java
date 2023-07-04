package Utorak_13_06.Practice.Tests;

import Utorak_13_06.Practice.Base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSortButton extends Base {

    @BeforeMethod
    public void pageSetUp(){
        driver.manage ().window ().maximize ();
        driver.get ("https://www.saucedemo.com/inventory.html");
    }


}
