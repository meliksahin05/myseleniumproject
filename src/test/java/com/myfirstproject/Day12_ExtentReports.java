package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;

public class Day12_ExtentReports extends TestBase {

     @Test
    public void extentReportsTest(){

         extentTest.pass("Loggin in successful"); // pass is used to mark as passed
         extentTest.fail("Login is failed");
         extentTest.skip("Login is skipped");
         extentTest.warning("Pay attention to Log in");
         extentTest.info("Login is successful");


//        Assertions.assertTrue("Amazon title".contains("Amazon"),"Amazon title test failed");

//       in testing we can use extent reports within conditions
         if("Amazon title".contains("amazon")){
             extentTest.pass("Amazon title test PASSED");
         }else {
             extentTest.fail("Amazon title test failed");
         }

     }
}
