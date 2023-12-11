package saucedemo.shop.allure;

import com.codeborne.selenide.Selenide;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import saucedemo.shop.TestBase;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class VoidTests  extends TestBase {

   @Test
    void testOpenUrl() {
       Selenide.open("https://www.google.com/search");
       String name = "Поиск в Google";
       String actualName = $x("(//input[@name ='btnK'])[2]").getValue();
       Assertions.assertEquals(name,actualName);
   }

    @Tag("void_tests")
   @Test
     void passTest () {
       Assertions.assertTrue(true);
   }

}
