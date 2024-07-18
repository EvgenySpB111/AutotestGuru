package saucedemo.shop.pages;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class StartShopPage {
    private String BASE_URL = "https://www.saucedemo.com/inventory.html";
    private ElementsCollection listProducts = $$x("//div[@class = 'inventory_item']");
    private SelenideElement basketForProductsButton = $x("//a[@class = 'shopping_cart_link']");
    private ElementsCollection addProductInBasketButton = $$x("//button[text() ='Add to cart']");

    @Step("Логинимся в магазине и проверяем что мы вошли в систему")
    public StartShopPage loginAndCheckListProductsInPageShop() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        new LoginPage().loginInShop("standard_user","secret_sauce");
        String urlPage = WebDriverRunner.getWebDriver().getCurrentUrl(); // проверка на верный урл страницы
        Assertions.assertEquals(BASE_URL,urlPage);
        basketForProductsButton.shouldBe(Condition.visible); // проверка что корзина видна
        Assertions.assertTrue(listProducts.size()== 6);   // проверка на кол элементов на странице
        return this;
    }
    @Step("Добавляем один продукт в корзину и проверяем число количество товаров в корзине")
    public StartShopPage addProductInBasket() {
        //loginAndCheckListProductsInPageShop();
       addProductInBasketButton.get(0).click();
       String countProductInBasket = basketForProductsButton.getText();
       Assertions.assertEquals("",countProductInBasket);
       return this;
    }
    @Step("Добавляем два продукта в корзину и проверяем число количество товаров в корзине")
    public StartShopPage addTwoProductsInBasket() {
        loginAndCheckListProductsInPageShop();
        addProductInBasketButton.get(0).click();
        addProductInBasketButton.get(1).click();
        String countProductInBasket = basketForProductsButton.getText();
        Assertions.assertEquals("2",countProductInBasket);
        return this;
    }


}
