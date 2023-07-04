package Utorak_13_06.Practice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    public WebDriver driver;
    WebElement sortButton;
    WebElement productsText;
    WebElement productImage;
    WebElement productTitle;
    WebElement productPrice;
    WebElement productDescription;
    WebElement productAddToCartButton;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getSortButton() {
        return driver.findElement (By.className ("product_sort_container"));
    }

    public WebElement getProductsText() {
        return driver.findElement (By.className ("title"));
    }

    public List<WebElement> getProductImage() {
        return driver.findElements (By.className ("inventory_item_img"));
    }

    public List<WebElement> getProductTitle() {
        return driver.findElements (By.className ("inventory_item_name"));
    }

    public List<WebElement> getProductPrice() {
        return driver.findElements (By.className ("inventory_item_price"));
    }

    public List<WebElement> getProductDescription() {
        return driver.findElements (By.className ("inventory_item_desc"));
    }

    public List<WebElement> getProductAddToCartButton() {
        return driver.findElements (By.cssSelector (".btn.btn_primary.btn_small.btn_inventory"));
    }
    //---------------------------------------

    public void sortProducts(){
        getSortButton ().click ();
    }
    public void getTextFromProducts(){
        getProductsText ().getText ();
    }
    public void clickProductImage(){
        for (int i = 0; i < getProductImage ().size (); i++) {
            getProductImage ().get (i).click ();
        }
    }
    public void clickProductTitle(){
        for (int i = 0; i < getProductTitle ().size (); i++) {
            getProductTitle ().get (i).click ();
        }
    }
    public void getProductTitleText(){
        for (int i = 0; i < getProductTitle ().size (); i++) {
            getProductTitle ().get (i).getText ();
        }
    }
    public void clickProductAddToCartButton(){
        for (int i = 0; i < getProductAddToCartButton ().size (); i++) {
            getProductAddToCartButton ().get (i).click ();
        }
    }

    public void getProductPriceText(){
        for (int i = 0; i < getProductPrice ().size (); i++) {
            getProductPrice ().get (i).getText ();
        }
    }
    public void getProductDescriptionText(){
        for (int i = 0; i < getProductDescription ().size (); i++) {
            getProductDescription ().get (i).getText ();
        }
    }


}
