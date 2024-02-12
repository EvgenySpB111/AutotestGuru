package saucedemo.shop;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import saucedemo.shop.allure.Attachments;


public class TestBase {


    @BeforeAll
   static void beforeAll() {
       // Configuration.browser = "Edge";
        Configuration.browser = System.getProperty("browser","Chrome");
        Configuration.browserSize = "1920x1080";
        //Configuration.remote = "https://selenoid_url"; // это для того чтоб запускать UI тесты на селеноиде


       /* DesiredCapabilities capabilities = new DesiredCapabilities(); // для того чтоб писалось видео нужны 4 строчки кода
        capabilities.setCapability("EnableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        */


    }
    @BeforeEach
     void beforeListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void afterAttachments() {
        Attachments.screenshotAs("screen1");
        Attachments.pageSource();
        Attachments.addVideo();
        Attachments.getVideoUrl();
        }


    @AfterAll
   static void afterAll() {
    //Selenide.closeWindow();
    //Selenide.closeWebDriver();
    }

}
