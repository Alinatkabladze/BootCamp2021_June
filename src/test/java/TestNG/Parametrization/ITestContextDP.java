package TestNG.Parametrization;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ITestContextDP {
    @Test(dataProvider = "data-provider",groups = "A")
    public void Sum(int a, int b, int result) {
        int sum = a + b;
        Assert.assertEquals(result, sum);
    }

    @Test(dataProvider = "data-provider",groups = "B")
    public void Diff(int a, int b, int result) {
        int diff = a - b;
        Assert.assertEquals(result, diff);
    }
    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(ITestContext c) {
        Object[][] groupArray = null;
        for (String group : c.getIncludedGroups()) {
            if (group.equalsIgnoreCase("A")) {
                groupArray = new Object[][]{{2, 3, 5}, {5, 7, 9}};

                break;
            } else if (group.equalsIgnoreCase("B")) {
                groupArray = new Object[][]{{2, 3, -1}, {5, 7, -2}};

            }
            break;
        }
        return groupArray;
    }
}
