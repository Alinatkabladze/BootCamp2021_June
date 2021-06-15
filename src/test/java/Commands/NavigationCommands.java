package Commands;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.testng.annotations.Test;


public class NavigationCommands {

   @Test
    public void navigate() throws MalformedURLException {
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.get("https://the-internet.herokuapp.com/");
       driver.manage().window().maximize();

       driver.get("https://gmail.com");
       driver.navigate().back();
       driver.navigate().forward();
       driver.navigate().refresh();
       driver.quit();
    }
}
