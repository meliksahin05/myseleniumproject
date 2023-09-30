package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

       /* Test Case Steps:
        Create a new class under : BasicNavigations
        Create main method
        Set Path
        Create chrome driveR
        */

        //        Create chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //        Maximize the window
//        Maximize the window
         driver.manage().window().maximize();
//        Open google home page https://www.walmart.com/.
        driver.get("https://www.walmart.com/");

//       WAIT FOR FIVE SECONDS AT THIS STEP
        Thread.sleep(5000);
//        On the same class, Navigate to amazon home page https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");
//        WAIT FOR FIVE SECONDS AT THIS STEP
        Thread.sleep(5000);
//        Navigate back to google
        driver.navigate().back();
//        Navigate forward to amazon
        driver.navigate().forward();
//        Refresh the page
        driver.navigate().refresh();
//        Close/Quit the browser
        driver.quit(); // this is the strongest one
        //driver.close();

           /*
        1. How do you go to a page in selenium?
        -get or navigate to method. get is more common
        2. What is the difference between get and navigate methods?
        -both are used to go to a page
        -get is shorter than navigate to
        -navigate has to, back, forward, refresh methods as well
        -get accepts only string, but navigate to accepts string or URL
        3. What is the difference between close and quit in selenium?
        -close closed only last active window, but quit closes all open window
        4. What is Thread.sleep
        -it is a JAVA wait. this is HARD WAIT. This is not Selenium wait.
         */

    }
}
