package com.myfirstproject.practices.practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q02_DragAndDrop extends TestBase {


//  Given
//      Go to https://demo.guru99.com/test/drag_drop.html
//  When
//      Drag orange elements on proper boxes below
//  Then
//      Verify they are dropped.

    @Test
    public void test() throws InterruptedException {

//        Go to https://demo.guru99.com/test/drag_drop.html
        driver.get("https://demo.guru99.com/test/drag_drop.html");

        Thread.sleep(3000);
//        Drag orange elements on proper boxes below
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='faktor-iframe-wrapper']")));
        Thread.sleep(3000);
        WebElement kabulEtme = driver.findElement(By.xpath("(//div[@class='action-wrapper'])[3]"));
        kabulEtme.click();
        Thread.sleep(3000);

        driver.switchTo().defaultContent();


        //Locate source elements
        WebElement amount1 = driver.findElement(By.xpath("(//li[@id='fourth'])[1]"));
        WebElement amount2 = driver.findElement(By.xpath("(//li[@id='fourth'])[2]"));
        WebElement bank = driver.findElement(By.id("credit2"));
        WebElement sales = driver.findElement(By.id("credit1"));

        //Locate target elements
        WebElement debitAccount = driver.findElement(By.id("bank"));
        WebElement debitAmount = driver.findElement(By.id("amt7"));
        WebElement creditAccount = driver.findElement(By.id("loan"));
        WebElement creditAmount = driver.findElement(By.id("amt8"));
//        Verify they are dropped
          Actions actions = new Actions(driver);


        actions.pause(1000)
                .dragAndDrop(amount1, debitAmount).pause(1000)
                .dragAndDrop(amount2, creditAmount).pause(1000)
                .dragAndDrop(bank, debitAccount).pause(1000)
                .dragAndDrop(sales, creditAccount)
                .perform();


        WebElement perfect = driver.findElement(By.xpath("(//div[@id='equal'])[1]"));
        assertTrue(perfect.isDisplayed());




        Thread.sleep(3000);
//        driver.close();
    }

}
