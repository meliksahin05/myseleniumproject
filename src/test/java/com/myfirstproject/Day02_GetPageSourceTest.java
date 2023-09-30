package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_GetPageSourceTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        TEST CASE:
//        Test if amazon contains “Registry” on the homepage
        driver.get("https://www.amazon.com");
        String pageSource = driver.getPageSource(); //returns the current source code on the page
        System.out.println(pageSource);

        if (pageSource.contains("Registry")){
            System.out.println("PASSED");
        }else{
            System.out.println("Fail egistry is not exists on the page...");
        }
        driver.quit();

    }
}
