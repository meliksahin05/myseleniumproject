package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day05_Alerts extends TestBase {

    //    Go to https://testcenter.techproeducation.com/index.php?page=javascript-alerts
//    Create a class: AlertTest
//    Create 3 test methods:
//    acceptAlert() => click on the first alert,
//    verify the text “I am a JS Alert” ,
//    click OK ,
//    and Verify “You successfully clicked an alert”
//
//    dismissAlert()=> click on the second alert,
//    verify text "I am a JS Confirm”,
//    click cancel,
//    and Verify “You clicked: Cancel”
//
//    sendKeysAlert()=> click on the third alert,
//    verify text “I am a JS prompt”,
//    type “Hello World”,
//    click OK,
//    and Verify “You entered: Hello World”

    @Test
    public void acceptAlert() {
//    Go to https://testcenter.techproeducation.com/index.php?page=javascript-alerts
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//    acceptAlert() => click on the first alert,
        driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
//    verify the text “I am a JS Alert” ,
        String verifyAllert = driver.switchTo().alert().getText();
        assertTrue(verifyAllert.equals("I am a JS Alert"));
//    click OK ,
        driver.switchTo().alert().accept();
//    and Verify “You successfully clicked an alert”
        String verifySuccessfullMessage = driver.findElement(By.id("result")).getText();
        assertTrue(verifySuccessfullMessage.equals("You successfully clicked an alert"));

    }

    @Test
    public void dismissAlert() {
//    Go to https://testcenter.techproeducation.com/index.php?page=javascript-alerts
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//    dismissAlert()=> click on the second alert,
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
//      verify text "I am a JS Confirm”,,
        String verifyAllert = driver.switchTo().alert().getText();
        assertTrue(verifyAllert.equals("I am a JS Confirm"));
////    click Cancel ,
        driver.switchTo().alert().dismiss();
//    and Verify “You clicked: Cancel”
       String verifyCancelMessage = driver.findElement(By.id("result")).getText();
        assertTrue(verifyCancelMessage.equals("You clicked: Cancel "));

    }

    @Test
    public void sendKeysAlert() {
//    Go to https://testcenter.techproeducation.com/index.php?page=javascript-alerts
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//    sendKeysAlert()=> click on the third alert,
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
////      verify text "I am a JS Confirm”,,
          String verifyAllert = driver.switchTo().alert().getText();
          assertTrue(verifyAllert.equals("I am a JS prompt"));
//    type “Hello World”,
          driver.switchTo().alert().sendKeys("Hello world");
//          click ok
          driver.switchTo().alert().accept();
//    and Verify “You entered: Hello World”
        String verifyEnteredText = driver.findElement(By.id("result")).getText();
        assertTrue(verifyEnteredText.equals("You entered: Hello world"));

    }
}
