package com.myfirstproject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day03_xpath_css {

    WebDriver driver;
    @BeforeEach//runs before each test method
    public void setUp(){
        driver = new ChromeDriver();//creating driver
        driver.manage().window().maximize();//maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//implicit wait
    }

    @Test
    public void xpath_css (){
        //When user goes to : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
       //And enter username
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("admin");
        //And enter password
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("admin123");
       //And click on submit button===>>  driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Css selector kullanarak eleman bulma uc yolu var
        // 1) .cssSelector = tag[attribute='value']         input[name='session_password']
        // 2) .cssSelector = tag#id value or #id value     #=id nin yerini tutar    input#session_password or #session_password
        // 3) .cssSelector = tag.class value      for example: input.form-control or .form-control
       WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
       loginButton.click();
       //Assert login is succesfull
        Assertions.assertTrue(driver.getCurrentUrl().contains("dashboard"));

    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
