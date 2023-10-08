package practicebyme;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Day07_PracticeCookies extends TestBase {

//    Class: Cookies
//    Method: cookiesTest
//    Go to amazon  and automate the tasks:
//    1. Find the total number of cookies
//    2. Print all the cookies
//    3. Get the cookies by their name
//    4. Add new cookie
//    5. Delete all of the cookies

    @Test
    public void cookiesTest () throws InterruptedException {
        driver.get("https://www.amazon.com");

        int totalCookies = driver.manage().getCookies().size();
        System.out.println(totalCookies);

        //2.way
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie eachCookie: cookies) {
            System.out.println("Each cookie : " + eachCookie);
            System.out.println("Each cookie value : " + eachCookie.getValue());

            System.out.println("Each cookie name : " + eachCookie.getName());

        }
//    3. Get the cookies by their name
        System.out.println("Cookies By name : " + driver.manage().getCookieNamed("skin"));
//    4. Add new cookie
        System.out.println("ADD COOKIE");
        Cookie loginCookie = new Cookie("login" ,"melik");
        driver.manage().addCookie(loginCookie);
        Thread.sleep(3000);
        for (Cookie eachCookie: driver.manage().getCookies()) {
            System.out.println(eachCookie);

        }
        int total = driver.manage().getCookies().size();
        System.out.println(total);

//    5. Delete all of the cookies
        driver.manage().deleteAllCookies();
        System.out.println(driver.manage().getCookies().size());




    }
}
