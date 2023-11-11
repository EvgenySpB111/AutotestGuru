package saucedemo.shop;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import saucedemo.shop.pages.BasketProductPage;
import saucedemo.shop.pages.StartShopPage;

public class DeleteProductFromBasket  extends TestBase {
    @DisplayName("TestName: Delete product from basket")
    @Test
    void deleteProductFromBasket() {
        new StartShopPage().addProductInBasket();
        new BasketProductPage().deleteProductFromBasket();
    }
}
