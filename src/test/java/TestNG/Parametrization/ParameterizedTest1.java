package TestNG.Parametrization;


import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedTest1 {
    @Test
    @Parameters({"x","y"})
    public void parameterTest(int x,@Optional("5") int y) {
        x+=2;
        System.out.println("The result is : " + x);
        System.out.println("The result is : " + y);
    }
}

