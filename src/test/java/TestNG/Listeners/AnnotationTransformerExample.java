package TestNG.Listeners;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class AnnotationTransformerExample {

    @Test(alwaysRun=true)
    public void test1()
    {
        System.out.println("This is my first test whose behaviour would get changed while executing");
    }
    @Test(alwaysRun=true)
    public void test2()
    {
        System.out.println("This is my second test executing");
    }

}

