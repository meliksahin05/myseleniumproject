package practice;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day03_PracticeLocators extends TestBase {

    @Test
    public void practiceLocators() throws InterruptedException {

//        When user goes to : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        And enter username
        driver.findElement(By.name("username")).sendKeys("Admin");
//        and enter password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

//        click login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
//      Second way =  driver.findElement(By.tagName("button")).click();
        Thread.sleep(3000);

//        1)Dogru sayfada oldugumuzu anlamak icin iki yol vardir.
//             1.Using Url
        Assertions.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        Assertions.assertFalse(driver.getCurrentUrl().contains("auth"));
//              2.Locate the element which is in the dashboard
        WebElement imageDisplayed = driver.findElement(By.className("employee-image"));
        Assertions.assertTrue(imageDisplayed.isDisplayed());
        Assertions.assertTrue(driver.findElement(By.className("employee-image")).isDisplayed());

//        logout
        driver.findElement(By.className("oxd-userdropdown-tab")).click();
        driver.findElement(By.linkText("Logout")).click();

        Assertions.assertTrue(driver.getCurrentUrl().contains("auth"));

    }

}
