package com.myfirstproject;

import com.github.dockerjava.api.model.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_VerifyTitleTest  {
    public static void main(String[] args) {

        // WebDriverManager.chromedriver().setup(); //NO NEED TO USE THAT ANYMORE BECAUSE OF THE ADVANCEMENT IN SELENIUM
        WebDriver driver = new ChromeDriver();
        //        Make it full screen
        driver.manage().window().maximize();
//        Navigate to amazon homepage
        driver.get("https://www.amazon.com");
//        Verify if page title contains “Amazon”
        String actualTitle = driver.getTitle(); //returns the page title as String

        if (actualTitle.contains("Amazon")){
            System.out.println("PASSED");
        }else{
            System.out.println("Fails");
            System.out.println("Actual Title: " + actualTitle + "doesn't contain expected title : Amazon");
        }
        driver.quit();


    }
}
