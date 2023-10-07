package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day07_WebTables extends TestBase {

//    https://the-internet.herokuapp.com/tables
//    Create a class: WebTables
//    Task 1 : Print the entire table
//    Task 2 : Print All Rows
//    Task 3 : Print Last row data only
//    Task 4 : Print column 5 data in the table body

    @Test
    public void webTables (){

        driver.get("https://the-internet.herokuapp.com/tables ");

        System.out.println("***Task 1 : Print the entire table***");
        String entireTable = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println(entireTable);
//        ALTERNATIVELY
        int dataNum=1;
        List<WebElement> elementsList = driver.findElements(By.xpath("//table[@id='table1']//td"));
        for (WebElement eachElement : elementsList){
            System.out.println("Data "+dataNum+" => "+eachElement.getText());
            dataNum++;
        }
//        Assert if the last element in the table 1 is "edit delete"
        Assertions.assertTrue(elementsList.get( elementsList.size()-1 ).getText().equals("edit delete"));


        System.out.println("***Task 2 : Print All Rows***");
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        int rowNum = 1;
        for (WebElement eachRow : allRows){
            System.out.println("Row "+rowNum+" => "+eachRow.getText());
            rowNum++;
        }

        System.out.println("***Task 3 : Print Last row data only***");
        System.out.println("Last row : "+allRows.get(allRows.size()-1).getText());

        System.out.println("***Task 4 : Print column 5 data in the table body***");
        List<WebElement> col5 = driver.findElements(By.xpath("//table[@id='table1']//tr//td[5]"));
        int colNum=1;
        for (WebElement each : col5){
            System.out.println("Row "+colNum+" => "+each.getText());
            colNum++;
        }










    }
}
