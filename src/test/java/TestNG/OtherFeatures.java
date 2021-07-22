package TestNG;

import org.testng.annotations.*;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OtherFeatures {
    @BeforeMethod
    public void beforeClass(){
      //  open("http://the-internet.herokuapp.com/abtest");
    }
    @Test(invocationCount = 7,timeOut = 1000)
    public void a_dependsMethod() {
        //$(".example button").click();
        System.out.println("test "+Thread.currentThread().getId());
    }
}
