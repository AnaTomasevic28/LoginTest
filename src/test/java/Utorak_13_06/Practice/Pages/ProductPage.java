package Utorak_13_06.Practice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    public WebDriver driver;
    WebElement backToProductsButton;
    WebElement productImage;
    WebElement productTitle;
    WebElement productDescription;
    WebElement productPrice;
    WebElement addToCartButton;
    WebElement removeButton;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getBackToProductsButton() {
        return driver.findElement (By.id ("back-to-products"));
    }

    public WebElement getProductImage() {
        return driver.findElement (By.className ("inventory_details_img"));
    }

    public WebElement getProductTitle() {
        return driver.findElement (By.cssSelector ("inventory_details_name large_size"));
    }

    public WebElement getProductDescription() {
        return driver.findElement (By.cssSelector (".inventory_details_desc.large_size"));
    }

    public WebElement getProductPrice() {
        return driver.findElement (By.className ("inventory_details_price"));
    }

    public WebElement getAddToCartButton() {
        return driver.findElement (By.cssSelector (".btn.btn_primary.btn_small.btn_inventory"));
    }

    public WebElement getRemoveButton() {
        return driver.findElement (By.cssSelector (".btn.btn_secondary.btn_small.btn_inventory"));
    }
    //--------------------------------------------------------------------------------

    public void clickOnBackToProductsButton(){
        getBackToProductsButton ().click ();
    }
    public void getTextOfProductTitle(){
        getProductTitle ().getText ();
    }
    public void getTextOfProductDescription(){
        getProductDescription ().getText ();
    }
    public void getTextOfProductPrice(){
        getProductPrice ().getText ();
    }
    public void clickAddToCartButton(){
        getAddToCartButton ().click ();
    }
}
