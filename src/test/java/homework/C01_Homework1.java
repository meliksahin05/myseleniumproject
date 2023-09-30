package homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class C01_Homework1 extends TestBase {

//    Task1:
//    Navigate to Go to https://www.facebook.com/
//    Click on Create new account
//    Enter first name
//    Enter last name
//    Enter mobile number or email
//    Enter new password
//    Enter birthday
//    Enter gender
//    Click Sign Up

    @Test
    public void firstHomework_firstTask () throws InterruptedException {
//    Navigate to Go to https://www.facebook.com/
        driver.navigate().to("https://www.facebook.com/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@title='Tüm çerezlere izin ver']")).click();
//    Click on Create new account
      driver.findElement(By.linkText("Yeni hesap oluştur")).click();
//    Enter first name
      driver.findElement(By.name("firstname")).sendKeys("MelikSelenium");
//        Enter last name
      driver.findElement(By.name("lastname")).sendKeys("Selenium");
//    Enter mobile number or email
      driver.findElement(By.name("reg_email__")).sendKeys("turkeraliasim@gmail.com");
//    Enter new password
      driver.findElement(By.id("password_step_input")).sendKeys("MarioGomez.20");
//    Enter birthday
//        Day
      WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
      Select selectDay = new Select(day);
      selectDay.selectByVisibleText("15");
        Thread.sleep(3000);

//      Month
      WebElement month = driver.findElement(By.cssSelector("#month"));
      Select selectMonth = new Select(month);
      selectMonth.selectByIndex(0);
        Thread.sleep(3000);

//      Year
      WebElement year = driver.findElement(By.cssSelector("select[id='year']"));
      Select selectYear = new Select(year);
      selectYear.selectByValue("1996");
        Thread.sleep(3000);

        //    Assert if 15 is selected
        WebElement selectedDay = selectDay.getFirstSelectedOption();
        Assertions.assertTrue(selectedDay.getText().contains("15"));
//     Assert if Ocak is selected
        WebElement selectedMonth = selectMonth.getFirstSelectedOption();
        Assertions.assertTrue(selectedMonth.getText().contains("Oca"));
//      Assert if 1996 is selected
        WebElement selectedYear = selectYear.getFirstSelectedOption();
        Assertions.assertTrue(selectedYear.getText().contains("1996"));



//    Enter gender
//        WebElement genderMale = driver.findElement(By.xpath("(//input[@name='sex'])[2]"));
        WebElement genderMale1 = driver.findElement(By.cssSelector("input[value='2']"));
        if (!genderMale1.isSelected()){
            genderMale1.click();
        }

//    Click Sign Up
       driver.findElement(By.xpath("//button[@name='websubmit']")).click();
//     REnter mobile number or email
        driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("turkeraliasim@gmail.com");
        //    Click Sign Up
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();

//        Assert for logined
        Assertions.assertTrue(driver.getCurrentUrl().contains("melik"));








    }
}
