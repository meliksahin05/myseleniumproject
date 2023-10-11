package com.myfirstproject.practices.practice04;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q01_MatchCaptcha extends TestBase {

/*
Go to https://form.jotform.com/73302671092956
Click on start
Enter firstname and lastname
Click on next
Enter email
Click on next
Enter message
Click on next
Handle captcha
Click on submit
Assert that submission is received
 */

    @Test
    public void test(){

//        Go to https://form.jotform.com/73302671092956
        driver.get("https://form.jotform.com/73302671092956");
//        Click on start
        driver.findElement(By.id("jfCard-welcome-start")).click();
//        Enter firstname and lastname
        driver.findElement(By.id("first_1")).sendKeys("Meliksah");
        driver.findElement(By.id("last_1")).sendKeys("Sahin");
//        Click on next
        driver.findElement(By.xpath("//button[@class='jfInput-button forNext u-right'][1]")).click();
//        Enter email
        driver.findElement(By.id("input_2")).sendKeys("walterwhite@gmail.com");
//        Click on next
        driver.findElement(By.xpath("(//button[@class='jfInput-button forNext u-right'])[2]")).click();
//        Enter message
        driver.findElement(By.xpath("//textarea[@id='input_3']")).sendKeys("Im not in danger, Im the danger");
//        Click on next
        driver.findElement(By.xpath("(//button[@class='jfInput-button forNext u-right'])[3]")).click();

        //There is an iframe so we need to switch to iframe as driver
        driver.switchTo().frame(0);
//        driver.switchTo().frame("customFieldFrame_4");


//        Handle captcha
          int number1 = Integer.parseInt(driver.findElement(By.id("number")).getText());
          int number2 = Integer.parseInt(driver.findElement(By.id("number2")).getText());
          String function = driver.findElement(By.id("function")).getText();
        WebElement resultInput = driver.findElement(By.name("equal"));
        int result;
        if (function.contains("+")){
            result = number1+number2;
        } else if (function.contains("-")) {
            result = number1-number2;

        }else{
            result = number1*number2;
        }
        resultInput.sendKeys(result+"");

        //back to parent frame or default content
        driver.switchTo().defaultContent();


//        Click on submit
        driver.findElement(By.xpath("(//button[@type='submit'])[4]")).click();
//        Assert that submission is received
        String submissionReceived = driver.findElement(By.xpath("//div[@aria-label='Your submission has been received!']")).getText();
        assertTrue(submissionReceived.equals("Your submission has been received!"));



    }


}

