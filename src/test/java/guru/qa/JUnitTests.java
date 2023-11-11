package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class JUnitTests {
 @BeforeAll
  static void BeforeAll(){
     Configuration.browser = "chrome";
     Configuration.browserSize = "1920x1080";


 }
    @BeforeEach
    void BeforeEach(){


    }


    @Test
    void JUnitTest_1(){
        String url = "Hello, World!";
        open("https://www.google.ru");
        $x("//textarea[@class ='gLFyf']").click();
        $x("//textarea[@class ='gLFyf']").setValue(url).click();
       // Assertions.assertEquals(url, $x("//textarea[@class ='gLFyf']").getValue());  // длинный способ
        $x("//textarea[@class ='gLFyf']").shouldHave(value("Hello, World!")); // короткий способ
    }

    @Test
    void testTextBox(){
        open("https://papteki.ru/");

        $x("//a [@ aria-label='Личный кабинет']").click();
        $x("//a [text() = 'Еще не зарегистрированы?']").click();
        $x("//div[text() = ' Регистрация']").shouldHave(text(" Регистрация"));
        $x("//input[@name= 'FirstName']").setValue("Евгений");
        $x("//input[@name= 'LastName']").setValue("ФрикацелЬ");
        $x("//input[@id = 'modal-tel']").setValue("9967794511");
        $x("//input[@id = 'set-data']").scrollIntoView(false);
        $x("//label[@for = 'text2']").click();
        $x("//input[@id = 'set-data']").setValue("01111992");
        $x("//label [@for ='modal-check']").click();

        $x("//label [@for ='modal-check']").shouldNotBe(checked);
        Assertions.assertEquals($x("//input[@id = 'modal-name']").getValue(),"Евгений");
        Assertions.assertEquals($x("//input[@name= 'LastName']").getValue(),"ФрикацелЬ");
        Assertions.assertEquals($x("//input[@id = 'modal-tel']").getValue(),"+7 996 7794511");
        $x("//button[text()='Зарегистрироваться']").click();
        $x("//div[text() = 'Ошибка проверки на робота']").shouldBe(text("Ошибка проверки на робота"));

    }

    @AfterEach
    void AfterEach(){

    }
    @AfterAll
    static void AfterAll(){
        Selenide.closeWindow();
    }







}
