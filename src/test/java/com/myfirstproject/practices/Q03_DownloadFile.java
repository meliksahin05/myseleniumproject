package com.myfirstproject.practices;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q03_DownloadFile extends TestBase {

    /*
Go to https://testpages.herokuapp.com/
Click on File Downloads
Click on Server Download
Verify that file is downloaded
*/

    @Test
    public void test () throws AWTException {

//       Go to https://testpages.herokuapp.com/
        driver.get("https://testpages.herokuapp.com/");

//        Click on File Downloads
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//a[@id='download']")).click();
//        Click on Server Download
        driver.findElement(By.xpath("//a[@id='server-download-a']")).click();
//        Verify that file is downloaded
        String path = System.getProperty("user.home")+"//Downloads/textfile.txt";
        waitFor(1);
//        Boolean isDowloanded = Files.exists(Paths.get(path));
          Boolean isDowloanded = Files.exists(Path.of(path));
          assertTrue(isDowloanded);



    }
}
