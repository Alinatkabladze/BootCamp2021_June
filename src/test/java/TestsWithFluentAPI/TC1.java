package TestsWithFluentAPI;


import PageObjects.FluentAPI.DashboardPage;
import PageObjects.FluentAPI.HomePage;
import PageObjects.FluentAPI.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TC1 {

    public static void main(String[] args) throws InterruptedException {

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

