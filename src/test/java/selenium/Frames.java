package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class Frames {
    WebDriver driver;
    public Frames() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void switchToFrame() {
        driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.cssSelector("#framesWrapper div")).getText());
      //  driver.switchTo().defaultContent();
      //  driver.findElement(By.xpath("//*[text()='Elements']")).click();
    }
    @Test
    public void switchToNestedFrames() {
        driver.get("http://the-internet.herokuapp.com/nested_frames");
        driver.manage().window().maximize();

        driver.switchTo().frame("frame-top")
                .switchTo()
                .frame("frame-left");
        System.out.println();
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.name("frame-top")).getAttribute("name"));
      //  System.out.println("size" + driver.findElements(By.tagName("frame")).size());
    }
    @Test
    public void handleAlerts() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        driver.findElement(By.id("promtButton")).click();

        new WebDriverWait(driver,5).until(ExpectedConditions.alertIsPresent());
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("boot camp");
        driver.switchTo().alert().accept();
    }
    @Test
    public void catchWindows() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");

        driver.findElement(By.id("windowButton")).click();
        String mainwindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> iterator = allWindows.iterator();

        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + text.getText());
                driver.close();
                System.out.println("Child window closed");
            }
        }


        driver.switchTo().window(mainwindow);
    }
    @Test
    public void switchToActiveElement() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");
        driver.switchTo().activeElement().click();
    }
    @AfterMethod
    public void tearDown(){
        //driver.close();
    }
}
