package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Day10_RobotClass extends TestBase {

    @Test
    public void fileUploadTest() throws AWTException {

        //        Given user goes to https://www.grammarly.com/plagiarism-checker
        driver.get("https://www.grammarly.com/plagiarism-checker");

       driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
       waitFor(1);

        //Then click upload file
       driver.findElement(By.xpath("//div[@id='sectionGrammarCheck_4VB8kepvT7ciShVSz6rHX']//span[@class='iconWrapper_PbRSndwM']")).click();

       //Then select a document and upload that file
       String path = System.getProperty("user.home")+ "/Downloads/sampledoc.docx";

       //                          *****1.WAY*****
//       StringSelection stringSelection = new StringSelection(path);
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
//
//        //Robot Class
//        Robot robot = new Robot();
//
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        waitFor(1);
//
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        robot.keyRelease(KeyEvent.VK_V);
//        waitFor(1);
//
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//        waitFor(1);

        //                           ********2.WAY*******

        uploadFile(path);
    }
}
