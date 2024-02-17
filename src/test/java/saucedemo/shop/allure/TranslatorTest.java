package saucedemo.shop.allure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import saucedemo.shop.TestBase;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TranslatorTest extends TestBase {
    String transferTo = "translation after";
    String transferAfter = "перевод после";

    @Tag("test_UI")
    @Test
   public void translatorFirstTest() {
        step("Открываем Google",() -> {
            open("https://www.google.com/");
        });
        step("Вводим в поиск 'Переводчик онлайн' и жмем Enter",() -> {
            $x("//textarea[@aria-owns='Alh6id']").setValue("Переводчик онлайн").pressEnter();
        });
        step("Кликаем на ссылку перводчика",() -> {
            $x("//h3[text()='Google Переводчик']").click();
                });
        step("Проверяем что перводим с английского",() -> {
          String languageOne = $x("(//span[@class='VfPpkd-jY41G-V67aGc' and text()='английский'])[1]").
                  getText();
            Assertions.assertEquals(languageOne,"английский");
          });
        step("Проверяем что перводим на русский",() -> {
        String languageTwo = $x("(//span[@class='VfPpkd-jY41G-V67aGc' and text()='русский'])[2]").
                getText();
        Assertions.assertEquals(languageTwo, "русский");
        });
        step("Вводим в переводчик текст " + transferTo + " ",() -> {
         $x("//textarea[@class='er8xn']").setValue(transferTo);
        });
        step("Проверяем правильный перевод. Должно быть :"+ transferAfter +" ",() -> {
         String ActualResult = $x("(//span[@class='HwtZe'])[1]")
                 .getAttribute("innerText");
         Assertions.assertEquals(ActualResult, transferAfter);
        });
        }
        }



