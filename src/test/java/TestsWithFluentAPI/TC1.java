package TestsWithFluentAPI;


import PageObjects.FluentAPI.DashboardPage;
import PageObjects.FluentAPI.HomePage;
import PageObjects.FluentAPI.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class TC1 {

    @Test(description="Login")
    @Severity(SeverityLevel.BLOCKER)
    public void test1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.demoqa.com/books");
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);
        DashboardPage dashboard = new DashboardPage(driver);
        home.clickLogin();


        login.enterUsername("---Your Username---")
                .enterPassword("---Your Password---")
                .clickLogin();

        Thread.sleep(3000);
        System.out.println("The page heading is --- " +dashboard.getHeading());
        dashboard.clickLogout();
        driver.quit();
    }

}

