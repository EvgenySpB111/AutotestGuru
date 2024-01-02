package saucedemo.shop.allure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import saucedemo.shop.TestBase;
import static io.qameta.allure.Allure.step;

@Tag("void_tests")
public class VoidTests  extends TestBase {

    @Test
     void passTest1 () {
       step("Проверка тест1 прошел",() -> {
           Assertions.assertTrue(true);
       });
   }
    @Test
    void passTest2 () {
        step("Проверка тест2 прошел",() -> {
            Assertions.assertTrue(true);
        });
    }
    @Test
    void passTest3 () {
        step("Проверка тест3 прошел",() -> {
            Assertions.assertTrue(true);
        });
    }
    @Test
    void passTest4 () {
        step("Проверка тест4 упал",() -> {
            Assertions.assertTrue(false);
        });

    }
    @Test
    @Disabled("disabled test")
    void passTest5 () {
        step("Проверка тест5 пропустили",() -> {
            Assertions.assertTrue(true);
        });
    }

}
