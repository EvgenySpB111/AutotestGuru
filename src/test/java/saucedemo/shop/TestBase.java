package saucedemo.shop;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import saucedemo.shop.allure.Attachments;


//import java.io.IOException;
//import java.net.URL;
//import java.util.Optional;


public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "Edge";
        Configuration.browser = System.getProperty("browser", "Chrome");
        Configuration.browserSize = "1920x1080";
        //Configuration.remote = "http://localhost:4444/wd/hub"; // это для того чтоб запускать UI тесты на селеноиде


      /* DesiredCapabilities capabilities = new DesiredCapabilities(); // для того чтоб писалось видео нужны 4 строчки кода
        capabilities.setCapability("EnableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;

       */


    }



        @AfterEach
        void Attachments () {
            Attachments.screenshotAs("screen1");
            Attachments.pageSource();
            Attachments.addVideo();
            //Attachments.getVideoUrl();
            //Optional.ofNullable(WebDriverRunner.getWebDriver()).ifPresent(WebDriver::quit);

        }


        @AfterAll
        static void afterAll () {
            //Selenide.closeWindow();
            //Selenide.closeWebDriver();
        }

    }
