package StepObjects;

import PageObjects.ClassicPOM.DashboardPage;
import org.openqa.selenium.WebDriver;

public class DashboardSteps {
    WebDriver driver;
    DashboardPage dashboard=new DashboardPage();


    public String getHeading() {
        return dashboard.heading.getText();
    }

    public void clickLogout() {
        dashboard.logoutBtn.click();
    }
}
