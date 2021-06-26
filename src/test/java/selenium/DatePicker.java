package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePicker {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void simpleHanding() {
        driver.get("http://demo.guru99.com/test/");
        //Find the date time picker control
        WebElement dateBox = driver.findElement(By.xpath("//form//input[@name='bdaytime']"));
        //Fill date as mm/dd/yyyy as 09/25/2013
        dateBox.sendKeys("09252013");
        //Press tab to shift focus to time field
        dateBox.sendKeys(Keys.TAB);
        //Fill time as 02:45 PM
        dateBox.sendKeys("0245PM");
        dateBox.submit();
    }
}
