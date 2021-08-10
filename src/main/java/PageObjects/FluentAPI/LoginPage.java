package PageObjects.FluentAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By uName = By.id("userName");

    By pswd = By.id("password");

    By loginBtn = By.id("login");

    public LoginPage enterUsername(String user) {

        driver.findElement(uName).sendKeys(user);
        return this;
    }

    public LoginPage enterPassword(String pass) {
        driver.findElement(pswd).sendKeys(pass);
        return this;
    }
    public LoginPage clickLogin() {
        driver.findElement(loginBtn).click();
        return this;
    }
}

