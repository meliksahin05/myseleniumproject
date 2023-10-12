package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day11_CaptureScreenshotOfElements extends TestBase {

    @Test
    public void captureScreenshotOfElements(){

        driver.get("https://www.google.com/");

        WebElement cerez = waitForVisibility(driver.findElement(By.xpath("//div[@class='QS5gu sy4vM']")),15);
        cerez.click();
        captureScreenshotOfElement(driver.findElement(By.xpath("//img[@class='lnXdpd']")));

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("iphone 15 prices");
        captureScreenshotOfElement(searchBox);
    }

}
