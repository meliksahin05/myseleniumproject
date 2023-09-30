package practice;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day04_CheckboxPractice extends TestBase {

    @Test
    public void practiceCheckBox(){

//        Go to https://testcenter.techproeducation.com/index.php?page=checkboxes
        driver.get("https://testcenter.techproeducation.com/index.php?page=checkboxes");
//        Locate the elements of checkboxes
        WebElement checkbox1 = driver.findElement(By.id("box1"));
//        Then click on checkbox1 if box is not selected
        if (!checkbox1.isSelected()){
            checkbox1.click();
        }
//        Then click on checkbox2 if box is not selected
        WebElement checkbox2 = driver.findElement(By.name("checkbox2"));
        if (!checkbox2.isSelected()){
            checkbox2.click();
        }
//        Then verify that checkbox1 is checked.
        Assertions.assertTrue(checkbox1.isSelected());

    }
}
