package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.List;

public class Day04_Dropdown extends TestBase {
    /*
-How to select from a dropdown???
3 ways to select a dropdown option: index, value, visibleText,
-How to get selected option from a dropdown?
getFirstSelectedOption method

 */

    @Test
    public void dropDownTest() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
//        2000 February 15
//        1. locate the dropdown element
        WebElement year = driver.findElement(By.id("year"));
//        2. create a select object
        Select selectYear = new Select(year);
//        3.now that we have an object, we can interact with this dropdown element
        selectYear.selectByVisibleText("2000");
        Thread.sleep(3000);


//        months
        WebElement month = driver.findElement(By.id("month"));
        Select selectMonths = new Select(month);
        selectMonths.selectByIndex(1);
        Thread.sleep(3000);

//        Gun
        WebElement day = driver.findElement(By.id("day"));
        Select selectDay = new Select(day);
        selectDay.selectByValue("15");
        Thread.sleep(3000);

//      Assert if 2000 is selected
        WebElement selectedYear = selectYear.getFirstSelectedOption();//getting the selected options
        System.out.println(selectedYear.getText());//getting the text of the selected year
        Assertions.assertTrue(selectedYear.getText().equals("2000"));//asserting if selected test is as expected


//      get all the months and assert if April is an option in the month dropdown
        List<WebElement> allMonths = selectMonths.getOptions();
        boolean isAprilExist = false;
        for (WebElement eachMonth : allMonths) {
            System.out.println(eachMonth.getText());
            if (eachMonth.getText().equals("April")) {
                isAprilExist = true;
            }
        }
        Assertions.assertTrue(isAprilExist);
    }

    @Test
    public void stateTest() throws InterruptedException {
        /*   https://testcenter.techproeducation.com/index.php?page=dropdown
            Create a new test method : statesTest in this class
            Then print the total number of states from the dropdown
            Then print all the state names
            Select 'Texas' opting using one of the method
            Assert if Texas is selected or not
            Then check is the state names are in  alphabetical order(THIS WILL FAIL B/C STATE LIST IS NOT IN ALPHABETICAL ORDER)
         */
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
//      1. locate the dropdown element
        WebElement state = driver.findElement(By.id("state"));
//      2. create a select object
        Select selectState = new Select(state);

//      3.now that we have an object, we can interact with this dropdown element
//        Then print the total number of states from the dropdown

        int totalNumberOfStates = selectState.getOptions().size();
        System.out.println(totalNumberOfStates);

//        Then print all the state names
        List<WebElement> allStates = selectState.getOptions();
        for (WebElement eachStates : allStates) {
            System.out.println(eachStates.getText());
        }
        Thread.sleep(3000);
//        Select 'Texas' opting using one of the method
          selectState.selectByVisibleText("Texas");

//        Assert if Texas is selected or not
          WebElement selectedState = selectState.getFirstSelectedOption();
//         System.out.println(selectedState.getText().equals("Texas"));

//        Assert if Texas is selected or not
          Assertions.assertTrue(selectedState.getText().equals("Texas"));

//        Then check is the state names are in  alphabetical order(THIS WILL FAIL B/C STATE LIST IS NOT IN ALPHABETICAL ORDER)
        List<WebElement> checkAllStates = selectState.getOptions();
        for (WebElement eachStates : checkAllStates) {
            checkAllStates.add(eachStates);

        }



    }

}





