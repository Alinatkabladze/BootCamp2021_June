package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class FormElements {
    WebDriver driver;
    public FormElements() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void checkRadioButton() {
        driver.get("https://techcanvass.com/examples/register.html");
        driver.manage().window().maximize();
        WebElement male = driver.findElement(By.cssSelector("input[value='male']"));
        WebElement female = driver.findElement(By.cssSelector("input[value='female']"));
        if(female.isSelected())
            female.click();

    }
    @Test
    public void dropDowns() {
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        driver.manage().window().maximize();
        List<WebElement> name = driver.findElements(By.xpath("//div[@id='checkboxes']/label"));
        for(WebElement selectedOption : name) {
            selectedOption.click();
        }

    }
    @Test
    public void selectOptionFromDropDown() {
        driver.get("https://techcanvass.com/examples/register.html");
        driver.manage().window().maximize();
        Select name = new Select(driver.findElement(By.cssSelector("select[name='model']")));
        name.selectByVisibleText("Serene Pad 32G");
        System.out.println("multiple " + name.isMultiple());

        List<WebElement> selectedOptions = (List<WebElement>) name.getFirstSelectedOption();
        for(WebElement selectedOption : selectedOptions) {
            System.out.println(selectedOption.getText());
        }
    }
    @AfterMethod
    public void tearDown(){
        // driver.close();
    }
}
