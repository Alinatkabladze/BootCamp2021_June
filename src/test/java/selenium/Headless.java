package selenium;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Headless {
    WebDriver driver;
    @BeforeMethod
    public void setup() {
     //   WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ATkabladze\\IdeaProjects\\BootCamp2021_June\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
         driver = new ChromeDriver(options);
       // driver = new HtmlUnitDriver(true);

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

    @Test
    public void doScroll(){
        driver.manage().window().maximize();
        driver.get("http://webdriveruniversity.com/Scrolling/index.html");
        JavascriptExecutor js= (JavascriptExecutor)driver;
        String checkboxText= js.executeScript("return document.getElementById('zone2-entries').innerText;").toString();
        System.out.println(checkboxText);
    }
    @Test
    public void testParameterWithXML() throws InterruptedException{
        driver.get("http://demo.guru99.com/V4/");
        //Find user name
        WebElement userName = driver.findElement(By.name("uid"));
        //Fill user name
        userName.sendKeys("guru99");
        //Find password
        WebElement password = driver.findElement(By.name("password"));
        //Fill password
        password.sendKeys("guru99");
        System.out.println(driver.findElement(By.xpath("//*[@name='btnLogin']")).getText());
    }
}
