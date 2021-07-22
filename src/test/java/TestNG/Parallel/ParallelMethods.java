package TestNG.Parallel;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParallelMethods {
    //(threadPoolSize = 2, invocationCount = 2, timeOut = 1000)
    @Test
    public void testMethod1()
    {
        open("https://demoqa.com/books");
        $(".rt-td img").isImage();
    }
    @Test
    public void testMethod2()
    {
        System.setProperty("webdriver.edge.driver", ".\\src\\main\\resources\\MicrosoftWebDriver.exe");
        WebDriverRunner.setWebDriver(new EdgeDriver());
        open("https://demoqa.com/books");
        $(".rt-td img").isImage();
    }

}

