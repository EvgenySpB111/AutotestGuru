package junit_test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class JUnitTests {
 @BeforeAll
  static void BeforeAll(){
     Configuration.browser = "Edge";
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
        Assertions.assertEquals(url, $x("//textarea[@class ='gLFyf']").getValue());
    }

    @AfterEach
    void AfterEach(){

    }
    @AfterAll
    static void AfterAll(){
        Selenide.closeWindow();
    }







}
