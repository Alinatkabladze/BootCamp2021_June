package TestNG;

import org.testng.Assert;
import org.testng.annotations.*;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;

public class DependsOn {

    @BeforeMethod
    public void before() {
        startMaximized = true;
    }
    @AfterMethod
    public void after() {
        closeWebDriver();
    }



    @Test
    public void a_dependsMethod() {
        //$(".example button").click();
        open("http://the-internet.herokuapp.com/abtest");
        System.out.println($(".example h3").getText());
    }

    @Test
    public void c_doAction() {
        open("http://the-internet.herokuapp.com/add_remove_elements/");
        for (int i = 0; i < 3; i++) {
            $(".example button").click();
        }
        $$(".added-manually").shouldHave(texts("Add", "Delete", "Delete"));
    }
    @Test(dependsOnMethods = "c_doAction",alwaysRun = true)
    public void b_doAction1() {
        open("http://the-internet.herokuapp.com/add_remove_elements/");
        for (int i = 0; i < 3; i++) {
            $(".example button").click();
        }
        $$(".added-manually").shouldHave(texts("Delete", "Delete", "Delete"));
    }

}

