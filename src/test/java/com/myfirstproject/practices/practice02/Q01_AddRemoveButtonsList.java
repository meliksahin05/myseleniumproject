package com.myfirstproject.practices.practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Q01_AddRemoveButtonsList extends TestBase {

//Given
//    Go to http://the-internet.herokuapp.com/add_remove_elements/
//When
//    Click on the "Add Element" button 100 times
//And
//    Click on the "Delete" button 20 times
//Then
//    Assert that 20 buttons were deleted.

    @Test
    public void test(){

//        Go to http://the-internet.herokuapp.com/add_remove_elements/
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

//        Click on the "Add Element" button 100 times
        WebElement addElement = driver.findElement(By.xpath("//button[.='Add Element']"));
        for (int i = 0; i <100 ; i++) {
            addElement.click();
        }

//        Click on the "Delete" button 20 times
        List<WebElement> deleteButtons =driver.findElements(By.xpath("//button[@class='added-manually']"));
        System.out.println("Number of delete buttons before clicking delete = " + deleteButtons.size());
        for (int i = 0; i <20 ; i++) {
            deleteButtons.get(i).click();

        }
        List<WebElement> afterdeleteButtons = driver.findElements(By.xpath("//button[@class='added-manually']"));
        System.out.println("Number of delete buttons after clicking delete = " + afterdeleteButtons.size());
        //bir defa daha relocate yapman lazim kac adet delete buttons kaldigini gormek icin cunku bu bir array list kucultemezsin...

//         Assert that 20 buttons were deleted.
        assertEquals(afterdeleteButtons.size(),deleteButtons.size()-20);

        driver.close();


    }

}
