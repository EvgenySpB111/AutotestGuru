package saucedemo.shop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import saucedemo.shop.pages.LoginPage;

public class LoginTestError extends TestBase{

   @DisplayName("TestName: Login invalid value")
   @CsvSource({
           "jeka, errorPassword",
           "Albert, secretSouse",
           "standard_user,secret_sauc",
           "Standard_User,secret_sauce"
   })
   @ParameterizedTest(name = "Login invalid value")
    void loginError (String login, String password) {
    new LoginPage().loginErrorInShop(login,password);
    }


}
