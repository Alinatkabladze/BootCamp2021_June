package PageFactoryTests;



import PageObjects.PageFactory.DeveloperApplyPage;
import PageObjects.PageFactory.DeveloperPortalPage;
import PageObjects.PageFactory.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class ApplyAsDeveloperTest {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        //use FF Driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void applyAsDeveloper() {
        HomePage home = new HomePage(driver);
        home.clickOnDeveloperApplyButton();
        DeveloperPortalPage devportal= new DeveloperPortalPage(driver);
        Assert.assertTrue(devportal.isPageOpened());
        devportal.clikOnJoin();
        DeveloperApplyPage applyPage =new DeveloperApplyPage(driver);
        Assert.assertTrue(applyPage.isPageOpened());
        applyPage.setDeveloper_email("dejan@toptal.com");
        applyPage.setDeveloper_full_name("Dejan Zivanovic Automated Test");
        applyPage.setDeveloper_password("password123");
        applyPage.setDeveloper_password_confirmation("password123");
        applyPage.setDeveloper_skype("automated_test_skype");


        //Click on join
        //applyPage.clickOnJoin();
    }

    @AfterClass
    public void close(){
        driver.close();
    }
}

