package com.myfirstproject.practices.practice05;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.awt.event.KeyEvent;


public class Q05_ActionsClass extends TestBase {

    /*
 Given
     Go to https://www.facebook.com/
 When
     Click on "Create New Account"
 And
     Fill all the boxes by using keyboard actions class
  */

    @Test
    public void test(){

//        Go to https://www.facebook.com/
        driver.get("https://www.facebook.com/");
        waitFor(1);
        driver.findElement(By.xpath("(//button[@value='1'])[3]")).click();

//        Click on "Create New Account"
         Actions actions = new Actions(driver);
         
         actions
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.ENTER)
                 .pause(1000)//1 second wait
                 .sendKeys("John")
                 .sendKeys(Keys.TAB)
                 .sendKeys("Doe")
                 .sendKeys(Keys.TAB)
                 .sendKeys("1234")
                 .sendKeys(Keys.TAB)
                 .sendKeys("John.123")
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys("25")
                 .sendKeys(Keys.TAB)
                 .sendKeys("May")
                 .sendKeys(Keys.TAB)
                 .sendKeys("2000")
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.ARROW_RIGHT)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.ENTER)
                 .perform();




    }
}
