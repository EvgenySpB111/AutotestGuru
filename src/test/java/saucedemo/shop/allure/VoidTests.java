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
@Tag("void_tests")
public class VoidTests  extends TestBase {




   @Test
     void passTest1 () {
       Assertions.assertTrue(true);
   }
    @Test
    void passTest2 () {
        Assertions.assertTrue(true);
    }
    @Test
    void passTest3 () {
        Assertions.assertTrue(true);
    }
    @Test
    void passTest4 () {
        Assertions.assertTrue(false);
    }
    @Test
    @Disabled("disabled test")
    void passTest5 () {
        Assertions.assertTrue(true);
    }

}
