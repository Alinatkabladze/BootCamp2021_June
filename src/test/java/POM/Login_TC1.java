package POM;

import DataObjects.models.User;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class Login_TC1 extends BaseTest{
    @BeforeTest
    public void setup(){
        BaseTest baseTest=new BaseTest();
        baseTest.initialize();
        driver=getDriver();
        driver.get("https://www.demoqa.com/books");

    }

    @Test(description = "Login and Logout Scenario")
    public void login(){

        HomePage home = new HomePage();
        LoginPage login = new LoginPage();
        DashboardPage dashboard = new DashboardPage();
        User user =new User();
        home.clickLogin();
        login.enterUsername(user.getUserName());
        login.enterPassword("Automation!1");
        login.clickLogin();
        dashboard.checkText();
        dashboard.clickLogout();

    }

}

