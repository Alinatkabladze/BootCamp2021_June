package TestNG.Parametrization;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class MethodAsParameter {
    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(Method m) {
        if (m.getName() == "Sum") {
            return new Object[][]{{2, 3, 5}, {5, 7, 9}};
        } else if (m.getName() == "Diff") {
            return new Object[][]{{2, 3, -1}, {5, 7, -2}};
        }
        return null;
    }

    @Test(dataProvider = "data-provider")
    public void Sum(int a, int b, int result) {
        int sum = a + b;
        Assert.assertEquals(result, sum);
    }

    @Test(dataProvider = "data-provider")
    public void Diff(int a, int b, int result) {
        int diff = a - b;
        Assert.assertEquals(result, diff);
    }
}

