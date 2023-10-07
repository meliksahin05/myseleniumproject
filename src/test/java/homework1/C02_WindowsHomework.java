package homework1;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C02_WindowsHomework extends TestBase {

//    When Navigate to https://testpages.herokuapp.com/styled/windows-test.html
//    When Click on "Alerts In A New Window From JavaScript"
//    And Switch to new window
//    And Click on "Show alert box" button
//    And Accept alert
//    And Click on "Show confirm box" button
//    And Cancel alert
//    Then Assert that alert is canceled
//    When Click on "Show prompt box" button
//    And Send "Hello World!" to the alert
//    Then Assert that "Hello World!" is sent

    @Test
    public void mixHomework () throws InterruptedException {
//    When Navigate to https://testpages.herokuapp.com/styled/windows-test.html
        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");
//    When Click on "Alerts In A New Window From JavaScript"
        driver.findElement(By.linkText("Alerts In A New Window From JavaScript")).click();
//    And Switch to new window
      String firstWindow = driver.getWindowHandle();
        System.out.println("firstWindow = " + firstWindow);

        Set<String> allWindows = driver.getWindowHandles();
        for (String eachWindow:allWindows)
        { if (!eachWindow.equals(firstWindow)){
            driver.switchTo().window(eachWindow);
        }

        }
        System.out.println(driver.getWindowHandle());

        //    And Click on "Show alert box" button
        driver.findElement(By.id("alertexamples")).click();
        //    And Accept alert
        driver.switchTo().alert().accept();
        //    And Click on "Show confirm box" button
        driver.findElement(By.id("confirmexample")).click();
        //    And Cancel alert
        driver.switchTo().alert().dismiss();
        //    Then Assert that alert is canceled
        String canceledAssert = driver.findElement(By.xpath("//p[@id='confirmexplanation']")).getText();
        assertTrue(canceledAssert.contains("You clicked Cancel, confirm returned "));
        //    When Click on "Show prompt box" button
        driver.findElement(By.xpath("//input[@id='promptexample']")).click();
        //    And Send "Hello World!" to the alert
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Hello World!");
        driver.switchTo().alert().accept();
        //    Then Assert that "Hello World!" is sent
        String verifyHelloWorld = driver.findElement(By.xpath("//p[@id='promptreturn']")).getText();
        System.out.println("verifyHelloWorld = " + verifyHelloWorld);
        assertTrue(verifyHelloWorld.equals("Hello World!"));








    }












}
