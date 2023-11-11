package saucedemo.shop;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import saucedemo.shop.pages.LoginPage;
import saucedemo.shop.utils.RandomUtils;
import saucedemo.shop.utils.Screenshot;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;

public class LoginTestSuccess extends TestBase{

    String login = RandomUtils.randomText(6);
    String password = RandomUtils.randomText(10);

    @DisplayName("TestName: success login ")
 //   @ValueSource(strings = {"Allure","Selenide"})
    @CsvSource({
            "standard_user,secret_sauce",
            "problem_user,secret_sauce"
    })
    @ParameterizedTest(name ="Test login valid data ")
    void LoginPageSuccess (String login,String password){
        new LoginPage().loginInShop(login,password);
    }

    @Test
    void randomDataForTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        Faker faker = new Faker(new Locale("it"));
        String name = faker.name().lastName();
        String lastName = faker.name().fullName();

        open("https://www.saucedemo.com/");
        $x("//input[@name ='user-name']").setValue(name);
        $x("//input[@name ='password']").setValue(lastName);
        $x("//input[@name='login-button']").click();
        Screenshot sc = new Screenshot();
        sc.takeScreenshot();

    }




}
