package Ponedeljak12_06.Practice.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SidebarPage {

    public WebDriver driver;

    WebElement homeButton;
    WebElement practiceButton;
    WebElement blogButton;
    WebElement coursesButton;
    WebElement contactButton;

    public WebElement getHomeButton() {
        return driver.findElement (By.id ("menu-item-43"));
    }

    public WebElement getPracticeButton() {
        return driver.findElement (By.id ("menu-item-20"));
    }

    public WebElement getBlogButton() {
        return driver.findElement (By.id ("menu-item-19"));
    }

    public WebElement getCoursesButton() {
        return driver.findElement (By.id ("menu-item-21"));

    }

    public WebElement getContactButton() {
        return driver.findElement (By.id ("menu-item-18"));
    }

    public SidebarPage(WebDriver driver) {
        this.driver = driver;
    }

   //------------------------------------------

   public void clickOnHome(){
        getHomeButton ().click ();
   }

   public void clickOnPractice(){
        getPracticeButton ().click ();
    }

    public void clickOnBlog(){
        getBlogButton ().click ();
    }

    public void clickOnContact(){
        getContactButton ().click ();
    }

    public void clickOnCourses(){
        getCoursesButton ().click ();
    }
}
