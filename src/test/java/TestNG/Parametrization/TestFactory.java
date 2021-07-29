package TestNG.Parametrization;

import org.testng.annotations.Factory;

public class TestFactory
{
    @Factory
    public Object[] factoryMethod() {
        return new Object[] {
                new FactoryExample("one"),
                new FactoryExample("two"),
                new FactoryExample("three")
        };
    }
}

