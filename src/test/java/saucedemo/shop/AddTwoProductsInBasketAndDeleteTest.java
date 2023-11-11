package saucedemo.shop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import saucedemo.shop.pages.BasketProductPage;
import saucedemo.shop.pages.StartShopPage;

public class AddTwoProductsInBasketAndDeleteTest extends TestBase {


    @DisplayName("TestName: add two products in basket and remove one")
    @Test
    void addTwoProductsInBasketAndRemoveOne() {
        new StartShopPage().addTwoProductsInBasket();
        new BasketProductPage().deleteProductFromBasketWhenBasketTwoProducts();
    }
}
