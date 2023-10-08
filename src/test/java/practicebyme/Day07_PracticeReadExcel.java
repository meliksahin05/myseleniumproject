package practicebyme;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day07_PracticeReadExcel {

    //workbook>worksheet>row>cell
//        Open the workbook using fileinputstream
//        Open the first worksheet
//        Go to first row
//        Go to first cell on that first row and print
//        Go to second cell on that first row and print
//        Go to 2nd row first cell  and assert if the data equal to USA
//        Go to 3rd row 2nd cell-chain the row and cell
//        Find the number of row
//        Find the number of used row
//        HOMEWORK : Print country, capitol key value pairs as map object()

    @Test
    public void readExcel () throws InterruptedException {

        //workbook > worksheet > row > cell

//        Store the path of the  file in a string
        String path = "resources/Capitals.xlsx";

//        Open the file
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fileInputStream);

//        Open the first worksheet
            Sheet sheet1 = workbook.getSheetAt(0);//get first sheet by using index, index starts at 0
//            workbook.getSheet("Sheet1"); //get first sheet by using name

//        Go to first row
          Row row1 = sheet1.getRow(0); //index starts at 0

//        Go to first cell on that first row and print
          String r1c1 = row1.getCell(0).toString();
            System.out.println(r1c1);

//        Go to second cell on that first row and print
          String r1c2 = row1.getCell(1).toString();
            System.out.println("r1c2 = " + r1c2);

//        Go to 2nd row first cell  and assert if the data equal to USA
           String r2c1 = sheet1.getRow(1).getCell(0).toString();
            System.out.println("r2c1 = " + r2c1);
           assertTrue(r2c1.equals("USA"));

//        Go to 3rd row 2nd cell-chain the row and cell
          String r3c2 = sheet1.getRow(2).getCell(1).toString();
            System.out.println("r3c2 = " + r3c2);
            assertTrue(r3c2.equals("Paris"));

//        Find the number of row
          int totalNumberOfRow = sheet1.getLastRowNum()+1;
            System.out.println("totalNumberOfRow = " + totalNumberOfRow);

//        Find the number of used row
          int totalUsedRow = sheet1.getPhysicalNumberOfRows();
            System.out.println("totalUsedRow = " + totalUsedRow);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

      /*
       HOMEWORK : Print country, capitol key value pairs as map object()
        create a map
        then use a loop to add key value pains in the map
        use the pattern of indexes
        String countries = sheet1.getRow(row number).getCell(0).toString
        String capitals = sheet1.getRow(row number).getCell(1).toString
        add this to the map
        then print
        {greece = athens, Canada= Ottowa,...}
         */



    }
}
