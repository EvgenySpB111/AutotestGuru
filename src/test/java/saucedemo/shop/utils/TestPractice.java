package saucedemo.shop.utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import saucedemo.shop.TestBase;

import static com.codeborne.selenide.Selenide.*;

public class TestPractice  extends TestBase {

    @Test
    public void testClosedPopup() {
        Selenide.open("https://www.otpbank.ru/");
        $x("//strong[text()='Закрыть']").shouldBe(Condition.visible);
        $x("//strong[text()='Закрыть']").click();
        $x("//strong[text()='Закрыть']").shouldBe(Condition.hidden); //элемент не виден
        //sleep(4000);
    }
   

}
