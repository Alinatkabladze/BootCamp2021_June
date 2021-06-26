package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FileUpload {
    WebDriver driver;

    public FileUpload() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void uploadFileWithSendKeys() {
        driver.get("http://demo.guru99.com/test/upload/");
        driver.manage().window().maximize();
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

        // enter the file path onto the file-selection input field
        uploadElement.sendKeys("C:\\Users\\atkabladze\\IdeaProjects\\untitled\\src\\main\\resources\\Selenium_Logo.png");

        // check the "I accept the terms of service" check box
        driver.findElement(By.id("terms")).click();

        // click the "UploadFile" button
        driver.findElement(By.name("send")).click();
    }

    @Test
    public void uploadWithRobot() throws InterruptedException, AWTException {

        driver.manage().window().maximize(); // maximizing window
        driver.get("https://www.grammarly.com/plagiarism-checker");//open testing website
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// for Implicit wait

        JavascriptExecutor js = (JavascriptExecutor) driver; // Scroll operation using Js Executor
        js.executeScript("window.scrollBy(0,200)"); // Scroll Down(+ve) upto browse option
        Thread.sleep(5000); // suspending execution for specified time period

        WebElement browse = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[1]/div/form/label/div"));
        // using linkText, to click on browse element
        browse.click(); // Click on browse option on the webpage
        Thread.sleep(5000); // suspending execution for specified time period

        // creating object of Robot class
        Robot rb = new Robot();

        // copying File path to Clipboard
        StringSelection str = new StringSelection("C:\\Users\\atkabladze\\IdeaProjects\\untitled\\src\\main\\resources\\Selenium_Logo.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // release Contol+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }

}