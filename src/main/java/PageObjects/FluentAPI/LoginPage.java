package PageObjects.FluentAPI;

import io.qameta.allure.Step;
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

    @Step("Enter Username")
    public LoginPage enterUsername(String user) {

        driver.findElement(uName).sendKeys(user);
        return this;
    }
    @Step
    public LoginPage enterPassword(String pass) {
        driver.findElement(pswd).sendKeys(pass);
        return this;
    }
    @Step
    public LoginPage clickLogin() {
        driver.findElement(loginBtn).click();
        return this;
    }
}

