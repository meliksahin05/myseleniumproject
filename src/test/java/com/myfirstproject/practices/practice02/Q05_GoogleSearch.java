package com.myfirstproject.practices.practice02;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q05_GoogleSearch  {
  /*
     Create driver and go to http://www.google.com in the BeforeEach method
     With 3 different test methods:
      -Type "Desktop" in the search box and search it
      -Type "Smartphone" in the search box and search it
      -Type "Laptop" in the search box and search it
     NOTE: Print the result numbers in AfterEach method
     Close driver with AfterEach method
      */

    // Create driver and go to http://www.google.com in the BeforeEach method
    WebDriver driver;
    @BeforeEach
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//div[@class='QS5gu sy4vM']")).click();
        Thread.sleep(3000);
    }


    //-Type "Desktop" in the search box and print the number of results
    @Test
    public void test1(){

        driver.findElement(By.name("q")).sendKeys("Desktop", Keys.ENTER);

    }

    //-Type "Smartphone" in the search box and search it
    @Test
    public void test2(){
        driver.findElement(By.name("q")).sendKeys("Smartphone", Keys.ENTER);
    }


    // -Type "Laptop" in the search box and search it
    @Test
    public void test3(){
        driver.findElement(By.name("q")).sendKeys("Laptop", Keys.ENTER);
    }

    @AfterEach
    public void afterMethod(){
        //Print the result numbers in AfterEach method
        String result = driver.findElement(By.id("result-stats")).getText();
        System.out.println("result = " + result);
        String numOfResults =  result.split(" ")[1];
        System.out.println("numOfResults = " + numOfResults);
        driver.quit();
    }

}