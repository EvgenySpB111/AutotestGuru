package saucedemo.shop.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class BasketProductPage {

    private SelenideElement header = $x("//span[@class='shopping_cart_badge']");
    private ElementsCollection buttonRemove = $$x("//button[text() ='Remove']");
    private SelenideElement basketForProductsButton = $x("//a[@class = 'shopping_cart_link']");

    public BasketProductPage deleteProductFromBasket() {
        basketForProductsButton.click();
        Assertions.assertEquals("1", basketForProductsButton.getText());
        header.shouldBe(Condition.visible); // проверка заголовка корзины что он виден
        buttonRemove.get(0).click();
        Assertions.assertEquals("", basketForProductsButton.getText()); // проверка что элемент удален
        return this;
    }
     public BasketProductPage deleteProductFromBasketWhenBasketTwoProducts() {
         basketForProductsButton.click();
         Assertions.assertEquals("2", basketForProductsButton.getText());
         header.shouldBe(Condition.visible); // проверка заголовка корзины что он виден
         buttonRemove.get(0).click();
         Assertions.assertEquals("1", basketForProductsButton.getText()); // проверка сколько осталось товара в корзине
         return this;
     }




}
