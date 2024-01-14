package com.myfirstproject.interviewBootcampJanuary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_BasicNavigations {

           /* Test Case Steps:
        Create a new class under : BasicNavigations
        Create main method
        Set Path
        Create chrome driveR
        */
           public static void main(String[] args) {

               WebDriverManager.chromedriver().setup();
               WebDriver driver = new ChromeDriver();
               driver.manage().window().maximize();
               driver.get("https://www.google.com/?client=safari");

           }

}
