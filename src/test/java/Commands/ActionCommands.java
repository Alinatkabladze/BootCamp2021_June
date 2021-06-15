package Commands;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ActionCommands {
    @Test
    public void holdAndRelease() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "https://selenium08.blogspot.com/2020/01/click-and-hold.html";
        driver.get(url);
        driver.manage().window().maximize();
// Locate the element C by By.xpath.
        WebElement titleC = driver.findElement(By.xpath("//li[text()= 'C']"));
// Create an object of actions class and pass reference of WebDriver as a parameter to its constructor.
        Actions actions = new Actions(driver);
// Move the cursor to the position of element C.
       // actions.moveToElement(titleC); // Call clickAndHold() method to perform click and hold operation.
        actions.clickAndHold(titleC).perform();
        // actions.clickAndHold(element_1).release(element_12).build().perform();
    }
    @Test
    public void contextClick() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/context_menu");
        driver.manage().window().maximize();

        WebElement element= driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick().perform();
        actions
                .contextClick(element)
                .perform();

    }
    @Test
    public void dragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        WebElement SourceElement= driver.findElement(By.id("draggable"));
        WebElement TargetElement= driver.findElement(By.id("droppable"));
        Actions action = new Actions(driver);
        Thread.sleep(3000);
        action.dragAndDrop(SourceElement, TargetElement).build().perform();
//action.clickAndHold(SourceElement).moveToElement(TargetElement).release().build().perform();
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void doKeyPresses() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/key_presses");
        driver.manage().window().maximize();


        WebElement element= driver.findElement(By.id("target"));
        element.sendKeys(Keys.CONTROL);
    }



}
