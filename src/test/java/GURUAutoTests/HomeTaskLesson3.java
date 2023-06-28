package GURUAutoTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomeTaskLesson3 {

  /*
 - Откройте страницу Selenide в Github
 - Перейдите в раздел Wiki проекта
 - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
 - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
   */
 @Test
  void selenideInGitHubTest() {
   Configuration.browser = "Chrome";
   open("https://github.com/");
   $x("//input[@ type = 'text']").setValue("Selenide").pressEnter();
   $$x("//a[@class='v-align-middle']").first().click();
   $x("//a[@id = 'wiki-tab']").click();
   $x("//button[@class ='f6 Link--muted js-wiki-more-pages-link btn-link mx-auto']").click();
   $x("//a [text()='SoftAssertions']").shouldHave(text("SoftAssertions")).click();
   $$x("//h4").get(2).shouldHave(text("3. Using JUnit5 extend test class:"));
   $$x("//span[text()='SoftAssertsExtension']").first().should(visible);
   $$x("//span[text()='Test']").get(3).should(visible);
   $$x("//span[text()='click']").get(7).should(visible);

 }

}
