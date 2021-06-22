package selenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Tables {
    WebDriver driver;
    public Tables() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void handleStaticTable() {
        driver.get("http://techcanvass.com/Examples/webtable.html");
        driver.manage().window().maximize();
        // System.out.println(driver.findElement(By.xpath("//*[@id='t01']/tbody/tr[1]/th[1]")).getText());

        for(int rowno=2;rowno<=4;rowno++)
        {
            for(int colno=1;colno<=3;colno++)
            {
                System.out.println(driver.findElement(By.xpath("//*[@id='t01']/tbody/tr[" + rowno + "]/td[" + colno + "]")).getText());
            }
        }
    }
    @Test
    public void handleDynamicTable() {
        driver.get("http://techcanvass.com/Examples/webtable.html");
        driver.manage().window().maximize();
        WebElement webtable=driver.findElement(By.xpath("html/body/table"));
        //Finding & Printing number of rows
        List<WebElement> rows=webtable.findElements(By.tagName("tr"));
        webtable.findElements(By.tagName("tr")).size();
        System.out.println("Number of Rows including headings:"+ rows.size());
        //Finding and printing number of columns
        List<WebElement>columns = rows.get(0).findElements(By.tagName("th"));
        System.out.println("Number of columns:"+ columns.size());


        for(int rnum=1;rnum<=rows.size();rnum++)
        {
            for (int colnum=1;colnum<=columns.size();colnum++)
            {
                if (rnum==1)
                {
                    System.out.println(driver.findElement(By.xpath(	"//*[@id='t01']/tbody/tr[" + rnum + "]/th[" + colnum + "]")).getText());
                }
                else
                {
                    System.out.println(driver.findElement(By.xpath(	"//*[@id='t01']/tbody/tr[" + rnum + "]/td[" + colnum + "]")).getText());
                }
            }
        }
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}

