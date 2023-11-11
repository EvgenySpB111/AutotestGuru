package ru.papteki.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.*;

public class StartPage  {

    private String BaseUrlPage = "https://papteki.ru/";

    private SelenideElement fieldSearch = $x("//input[@type ='search']");
    private SelenideElement searchButton = $x("//button[@class ='pa-header__search-btn']");

    public StartPage checkStartPage() {
        open("https://papteki.ru/");
        Assertions.assertEquals(BaseUrlPage, WebDriverRunner.getWebDriver().getCurrentUrl());
        return this;
    }

    public StartPage checkJobFieldSearch(String nameProduct) {
        fieldSearch.setValue(nameProduct);
        searchButton.click();
        String firstProduct = $$x("//a[@class='catalog__item-title']").get(1).getValue();
        Assertions.assertTrue(firstProduct.contains(nameProduct));
        return  this;
    }
}
