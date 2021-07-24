package TestNG.Retry;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {

    @Test
    @RetryCountIfFailed(10)
    public void test2()
    {
        Assert.assertEquals(false,true);
    }

  //  @Test(retryAnalyzer = MyRetry.class)
    public void Test1()
    {
        Assert.assertEquals(false, true);
    }
}


