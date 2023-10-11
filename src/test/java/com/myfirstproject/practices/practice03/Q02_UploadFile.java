package com.myfirstproject.practices.practice03;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q02_UploadFile extends TestBase {
/*
    Given
        Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
    When
       Type "My File" into "Notes about the file" input
    And
        Click "Choose File" button
    And
        Select the file to upload
    And
        Click on "Press" button
    Then
        Assert that "Your notes on the file were" equals "My File"
    And
        Assert that file Content contains "Hello, I am uploaded file"
*/

    @Test
    public void test(){

//        Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

//        Type "My File" into "Notes about the file" input
        driver.findElement(By.name("note")).sendKeys("My File");

//        Click "Choose File" button
        WebElement chooseFile = driver.findElement(By.name("upfile"));
        String path = System.getProperty("user.home")+"//Desktop/flower.jpeg";
        chooseFile.sendKeys(path);

//        Click on "Press" button
        Actions actions = new Actions(driver);
        WebElement clickPress = driver.findElement(By.xpath("//input[@value='Press']"));
        actions.click(clickPress).perform();

//        Assert that "Your notes on the file were" equals "My File"
         String note = driver.findElement(By.xpath("//blockquote")).getText();
          assertEquals("My File",note);

    }
}
