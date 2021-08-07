package POM;

import org.openqa.selenium.By;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class DashboardPage extends BaseTest {
    By heading = By.xpath("//div[@class=\"main-header\"]");
    By logoutBtn = By.id("submit");


    public String getHeading() {
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        String head = driver.findElement(heading).getText();
        return head;
    }


    public void checkText() {
        Assert.assertEquals(getHeading(),"Wrong");
    }


    public void clickLogout() {
        driver.findElement(logoutBtn).click();
    }
}

