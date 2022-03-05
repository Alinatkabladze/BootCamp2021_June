package TestNG.Parametrization;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DProvider {


    @Test (dataProvider = "data",dataProviderClass = Data.class)
    public void myTest (int a, int b, int result) {
        int sum = a + b;
        Assert.assertEquals(result, sum);
    }
}

