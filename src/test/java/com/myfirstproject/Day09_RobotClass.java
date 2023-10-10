package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Day09_RobotClass extends TestBase {


         @Test
         public void fileUploadTest() throws AWTException {
             driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html ");
             String pathOfFlower = System.getProperty("user.home") + "/Desktop/flower.jpeg";
//        ROBOT CLASS
             StringSelection ss = new StringSelection(pathOfFlower);
             Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
             Robot robot = new Robot();
//        pressing control V
             robot.keyPress(KeyEvent.VK_CONTROL);
             robot.keyPress(KeyEvent.VK_V);
//        release
             robot.keyRelease(KeyEvent.VK_CONTROL);
             robot.keyRelease(KeyEvent.VK_V);
//        click enter
             robot.keyPress(KeyEvent.VK_ENTER);
//        release enter
             robot.keyRelease(KeyEvent.VK_ENTER);
             waitFor(3);

//       file upload is done. then click upload button and do assertion
             driver.findElement(By.xpath("//input[@type='submit']")).click();
//        Then verify the ‘You uploaded a file. This is the result.’  Message displayed
             Assertions.assertEquals(
                     "flower.jpeg",
                     driver.findElement(By.id("uploadedfilename")).getText(),
                     "File upload is not successful : Actual file name is not flower.jpeg"
             );
//       Alternatively
//             Assertions.assertEquals(
//                     "You uploaded a file. This is the result.",
//                     driver.findElement(By.xpath("//div[@class='explanation']//p")).getText(),
//                     "Upload is failed!!!"
//             );
//         }

         }
}
