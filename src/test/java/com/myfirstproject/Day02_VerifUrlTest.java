package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_VerifUrlTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current Url: " + currentUrl);

        if (currentUrl.equals("https://amazon.com/")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
            System.out.println("ACTUAL URL: " + currentUrl + "  but expected url is " + "https://www.amazon.com/");
        }
        driver.quit();
        
        /*
QUOTE OF THE DAY:
- Testers do not write a code to PASS
- We write a code to CATCH A BUG

- Our test case failed for this reason. FAIL : Actual URL https://www.amazon.com/ but expected URL is https://amazon.com/
as tester, I shouldn't fix the code to PASS.
STEPS:
-1.  Communicate with the Test Lead, Team Lead, or BA to check if that is a documentation issue.
If it is a documentation issue, BA should fix the AC, and then we should update our script.
-2. If it is an actual bug, then we should communicate with the team to see if a ticket should be raised
or a new story should be created,...
 */
    }
}
