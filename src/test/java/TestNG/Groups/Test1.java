package TestNG.Groups;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
//@Test(groups = { "classLevel" })
public class Test1 {
    WebDriver driver;
    // Saving the expected title of the Webpage
    String title = "ToolsQA - Demo Website For Automation";


    @Test(groups = { "demo1" ,"demo2"})
    public void starting_point(){
        System.out.println("This is the starting point of the test");
        //Initialize Chrome Driver
        //driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
    }


    @Test(groups = { "demo1" })
    public void checkTitle() {
        String testTitle = "ToolsQA";
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, testTitle);
    }


    @Test(groups = { "demo2" })
    public void click_element() {
        driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[1]/a")).click();
        System.out.println("Home Page heading is displayed");
    }
    @AfterMethod
    public void close(){
        WebDriverRunner.closeWebDriver();
    }
}

