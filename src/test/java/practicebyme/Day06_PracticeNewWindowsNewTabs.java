package practicebyme;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day06_PracticeNewWindowsNewTabs extends TestBase {


//    Open the pages in 2 new windows and verify their TITLES
//    Linkedin
//    Ebay

    @Test
    public void newWindows() {
        driver.get("https://www.linkedin.com/home");
        String linkedinHandle = driver.getWindowHandle();
        System.out.println("linkedinHandle = " + linkedinHandle);
        String linkedinTitle = driver.getTitle();
        assertTrue(linkedinTitle.contains("Oturum"));

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.ebay.com/");
        String ebayHandle = driver.getWindowHandle();
        System.out.println("ebayHandle = " + ebayHandle);
        String ebayTitle = driver.getTitle();
        assertTrue(ebayTitle.contains("Cars"));

        driver.switchTo().window(linkedinHandle);
        driver.switchTo().window(ebayHandle);
        System.out.println("Ebay URL " + driver.getCurrentUrl());


    }

    @Test
    public void newWindowTabTest() throws InterruptedException {
//        Open the pages in 2 new tabs and verify their TITLES
//        Linkedin
        driver.get("https://www.linkedin.com/");
        String linkedinTab = driver.getWindowHandle();
        System.out.println("linkedinTab = " + linkedinTab);
        assertTrue(driver.getTitle().contains("Oturum"));
       Thread.sleep(3000);

//        Ebay
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.ebay.com/");
        String eBayTab = driver.getWindowHandle();
        System.out.println("eBayTab = " + eBayTab);
        assertTrue(driver.getTitle().contains("Cars"));
        Thread.sleep(3000);

        driver.switchTo().window(linkedinTab);
        driver.switchTo().window(eBayTab);
        driver.switchTo().window(linkedinTab);

    }
}

