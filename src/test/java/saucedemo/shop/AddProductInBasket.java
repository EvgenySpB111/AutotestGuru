package saucedemo.shop;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import saucedemo.shop.pages.StartShopPage;

public class AddProductInBasket extends TestBase {



    @Test
    @Feature("Cheking basket")
    @Story("Add product in basket")
    @Owner("smorzhevskij")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("TestName: Проверка отображение количества товаров при добавление товаров в корзину")
    void addProductInBasket(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        StartShopPage step = new StartShopPage();

        step.loginAndCheckListProductsInPageShop();
        step.addProductInBasket();
    }
}
