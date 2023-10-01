package com.myfirstproject.practices.practice01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q01_Navigate {
/*
     Set Driver Path
     Create chrome driver object
     Maximize the window
     Open google home page https://www.google.com/
     Navigate to techproeducation home page https://techproeducation.com/
     Navigate back to google
     Navigate forward to techproeducation
     Refresh the page
     Close/Quit the browser
     And last step : print "ALL OK" on console
*/
public static void main(String[] args) throws InterruptedException {
//    Set Driver Path
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
//    Create chrome driver object
    WebDriver driver = new ChromeDriver();
//    Maximize the window
    driver.manage().window().maximize();
//    Open google home page https://www.google.com/
    driver.get("https://www.google.com/");
//    driver.navigate().to("https://www.google.com/");
//    Navigate to techproeducation home page https://techproeducation.com/
      driver.navigate().to("https://techproeducation.com/");
//    Navigate back to google
      driver.navigate().back();
      Thread.sleep(2000);//To see the flow we use wait.
//    Navigate forward to techproeducation
      driver.navigate().forward();
      Thread.sleep(2000);//To see the flow we use wait.
//    Refresh the page
      Thread.sleep(2000);//To see the flow we use wait.
      driver.navigate().refresh();
//    Close/Quit the browser
      Thread.sleep(2000);//To see the flow we use wait.
      driver.close();
//      driver.quit();
//    And last step : print "ALL OK" on console
    System.out.println("ALL OK ");
}






}
