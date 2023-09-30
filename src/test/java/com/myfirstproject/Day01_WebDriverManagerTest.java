package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_WebDriverManagerTest {

    public static void main(String[] args) {

        /*
         add webDriverManager dependency in pom.xml :https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager
         get the latest version
         we add dependecy to use driver test it
         THIS DEPENDENCY IS USED TO INSTANTIATE THE DRIVER
         */

        // 1. WebDriverManger is used to instantiate the drivers
        WebDriverManager.chromedriver().setup(); //which driver will be used
//        WebDriverManager.edgedriver().setup();
//        WebDriverManager.firefoxdriver().setup();



        //2. Step Create the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // 3. step now that we have our driver ready to use, we can start automation

        driver.get("https://www.google.com");



    }
}
