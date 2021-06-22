package selenium.Commands;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;


public class WebElementCommands  {
        WebDriver driver;
        public WebElementCommands(){
            WebDriverManager.chromedriver().setup();
             driver = new ChromeDriver();
        }

        @Test
        public void getTextAndClear() throws InterruptedException {
            driver.get("https://the-internet.herokuapp.com/inputs");
            driver.manage().window().maximize();
            WebElement element= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input"));
            System.out.println("Get text "+ driver.findElement(By.xpath(" /html/body/div[2]/div/div/div/div/p")).getText());
            element.sendKeys("1");
            element.clear();

        }
    @Test
    public void getLocation()  {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().window().maximize();

        int element= driver.findElement(By.id("column-a")).getLocation().getX();
        int element_b= driver.findElement(By.id("column-b")).getLocation().getX();
        System.out.println(element+ " "+element_b);

    }

        @Test
        public void checkElementStates(){
            driver.get("https://the-internet.herokuapp.com/checkboxes");
            driver.manage().window().maximize();

            WebElement element= driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(3)"));
            element.click();
            System.out.println("isEnabled " + element.isEnabled());
            System.out.println("isDisplayed " + element.isDisplayed());
            System.out.println("isSelected " + element.isSelected());
        }

    @Test
    public void getInfo() {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().window().maximize();
        WebElement element= driver.findElement(By.id("column-a"));

        Dimension dimension= element.getSize();
        System.out.println("Height :" + dimension.height + "\n"+ "Width : "+ dimension.width);
        System.out.println("Css value " + element.getCssValue("background-color"));

        Point point = element.getLocation();
        System.out.println("X cordinate : " + point.x + "\n"+ "Y cordinate: " + point.y);

        System.out.println("getAttribute : " + element.getAttribute("Id"));
        System.out.println("getTagName : " + element.getTagName());

    }

    @Test
    public void submit() {
        driver.get("http://the-internet.herokuapp.com/forgot_password");
        driver.manage().window().maximize();
        WebElement element= driver.findElement(By.id("email"));
        element.sendKeys("alinatkabladze@gmail.com");
        element.submit();
    }

    @Test
    public void goToLink() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        WebElement element= driver.findElement(By.className("example"));
        element.click();
    }
    @Test
    public void findElements() throws InterruptedException {
        String el="";
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().window().maximize();
        WebElement addButton=driver.findElement(By.xpath("/html/body/div[2]/div/div/button"));
        //addButton.click();
       /* WebElement deleteElement= driver.findElement(By.linkText("Elemental Selenium"));
        deleteElement.click();*/
        for (int i = 0; i <1 ; i++) {
          addButton.click();
        }
        WebElement element= driver.findElement(By.cssSelector(".added-manually"));
        WebElement addButton1=driver.findElement(By.className("added-manually"));
        WebElement addButton2=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/button"));
        Thread.sleep(3000);
        System.out.println(element.getLocation());
        element.click();

    }

    @Test
    public void getInfo1() {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().window().maximize();
        WebElement element= driver.findElement(By.id("column-a"));
        WebElement elementB= driver.findElement(By.id("column-b"));


        Point point = element.getLocation();
        System.out.println("X cordinate : " + point.x + "\n"+ "Y cordinate: " + point.y);

        Point pointB = elementB.getLocation();
        System.out.println("X cordinate : " + pointB.x + "\n"+ "Y cordinate: " + pointB.y);

    }

        @AfterMethod
        public void tearDown(){
          driver.close();
        }
    }

