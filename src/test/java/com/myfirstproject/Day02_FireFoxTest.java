package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day02_FireFoxTest {

    public static void main(String[] args) throws InterruptedException {

//        Create firefox driver
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
//        Open google home page https://www.amazon.com/
        driver.get("https://www.amazon.com/");
//        Maximize the window
        driver.manage().window().maximize();
//        add thread from java to keep wait some seconds
        Thread.sleep(5000);
//        Close/Quit the browser
        driver.quit();


    }
}
