package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day08_Actions2 extends TestBase {

    @Test
    public void actions2Test (){

//        Create a class: Action2
//        Create a method dragAndDropTest
//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
//        And user moves the target element(Drag me to my target) in to destination(Drop here)
        driver.switchTo().frame(0);
//        switchIframeByIndex(0);
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(source, target).perform();

    }
    @Test
    public void actions3Test () throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");
        switchIframeByIndex(0);
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Thread.sleep(1000);

        actions.clickAndHold(source).moveToElement(target).release().build().perform();
//        actions.dragAndDropBy(source, 168,40).perform(); 2. way to make draganddrop
  

    }


}
    /*
actions.dragAndDrop(source,target).perform(); moving the source element on the target element
 */