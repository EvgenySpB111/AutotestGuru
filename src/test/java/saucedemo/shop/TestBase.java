package saucedemo.shop;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
   static void beforeAll() {
        Configuration.browser = "Chrome";
        Configuration.browserSize = "1920x1080";
    }

    @AfterAll
   static void afterAll() {
    Selenide.closeWindow();
    Selenide.closeWebDriver();
    }
}
