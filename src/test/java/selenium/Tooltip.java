package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Tooltip {

    WebDriver driver;

    public Tooltip() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void handleTooltip() {
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/social-icon.html");
        String expectedTooltip = "Github";
        // Find the Github icon at the top right of the header
        WebElement github = driver.findElement(By.xpath(".//*[@class='soc-ico show-round']/a[4]"));

        //get the value of the "title" attribute of the github icon
        String actualTooltip = github.getAttribute("title");
        //Assert the tooltip's value is as expected
        System.out.println("Actual Title of Tool Tip " + actualTooltip);
        if (actualTooltip.equals(expectedTooltip)) {
            System.out.println("Test Case Passed");
        }
    }
    @Test
    public void handleTooltipWithClickAndHold() {
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/tooltip.html");
        String expectedTooltip = "What's new in 3.2";
        WebElement download = driver.findElement(By.xpath(".//*[@id='download_now']"));
        Actions builder = new Actions (driver);
        builder.clickAndHold().moveToElement(download).perform();
        WebElement toolTipElement = driver.findElement(By.xpath(".//*[@class='box']/div/a"));
        String actualTooltip = toolTipElement.getText();

        System.out.println("Actual Title of Tool Tip  "+actualTooltip);
        if(actualTooltip.equals(expectedTooltip)) {
            System.out.println("Test Case Passed");
        }
    }
    @Test
    public void handleToDo() {
        driver.manage().window().maximize();
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        String expectedTooltip = "What's new in 3.2";
        WebElement download = driver.findElement(By.xpath("//*[contains(text(),'Buy new robes')]"));
        Actions builder = new Actions (driver);
        JavascriptExecutor js= (JavascriptExecutor)driver;
        builder.clickAndHold().moveToElement(download).perform();

        WebElement toolTipElement = driver.findElement(By.xpath("//*[contains(text(),'Buy new robes')]//i"));
       // js.executeScript("arguments[0].click();", toolTipElement);
          toolTipElement.click();

    }
}

