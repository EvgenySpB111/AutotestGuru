package saucedemo.shop;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;

public class TestBase {
    @BeforeAll
   static void beforeAll() {
        Configuration.browser = "Chrome";
        Configuration.browserSize = "1920x1080";
    }
    @BeforeEach
     void beforeListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void afterAttachments() {
       // @Attachment( value = "Screenshot", type = "image/png", fileExtension = "png")
       // public byte[] takeScreenshot() {
         //   return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        }
    

    @AfterAll
   static void afterAll() {
    //Selenide.closeWindow();
    //Selenide.closeWebDriver();
    }

}
