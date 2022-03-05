package selenium;

import java.util.*;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Cookies{
    WebDriver driver;
    public Cookies() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test
    public void saveCookies() throws InterruptedException {

        driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");

        // Input Email id and Password If you are already Register
        driver.findElement(By.name("username")).sendKeys("abc123");
        driver.findElement(By.name("password")).sendKeys("123xyz");
        driver.findElement(By.name("submit")).click();

        Assert.assertEquals(
                driver.findElement(By.cssSelector(".form-signin-heading center")).getText(),"You are logged In");

        Set<Cookie> cookies = driver.manage().getCookies();
        Cookie seleniumCookie=driver.manage().getCookieNamed("Selenium");
        System.out.println(cookies.size());
        driver.close();
        driver = new ChromeDriver();

        //restore all cookies from previous session
        driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");
        for(Cookie ck:cookies) {
          //  Cookie cookie=cookies.iterator().next();
           // System.out.println(cookie);
            driver.manage().deleteCookie(seleniumCookie);
        }
        Thread.sleep(2000);

        driver.navigate().refresh();
        Assert.assertEquals(
                driver.findElement(By.cssSelector(".form-signin-heading center")).getText(),"You are logged In");
    }

}

