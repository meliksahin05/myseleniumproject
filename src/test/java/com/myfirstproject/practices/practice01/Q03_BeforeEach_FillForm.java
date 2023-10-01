package com.myfirstproject.practices.practice01;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q03_BeforeEach_FillForm {
/*
     Create chrome driver by using @BeforeEach annotation and WebDriverManager
     Go to url : http://www.gmibank.com/
     Click on 'User Icon'
     Click on 'Register'
     Enter SSN
     Enter First Name
     Enter Last Name
     Enter Address
     Enter Phone Number
     Enter Username
     Enter Email
     Enter New password
     Enter New password confirmation
     Click on Register button
     Assert that user registered
     Close the browser by using @AfterEach annotation
*/
    WebDriver driver; //Bu containeri olusturman lazim method disinda class icinde
                     // cunku her annotation veya methodda  da kullanmak icin
//   Create chrome driver by using @BeforeEach annotation and WebDriverManager
     @BeforeEach
    public void setUp(){
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     }

     @Test
     public void Test01() throws InterruptedException {
//         Go to url : http://www.gmibank.com/
           driver.get("http://www.gmibank.com/");
//         Click on 'User Icon'
           WebElement userIcon = driver.findElement(By.id("account-menu"));
           userIcon.click();
//         Click on 'Register'
           driver.findElement(By.linkText("Register")).click();
//         Enter SSN
           driver.findElement(By.xpath("//input[@name='ssn']")).sendKeys("234-54-" + Faker.instance().number().numberBetween(1000,9999));
//         Enter First Name
           driver.findElement(By.name("firstname")).sendKeys("Walter");
//         Enter Last Name
           driver.findElement(By.name("lastname")).sendKeys("White");
//         Enter Address
           driver.findElement(By.xpath("//input[@name='address']")).sendKeys("Istanbul");
//         Enter Phone Number
           driver.findElement(By.name("mobilephone")).sendKeys("1234567890");
//         Enter Username
           driver.findElement(By.cssSelector("#username")).sendKeys("heisenberg");
//         Enter Email
           driver.findElement(By.name("email")).sendKeys("walter_white77@gmail.com");
//         Enter New password
           driver.findElement(By.id("firstPassword")).sendKeys("Walter_white20");
//         Enter New password confirmation
           driver.findElement(By.id("secondPassword")).sendKeys("Walter_white20");
//         Click on Register button
           driver.findElement(By.xpath("//button[@id='register-submit']")).click();
//         Assert that user registered
         Thread.sleep(1000);
           String successfullMessage = driver.findElement(By.xpath("(//div[@role='alert'])[1]")).getText();
           assertTrue(successfullMessage.contains("Registration saved!"));

//         Close the browser by using @AfterEach annotation
     }
//         Close the browser by using @AfterEach annotation
           @AfterEach
           public void tearDown() throws InterruptedException {
         Thread.sleep(3000);
              driver.close();
           }




}
