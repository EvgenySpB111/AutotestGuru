package saucedemo.shop.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private String BASE_URL = "https://www.saucedemo.com/";
    private SelenideElement userName = $x("//input[@name ='user-name']");
    private SelenideElement passwordUser = $x("//input[@name ='password']");
    private SelenideElement buttonLogin = $x("//input[@name='login-button']");
    private SelenideElement errorField = $x("//h3[@data-test='error']");
    private String errorText = "Epic sadface: Username and password do not match any user in this service";


   public LoginPage loginInShop (String login, String password) {
        open(BASE_URL);
        userName.setValue(login);
        passwordUser.setValue(password);
        buttonLogin.click();
        $x("//div[@class='app_logo']").shouldBe(Condition.visible);
        return  this;
    }

    public LoginPage loginErrorInShop(String login, String password) {
        open(BASE_URL);
        userName.setValue(login);
        passwordUser.setValue(password);
        buttonLogin.click();
        errorField.shouldBe(Condition.visible);
        Assertions.assertEquals(errorText,errorField.getText()); // ОР, ФР
        return  this;
    }


}
