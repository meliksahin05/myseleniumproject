package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day08_Actions extends TestBase {

//    Create a class: Actions1
//    Create test method : actions1Test() and test the following scenario:
//    Given user is on the https://www.amazon.com/
//    When use click on “Account” link
//    Then verify the page title contains “Your Account”
//    Then scroll to Amazon Music element at the bottom of the page
//    And click on it
//    Then verify Amazon Music page is displayed
//    Scroll the page up and down
    @Test
    public void action1Test () throws InterruptedException {

//    Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        Thread.sleep(1000);
        driver.navigate().refresh();

        //1. Create actions objects
        Actions actions = new Actions(driver);

        //2.Locating the element that I want to hover over
        WebElement accountListTab = driver.findElement(By.id("nav-link-accountList"));

//        2. use moveToElement function to hover over to the element. make sure use perform() at the end
        actions.moveToElement(accountListTab).perform();
        Thread.sleep(1000);

//    When use click on “Account” link
        WebElement accountLink = driver.findElement(By.linkText("Account"));
//        accountLink.click(); //no need the actions. This is more common But alternatively i can use actions to click
        actions.click(accountLink).perform();

//    Then verify the page title contains “Your Account”
        assertTrue(driver.getTitle().contains("Your Account"));

//    Then scroll to Amazon Music element at the bottom of the page

        WebElement amazonMusic = driver.findElement(By.xpath("//a[text()='Amazon Music'] "));

        actions.moveToElement(amazonMusic).perform();
        Thread.sleep(1000);
//        actions.click(amazonMusic).perform();
        amazonMusic.click();
        Thread.sleep(3000);

//    Then verify Amazon Music page is displayed
        assertTrue(driver.getCurrentUrl().contains("music"));

//    Scroll the page up and down

        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_LEFT).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_RIGHT).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_UP).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.ARROW_RIGHT).build().perform();

        /*
Actions is used to perform mouse and keyboard action
We need to create an Actions object to perform action
Then use the appropriate function to perform mouse or keyboard events
Make sure to use perform() at the end
actions.moveToElement(amazonMusic).perform();-> hover over the element
actions.sendKeys(Keys.PAGE_DOWN).perform(); //scrolling down
actions.sendKeys(Keys.PAGE_UP).perform();//scrolling up
actions.sendKeys(Keys.ARROW_DOWN).perform();//scrolling down
actions.sendKeys(Keys.ARROW_UP).perform();//scrolling up
Difference between Arrow and Page is Arrow scrolls less than Page
We can use multiple actions function : actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
build() is not mandatory but it ir recommended to use when there is method chain
 */


    }
}
