package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import saucedemo.shop.TestBase;

import javax.crypto.ExemptionMechanismException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static com.codeborne.selenide.Selenide.*;

public class SelenideFileTest extends TestBase {

    @Test
    void selenideDownloadTest() throws IOException {
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File fileReadme = $x("//a[@data-testid ='raw-button']").download();
        try(InputStream is = new FileInputStream(fileReadme)){
            byte[] readme = is.readAllBytes();
            String textReadme = new String(readme, StandardCharsets.UTF_8);
            Assertions.assertTrue(textReadme.contains("This repository is the home of"));
        }

    }

    @Test
    void selenideUploadFile() {
        open("https://fineuploader.com/demos.html");
        $x("//input[@type ='file']").uploadFromClasspath("screen.png");
        $x("//span[@title='screen.png']").shouldHave(Condition.text("screen.png"));
    }


}
