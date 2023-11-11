package saucedemo.shop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import saucedemo.shop.pages.StartShopPage;

public class CheckShopPageTest extends TestBase {
    @DisplayName("TestName: check count products for start page")
    @Test
    void checkShopCountProduct() {
      new StartShopPage().loginAndCheckListProductsInPageShop();
    }

}
