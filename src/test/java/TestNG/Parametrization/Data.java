package TestNG.Parametrization;

import io.qameta.allure.Severity;
import org.testng.annotations.DataProvider;

public class Data {
    @DataProvider(name="data")

    public static Object[][] dpMethod(){
        return new Object[][]
                {{2, 3 , 5}, {5, 7, 9}};
    }
}
