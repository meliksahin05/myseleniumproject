package homework1;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class C02_HomeworkSecondTask extends TestBase {

//    Task2:
//    Go to https://testcenter.techproeducation.com/index.php?page=dropdown
//            1.Create method selectByIndexTest and Select Option 1 using index from Simple dropdown
//2.Create method selectByValueTest Select Option 2 by value from Simple dropdown
//3.Create method selectByVisibleTextTest Select Option 1 value by visible text from Simple dropdown
//4.Create method printAllTest
//    Print all dropdown elements from State selection dropdown,
//    and print the size of  State selection dropdown
//    and Verify State selection dropdown dropdown contains Texas text
//5. Create method printFirstSelectedOptionTest Print first selected option of State selection dropdown

    @Test
    public void homeworkSecondTask(){

//        Go to https://testcenter.techproeducation.com/index.php?page=dropdown

//       Create method selectByIndexTest and Select Option 1 using index from Simple dropdown

         WebElement selectOption1 = driver.findElement(By.xpath("//select[@id='dropdown']"));
         Select select = new Select(selectOption1);
         select.selectByIndex(1);


        driver.get("url_of_your_webpage");

        // selectByIndexTest metodunu çağırarak Option 1'i seçin
        selectByIndexTest(driver, By.id("dropdown"));


        // Tarayıcıyı kapat
        driver.quit();
    }



    public static void selectByIndexTest(WebDriver driver, By dropdownLocator) {
        // Dropdown elementini bulun
        WebElement dropdownElement = driver.findElement(dropdownLocator);

        // Select sınıfını kullanarak dropdown'u seçin
        Select dropdown = new Select(dropdownElement);

        // Option 1'i index 0 kullanarak seçin (index 0'dan başlar)
        dropdown.selectByIndex(0);
    }




//        2.Create method selectByValueTest Select Option 2 by value from Simple dropdown




}
