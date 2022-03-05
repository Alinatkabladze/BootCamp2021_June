package TestNG;

import org.testng.annotations.*;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;

public class OtherFeatures {
    @BeforeMethod
    public void beforeClass(){
      //  open("http://the-internet.herokuapp.com/abtest");
    }
    @Test(invocationCount = 7,successPercentage = 50)
    public void a_dependsMethod() {
        //$(".example button").click();
        System.out.println("test "+Thread.currentThread().getId());
    }

        int count = 0;

        @Test(invocationCount = 5,timeOut = 10,successPercentage = 50)
        public void a() {
            count++;
            System.out.println("Invoked count : " + count);

            if (count % 2 == 0) {
                assertTrue(false);
            } else {
                assertTrue(true);
            }

    }
    @Test(invocationCount=5,invocationTimeOut=6000,timeOut = 900)
    public void sampleTest() throws Exception{
        System.out.println("Foo.");
        Thread.sleep(1000);
    }
}
