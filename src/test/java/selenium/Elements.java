package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Elements {

    WebDriver driver;


    public Elements() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testElementStrategies() throws InterruptedException {
        driver.get("https://demo.qameta.io/allure/#suites/7adfcc91981e2dd4979bde5ed5d5c88b/9a72ea7cf41827ad/");
        Thread.sleep(4000);
        List<WebElement> h3 = driver.findElements(By.tagName("h3"));
        WebElement descriptionByXpath = driver.findElement(By.xpath("//h3[@class='test-result-execution__title']"));
        WebElement h3ByXpathContains= driver.findElement(By.xpath("//*[contains(@class,'test-result-execution')]"));
        //*[@class='tree__content']//*[@class='tree__content']/*[@class='node'][2]
        //*[@class='node'][2]/following::h2
        //*[@class='tree__content']//*[@class='tree__content']/child::div

        //css
        WebElement descriptionByCSS = driver.findElement(By.cssSelector("div.tree__content"));
        //ends-with
        //div[class$='content']
        //div.node div:nth-child(1)
    }
}
