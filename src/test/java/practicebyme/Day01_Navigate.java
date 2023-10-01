package practicebyme;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_Navigate {

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
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
//    Create chrome driver object
//        ChromeDriver drive = new ChromeDriver();
        WebDriver driver = new ChromeDriver();
//    Maximize the window
        driver.manage().window().maximize();
//    Open google home page https://www.google.com/
        driver.get("https://www.google.com/");
        Thread.sleep(3000);
//    Navigate to techproeducation home page https://techproeducation.com/
        driver.navigate().to("https://techproeducation.com/");
        Thread.sleep(3000);
//    Navigate back to google
        driver.navigate().back();
        Thread.sleep(3000);
//    Navigate forward to techproeducation
        driver.navigate().forward();
        Thread.sleep(3000);
//    Refresh the page
        driver.navigate().refresh();
//    Close/Quit the browser
        driver.close();
//    And last step : print "ALL OK" on console
        System.out.println("ALL OK");


    }
}
