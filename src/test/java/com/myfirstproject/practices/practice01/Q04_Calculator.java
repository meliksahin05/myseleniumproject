package com.myfirstproject.practices.practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q04_Calculator {
    /*
     Create chrome driver by using @BeforeEach annotation and WebDriverManager
     Navigate to  https://testpages.herokuapp.com/styled/index.html
     Click on  Calculator under Micro Apps
     Type any number in the first input
     Type any number in the second input
     Click on Calculate
     Get the result
     Verify the result
     Print the result
     Close the browser by using @AfterEach annotation
*/
    WebDriver driver;
    //    Create chrome driver by using @BeforeEach annotation and WebDriverManager
    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void test01(){
//        Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
//        Click on  Calculator under Micro Apps
        driver.findElement(By.linkText("Calculator")).click();
//        Type any number in the first input
        driver.findElement(By.xpath("//input[@id='number1']")).sendKeys("7");
//        Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("4");
//        Click on Calculate
        driver.findElement(By.id("calculate")).click();
//        Get the result
        String answer = driver.findElement(By.id("answer")).getText();
//        Verify the result
        assertEquals("11",answer);
//        Print the result
        System.out.println("answer = " + answer);
    }

    @Test
    public void divisionTest(){
//        Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
//        Click on  Calculator under Micro Apps
        driver.findElement(By.linkText("Calculator")).click();
//        Type any number in the first input
        driver.findElement(By.xpath("//input[@id='number1']")).sendKeys("8");
//        Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("4");
//         Select divide option
        WebElement functionDropDown = driver.findElement(By.id("function"));
        Select divide = new Select(functionDropDown);
//         divide.selectByVisibleText("divide");
//         divide.selectByIndex(3);
         divide.selectByValue("divide");



//        Click on Calculate
        driver.findElement(By.id("calculate")).click();
//        Get the result
        String answer = driver.findElement(By.id("answer")).getText();
//        Verify the result
        assertEquals("2",answer);
//        Print the result
        System.out.println("answer = " + answer);
    }


    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }








}
