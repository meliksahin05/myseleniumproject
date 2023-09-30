package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumClass {

    public static void main(String[] args) {

        // Step 1. System.setproperty is used to instantiate the driver
        //System.setProperty("WHAT DRIVER", "WHERE IS IT");
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver"); //for mac
        //System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe"); //for windows

        //Step 2. Create chrome driver. This is the driver to connect the browsers

        WebDriver driver = new ChromeDriver();

        //Step 3. Now that we have our driver ready to use, we can start automation
        //Selenium is a bunch of methods and classes. When you type driver. gosterilen methodlar selenium driverdan geliyor
        //they are going to be used to automate web application

        driver.get("https://www.google.com");


    }
}
