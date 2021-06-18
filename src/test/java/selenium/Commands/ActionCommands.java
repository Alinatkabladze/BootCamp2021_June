package selenium.Commands;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionCommands {
    @Test
    public void holdAndRelease() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "https://jqueryui.com/slider/";
        driver.get(url);
        try
        {
            /* create an object for the Actions class and pass the driver argument */
            Actions action = new Actions(driver);
            driver.switchTo().frame(0);
            WebElement elem_slider = driver.findElement(By.cssSelector(".ui-slider-handle"));
            action.clickAndHold(elem_slider).moveByOffset(40,0).release().perform();
            System.out.println("Drag & Drop test case successful\n");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
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
     /*   actions
                .contextClick(element)
                .perform();*/

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
       // action.clickAndHold(SourceElement).moveToElement(TargetElement).release().perform();
        Thread.sleep(3000);

    }
    @Test
    public void doKeyPresses() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/key_presses");
        driver.manage().window().maximize();


        WebElement element= driver.findElement(By.id("target"));
        element.sendKeys(Keys.CONTROL,Keys.DOWN);
    }



}
