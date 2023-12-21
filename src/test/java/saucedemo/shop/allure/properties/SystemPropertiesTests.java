package saucedemo.shop.allure.properties;

import com.sun.javafx.runtime.SystemProperties;
import org.junit.jupiter.api.Tag;

import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

   /* @Tag("test_test")
    @Test
    void simplePropertyTest() {
        // System.setProperty("browser","chrome");
        String browser = System.getProperty("browser", "Edge");
        System.out.println(browser);
        // ./gradlew clean test_test -Dbrowser=safari
        // ./gradlew clean test_test $browser=safari
        // ./gradlew clean test_test -Dbrowser='safari'


    }*/

    @Test
    @Tag("test_test")
    void simpleProperty4Test() {
        System.out.println("Hello, world from " + System.setProperty("country", "unknown"));

        // ./gradlew clean test_test -Dcountry=Russia
        // safari
    }
}
