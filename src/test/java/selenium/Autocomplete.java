package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Autocomplete {
    WebDriver driver;


    public Autocomplete() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void handleTooltip() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://webdriveruniversity.com/Autocomplete-TextField/autocomplete-textfield.html");
        driver.findElement(By.id("myInput")).sendKeys("Av");

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='acado']")))).click();
        js.executeScript("document.getElementById('submit-button').click();");

        List<WebElement> autoSuggest = driver.findElements(By.id("myInputautocomplete-list"));
        Thread.sleep(3000);

    }
}
