package saucedemo.shop.allure;


import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import saucedemo.shop.TestBase;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class AllureReport extends TestBase {
    @Test
    void checkGitHub() {
         open("https://github.com/");
        $x("//span[@class= 'flex-1']").click();
        $x("//input[@id='query-builder-test']").setValue("eroshenkoam/allure-example").pressEnter();
        $x("//a[@href='/eroshenkoam/allure-example']").click();
        $x("//a[@id ='issues-tab']").click();
        $$x("//div[@class='d-flex mt-1 text-small color-fg-muted']").get(0).shouldHave(Condition.visible);
        $$x("//div[@class='d-flex mt-1 text-small color-fg-muted']").get(0).shouldBe(Condition.enabled);
        $$x("//div[@class='d-flex mt-1 text-small color-fg-muted']").get(0).
                shouldBe(Condition.text("#83 opened"));

    }

    @Test
    void checkLambdaGitHub() {

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

    @Tag("test_UI")
    @DisplayName("Test name: checking UI ")
    @Test
    public void testCase1() {
        step("Открываем гугл",() -> {
            open("https://www.google.ru/?hl=ru");
        });
        step("Вводим в поиск город Рыбница",() -> {
            $x("//textarea[@class='gLFyf']").setValue("Рыбница").pressEnter();
        });
        step("Проверяем чтоб город в заголовке новой страницы была Рыбница",() -> {
            Assertions.assertEquals("Рыбница", $x("//div[@data-attrid ='title']").getText());
        });
    }


}
