package selenide;
import com.codeborne.selenide.*;
import com.codeborne.selenide.testng.SoftAsserts;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@Listeners({ SoftAsserts.class})
public class SelenideTests {

    public SelenideTests(){
        startMaximized=true;
      //  timeout=20000;
      //  holdBrowserOpen=false;
        baseUrl = "http://the-internet.herokuapp.com";
        reopenBrowserOnFail = true;
        downloadsFolder="src/main/resources/Pictures";
        fastSetValue=true;
        assertionMode=AssertionMode.SOFT;
        fileDownload=FileDownloadMode.HTTPGET;
        reportsFolder="src/main/resources/failedScreens";

    }


    @Test
    public void isImage() {
        open("https://demoqa.com/books");
        $(".rt-td img").isImage();
        sleep(5000);
    }

    @Test
    public void basicCommands() {
        assertionMode=AssertionMode.STRICT;
        open("/dynamic_controls");
     //   $(byAttribute("href","http://elementalselenium.com/")).click();
       SelenideElement enableButton= $(byTextCaseInsensitive("enable"));
       enableButton.click();
        System.out.println($("#message").getText());
        $("#message").shouldHave(text("It's enabled!"));
        $("#input-example").$(byText("Disable")).shouldBe(and("Check text and state"
                ,Condition.text("Enabled"),disabled));
      //  $(byXpath("//form[@id='input-example']/input")).should(disabled, Duration.ofSeconds(1));
       // $(byXpath("//form[@id='input-example']/input")).shouldHave(Condition.text("Disable"), Duration.ofSeconds(1));

    }

    @Test
    public void keyPressesExample() {
        open("/key_presses");
        actions().sendKeys(Keys.ESCAPE).perform();
        sleep(5000);

    }
    @Test
    public void testNGAssertionsExample() {
        SoftAssert softAssert = new SoftAssert();
        open("/dynamic_controls");
        SelenideElement enableButton= $(byTextCaseInsensitive("enable"));
        //enableButton.click();
       //softAssert.assertEquals($("#input-example").$(byText("Disable")).getText(),"Enabled","Check text");
       $(withText("Enable"),2).click();
     //  softAssert.assertFalse($("#input-example").$(byText("Disable")).isEnabled());
       softAssert.assertAll();
    }

    @Test
    public void elementsCollectionExample(){
        open("/add_remove_elements/");
        // $(byText("Delete")).click();
        for (int i = 0; i <3 ; i++) {
            $(byText("Add Element")).click();
        }
       // $$(byText("Delete")).shouldHave(texts("Delete","Delete","Add"));
        $$(byText("Delete")).stream().forEach(el -> el.click());
       // $(byText("Delete")).click();
        //  System.out.println($("body").find("#elements").findAll(".added-manually").get(0).getText());
        sleep(4000);
    }
    @Test
    public void fillInputs(){
        $(byAttribute("type","number")).setValue("1");
        $(byAttribute("type","number")).shouldHave(value("5"));
        sleep(4000);
    }
    @Test
    public void handleCheckbox(){
        open("/checkboxes");
        // $$("#checkboxes input").stream().forEach(el -> { el.shouldHave(type("checkbox"));});
        //Assert.assertEquals($("#checkboxes input").isDisplayed(),true);
        Assert.assertTrue($("#checkboxes input").isDisplayed());
        $("#checkboxes input").shouldBe(Condition.appear);
        sleep(4000);
    }
    @Test
    public void handleDropDowns(){
        open("/dropdown");
        $("#dropdown").getSelectedOption().shouldHave(matchText("Option 1"),value("1"));
        $("#dropdown").selectOptionContainingText("Option 1");
        $("#dropdown").getSelectedOption().shouldHave(matchText("ption 1"),value("1"));
    }
    @Test
    public void fileDownload() throws FileNotFoundException {
        open("/download");
        $(byText("logo.png")).download();

    }
}
