package TestNG;

import org.testng.annotations.Test;

public class Priority {
    @Test(priority = 2)
    public void test2()
    {
        System.out.println("Priority 2");
    }
    @Test(priority = 1)
    public void test1()
    {
        System.out.println("Priority 1");
    }
}

