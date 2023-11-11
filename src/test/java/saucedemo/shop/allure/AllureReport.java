package saucedemo.shop.allure;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import saucedemo.shop.TestBase;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class AllureReport extends TestBase {

    @Test
    void checkGitHub() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $x("//span[@class= 'flex-1']").click();
        $x("//input[@id='query-builder-test']").setValue("eroshenkoam/allure-example").pressEnter();
        $x("//a[@href='/eroshenkoam/allure-example']").click();
        $x("//a[@id ='issues-tab']").click();
        $$x("//div[@class='d-flex mt-1 text-small color-fg-muted']").get(0).shouldHave(Condition.visible);
        $$x("//div[@class='d-flex mt-1 text-small color-fg-muted']").get(0).shouldBe(Condition.enabled);
        $$x("//div[@class='d-flex mt-1 text-small color-fg-muted']").get(0).
                shouldBe(Condition.text("#84 opened"));

    }

    @Test
    void checkLambdaGitHub() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем сайт для начала теста",() -> {
            open("https://github.com/");
        });
        step("кликаем на поле поиска",() -> {
            $x("//span[@class= 'flex-1']").click();
        });
        step("вводим данные в поле поиска и жмем Enter",() -> {
            $x("//input[@id='query-builder-test']").setValue("eroshenkoam/allure-example").pressEnter();
        });

        $x("//a[@href='/eroshenkoam/allure-example']").click();
        $x("//a[@id ='issues-tab']").click();
        $$x("//div[@class='d-flex mt-1 text-small color-fg-muted']").get(0).shouldHave(Condition.visible);
        $$x("//div[@class='d-flex mt-1 text-small color-fg-muted']").get(0).shouldBe(Condition.enabled);
        $$x("//div[@class='d-flex mt-1 text-small color-fg-muted']").get(0).
                shouldBe(Condition.text("#83 opened"));

    }

}
