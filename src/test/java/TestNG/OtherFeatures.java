package TestNG;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OtherFeatures {
    @Test(invocationCount = 4,successPercentage = 70)
    public void a_dependsMethod() {
        //$(".example button").click();
        open("http://the-internet.herokuapp.com/abtest");
        System.out.println($(".example h3").getText());
    }
}
