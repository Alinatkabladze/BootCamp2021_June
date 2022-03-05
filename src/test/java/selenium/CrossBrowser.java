package selenium;

import java.util.concurrent.TimeUnit;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {

    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception{

        //Check if parameter passed as 'chrome'
        if(browser.equalsIgnoreCase("chrome")){
            //set path to chromedriver_old.exe
          //  System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_old.exe");
            /* WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();*/
            //create chrome instance
            driver = new HtmlUnitDriver(BrowserVersion.CHROME);
        }
        //Check if parameter passed as 'Edge'
        else if(browser.equalsIgnoreCase("Edge")){
            //set path to Edge.exe
           // System.setProperty("webdriver.edge.driver", ".\\src\\main\\resources\\MicrosoftWebDriver.exe");
            /*WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();*/
            //create Edge instance
            driver = new HtmlUnitDriver(BrowserVersion.FIREFOX);
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void handleStaticTable() {
        driver.get("http://techcanvass.com/Examples/webtable.html");
        driver.manage().window().maximize();
        // System.out.println(driver.findElement(By.xpath("//*[@id='t01']/tbody/tr[1]/th[1]")).getText());

        for(int rowno=2;rowno<=4;rowno++)
        {
            for(int colno=1;colno<=3;colno++)
            {
                System.out.println(driver.findElement(By.xpath("//*[@id='t01']/tbody/tr[" + rowno + "]/td[" + colno + "]")).getText());
            }
        }
    }
}
