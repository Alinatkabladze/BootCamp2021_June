package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class BasicCookies {
    WebDriver driver;


    public BasicCookies() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void getCookies() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/social-icon.html");
        Thread.sleep(4000);
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie value : cookies)
            System.out.println(value.getName()
                    + ", ");
        System.out.println();


    }
    @Test
    public void whenAddingCookie_thenItIsPresent() {
        driver.navigate().to("http://demo.guru99.com/test/cookie/selenium_aut.php");
        Cookie cookie = new Cookie("foo", "bar");
        driver.manage().addCookie(cookie);
        Cookie driverCookie = driver.manage().getCookieNamed("foo");
        Assert.assertEquals(driverCookie.getValue(), "bar");
    }
    @Test
    public void whenDeletingCookie_thenItIsAbsent() throws InterruptedException {
        driver.navigate().to("http://demo.guru99.com/test/cookie/selenium_aut.php");
        Cookie cookie = new Cookie("foo", "bar");
        driver.manage().addCookie(cookie);
        Cookie lpCookie = driver.manage().getCookieNamed("foo");
        Thread.sleep(4000);
        Assert.assertNotEquals(lpCookie, null);
        driver.manage().deleteCookie(lpCookie);
        Cookie deletedCookie = driver.manage().getCookieNamed("foo");
        Assert.assertEquals(deletedCookie, null);
    }
    @Test
    public void deleteCookies(){
        driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");

        // Input Email id and Password If you are already Register
        driver.findElement(By.name("username")).sendKeys("abc123");
        driver.findElement(By.name("password")).sendKeys("123xyz");
        driver.findElement(By.name("submit")).click();


        Set<Cookie> cookies = driver.manage().getCookies();

        for(Cookie ck:cookies) {
            System.out.println(ck.getName() +" "+ck.getValue());
            driver.manage().deleteCookieNamed("Selenium");
        }
        Set<Cookie> afterdeletingcookies = driver.manage().getCookies();
        for(Cookie ck:afterdeletingcookies) {
            System.out.println("Not deleted cookies " + ck.getName());
        }
    }
}



