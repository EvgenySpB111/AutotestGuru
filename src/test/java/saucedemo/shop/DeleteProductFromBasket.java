package saucedemo.shop;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import saucedemo.shop.pages.BasketProductPage;
import saucedemo.shop.pages.LoginPage;
import saucedemo.shop.pages.StartShopPage;

import static com.codeborne.selenide.Selenide.*;

public class DeleteProductFromBasket  extends TestBase {
    @Disabled
    @DisplayName("TestName: Delete product from basket")
    @Test
    void deleteProductFromBasket() {
        new StartShopPage().addProductInBasket();
        new BasketProductPage().deleteProductFromBasket();
    }

    @Test
    public void deleteProductFromBasket2() {
        open("https://www.saucedemo.com/inventory.html");
        $x("//input[@name ='user-name']").setValue("standard_user");
        $x("//input[@name ='password']").setValue("secret_sauce");
        $x("//input[@name='login-button']").click();
        $x("//div[@class='app_logo']").shouldBe(Condition.visible);
        $$x("//button[text() ='Add to cart']").get(0).click();
        String countProductInBasket = $x("//a[@class = 'shopping_cart_link']").getText();
        Assertions.assertEquals("1",countProductInBasket);
        $x("//a[@class = 'shopping_cart_link']").click();
        Assertions.assertEquals("1", $x("//a[@class = 'shopping_cart_link']").getText());
        $x("//span[@class='shopping_cart_badge']").shouldBe(Condition.visible);
        $$x("//button[text() ='Remove']").get(0).click();
        Assertions.assertEquals("", $x("//a[@class = 'shopping_cart_link']").getText());
    }
}
