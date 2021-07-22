package TestNG;

import org.testng.annotations.*;

public class HierarchyExample
{
    @BeforeClass
    public void beforeClass()
    {
        System.out.println("Before class");
    }
    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("Before method");
    }
    @Test
    public void test1()
    {
        System.out.println("Test1 is executed");
    }
    @Test
    public void test2()
    {
        System.out.println("Test2 is executed");
    }
    @AfterMethod
    public void afterMethod()
    {
        System.out.println("After method");
    }
    @AfterClass
    public void afterClass()
    {
        System.out.println("After class");
    }
    @BeforeTest
    public void beforeTest()
    {
        System.out.println("Before test");
    }
    @AfterTest
    public void afterTest()
    {
        System.out.println("After test");
    }
    @BeforeSuite
    public void beforeSuite()
    {
        System.out.println("Before suite");
    }
    @AfterSuite
    public void afterSuite()
    {
        System.out.println("After suite");
    }
}

