package TestNG.Parametrization;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ITestContext_DataProvider {
    WebDriver driver;
    @BeforeMethod(groups={"One","Two"})
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Opening search engine
        driver.get("https://google.com");
    }
    @AfterMethod(groups={"One","Two"})
    public void tearDown(){
        driver.quit();
    }

    @Test(dataProvider="searchKey" , groups="One")
    public void testMethodOne(String monument,String city) throws InterruptedException{
        WebElement searchBox=driver.findElement(By.name("q"));
        searchBox.sendKeys(monument +" "+city);
        System.out.println("You are trying to search " +monument+ " which is in " +city);

        WebElement srchBtn = driver.findElement(By.name("btnK"));
        srchBtn.submit();
        Thread.sleep(3000);
        System.out.println("The page title is: " +driver.getTitle());
    }
    @Test(dataProvider="searchKey" , groups="Two")
    public void testMethodTwo(String location) throws InterruptedException{

        WebElement searchBox=driver.findElement(By.name("q"));
        searchBox.sendKeys(location);
        System.out.println("You are trying to search : " +location);
        WebElement srchBtn = driver.findElement(By.name("btnK"));
        srchBtn.submit();
        Thread.sleep(3000);
        System.out.println("The page title is: " +driver.getTitle());
    }
    @DataProvider(name="searchKey")
    public Object[][] getDataProviderData(ITestContext c){
        Object[][] grpArr = null;
        for (String grp : c.getIncludedGroups()){
            if(grp.equalsIgnoreCase("One")){
                grpArr = new Object[][]{
                        { "Gate Way of India", "Mumbai" },
                        { "Konark Sun Temple", "Konark" },
                        { "Statue of Unity", "Gujarat" }

                };
                break;
            }
            else if(grp.equalsIgnoreCase("Two")){
                grpArr = new Object[][]{
                        {"London"},
                        {"Australia"},
                        {"Dallas"}
                };
            }
        }
        return grpArr;
    }
}
