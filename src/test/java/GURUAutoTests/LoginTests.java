package GURUAutoTests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DownloadOptions;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginTests {
  /*
  Открыть авторизацию ...
   */


@Test
void successFullLoginTest() {
  open("https://qa.guru/cms/system/login");
  Configuration.holdBrowserOpen = true;
  //$(".login-form").shouldHave(text("Войти"));
  $x("(//h2)[1]").shouldHave(text("Войти"));
  $x("(//input[@ name = 'email'])[1]").setValue("qagurubot@gmail.com");
  $x("(//input[@type ='password'])[1]").setValue("qagurupassword").pressEnter();
  $(".main-header__login").click();
  Selenide.closeWindow();

}
@Test
  void unSuccessFullLoginTest() {
  Configuration.holdBrowserOpen = true;
  Configuration.browser = "Chrome";

  open("https://google.ru");
  $x("//textarea [@ name = 'q']").setValue("Погода в Питере").pressEnter();
  $x("//span[@ class ='BBwThe']").shouldHave(text("Санкт-Петербург"));
  $x("//textarea [@ name = 'q']").clear();
  $x("//textarea [@ name = 'q']").setValue("Погода в Рыбнице").pressEnter();
  //System.out.println($x("//span[@ class = 'BBwThe']").getText());
  $x("//span[@ class = 'BBwThe']").shouldHave(text("Рыбница, Молдавия"));
  closeWindow();

}
@Test
  void checkGitHubTitle() {      // Проверяем что в поисковой выдаче первое значение  = selenide
  Configuration.browser = "Chrome";
  open("https://github.com/");
  $x("//input [@ type ='text']").setValue("Selenide").pressEnter();
  $x("(//a [@ class ='v-align-middle'])[1]").shouldHave(text("selenide/selenide"));
  $x("(//a [@ class ='v-align-middle'])[1]").click();
  $x("//a [@ rel ='author']").shouldHave(text("selenide"));

  //closeWindow();
}
  @Test
  void checkGitHubTitle2() {      // Проверяем что в поисковой выдаче первое значение  = selenide
    Configuration.browser = "Chrome";
    open("https://github.com/");
    $x("//input [@ type ='text']").setValue("Selenide").pressEnter();
    String title = $$x("(//a [@ class ='v-align-middle'])[1]").first().getText();
    Assertions.assertEquals("selenide/selenide", title);
    sleep(1000);
    closeWindow();
  }

  @Test
  void checkGitHubTitle3() {      // Проверяем что в поисковой выдаче первое значение  = selenide
    Configuration.browser = "Chrome";
    open("https://github.com/");
    $x("//input [@ type ='text']").setValue("Selenide").pressEnter();
    String title = $$x("//a [@ class ='v-align-middle']").get(2).getText();
    sleep(2000);
   // Assertions.assertEquals("selenide/selenide", title);
    System.out.println(title);
    closeWindow();
  }
  @Test
  void openGitHubTest() {         // Проверяем имя в карточке главного создателя selenide
  Configuration.browser = "Chrome";
  open("https://github.com/");
  $x("//input[@type ='text']").setValue("selenide").pressEnter();
  $$x("// a [@class='v-align-middle']").get(0).click();
  $x("//img[ @src = 'https://avatars.githubusercontent.com/u/279773?s=64&v=4']").hover();
  $x("//a [@ class ='Link--secondary no-underline ml-1']").shouldHave(text("Andrei Solntsev"));


  }

  @Test
  void testAlertConfirm() {
    Configuration.browser = "Chrome";

    open("http://the-internet.herokuapp.com/dropdown");
    $x("//select").click();
    $x("//option [@ value = '1']").click();
    $x("//select").shouldBe(cssClass("class"));
    $x("//select").shouldBe(checked);
  }
    @Test
    void downloadFile() throws FileNotFoundException {
      $x("//select").shouldHave(cssValue()
    File file1 = $x("//select").download(DownloadOptions.using(FileDownloadMode.FOLDER));


    Selenide.sleep(3000);

  }
}



