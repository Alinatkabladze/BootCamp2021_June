package TestNG.Listeners;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SuiteTest2 {

    @BeforeSuite
    public void bsuite()
    {
        System.out.println("BeforeSuite method of TestNG2 started");
    }


    @Test
    public void test()
    {
        System.out.println("Test Method of TestNG2 started");
    }

    @AfterSuite
    public void asuite()
    {
        System.out.println("AfterSuite method of TestNG2 started");
    }

}

