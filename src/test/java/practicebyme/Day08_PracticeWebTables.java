package practicebyme;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Day08_PracticeWebTables extends TestBase {

//    https://the-internet.herokuapp.com/tables
//    Create a class: WebTables
//    Task 1 : Print the entire table
//    Task 2 : Print All Rows
//    Task 3 : Print Last row data only
//    Task 4 : Print column 5 data in the table body
//    HOMEWORK : Task 5 : Write a method that accepts 2 parameters
//    Parameter 1 = row number
//    Parameter 2 = column number
//    printData(2,3); => prints data in 2nd row 3rd column
    @Test
    public void webTables (){

//    Task 1 : Print the entire table
        driver.get("https://the-internet.herokuapp.com/tables");

        //First way to reach and print the entire table
        System.out.println("***ENTIRE TABLE***");
        String entireTable = driver.findElement(By.id("table1")).getText();
        System.out.println("entireTable = " + entireTable);

        //Second way(alternatively way to reach and print the entire table BY USING LIST
        System.out.println("***ALL DATA IN THE TABLE****");
        int dataNumber = 1;
        List<WebElement> allTable = driver.findElements(By.xpath("//table[@id='table1']//td"));
        for (WebElement eachData:allTable) {
            System.out.println("DATA NUMBER " + dataNumber+ " " + eachData.getText());
            dataNumber ++;
        }

//    Task 2 : Print All Rows
        System.out.println("***ALL ROWS***");
        int rowNumber = 1;
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        for (WebElement eachRow:allRows) {
            System.out.println("Row Number " + rowNumber + "=" + eachRow.getText());
            rowNumber ++;

        }

//    Task 3 : Print Last row data only
        System.out.println("***DATAS IN THE LAST ROW***");
        System.out.println(allRows.get(allRows.size()-1).getText());


//    Task 4 : Print column 5 data in the table body
        System.out.println("***DATAS IN COLUMN 5***");
        List<WebElement> Alldatacolumn5 = driver.findElements(By.xpath("//table[@id='table1']//tr//td[5]"));
        int rowNum = 1;
        for (WebElement eachcolumn: Alldatacolumn5) {
            System.out.println("Row Number " + rowNum + ":" + eachcolumn.getText());
            rowNum ++;

        }
        System.out.println("***Task 4 : Print column 5 data in the table body***");
        List<WebElement> col5 = driver.findElements(By.xpath("//table[@id='table1']//tr//td[5]"));
        int colNum=1;
        for (WebElement each : col5){
            System.out.println("Row "+colNum+" => "+each.getText());
            colNum++;
        }

        printData(2,3);

    }
    //    HOMEWORK : Task 5 : Write a method that accepts 2 parameters
//    Parameter 1 = row number
//    Parameter 2 = column number
//    printData(2,3); => prints data in 2nd row 3rd column
    public void printData (int rowNumber, int columnNumber){
        List<WebElement> DatasInTheTable = driver.findElements(By.xpath("//table[@id='table1']//tr["+rowNumber+"]//td["+columnNumber+"]"));
        for (WebElement eachData:DatasInTheTable) {
            System.out.println("Data Number "  + eachData.getText());

        }
    }

}
