package POM;

import org.openqa.selenium.By;

public class HomePage extends BaseTest {

    By LoginBtn = By.id("login");

    public void clickLogin() {
        driver.findElement(LoginBtn).click();
    }
}
