package saucedemo.shop.allure;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import saucedemo.shop.TestBase;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
 @Tag("void tests")
public class VoidTests  extends TestBase {

   @Test
   void startTest() {
       Selenide.open("https://www.google.com/");
       $x("//textarea[@id = 'APjFqb']").setValue("Рыбница").pressEnter();

   }
 @Disabled ("фронт пока не готов")
   @Test
    void negativeTest () {
       Assertions.assertTrue(true);
   }

}
