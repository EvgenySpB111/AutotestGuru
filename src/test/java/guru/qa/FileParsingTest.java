package guru.qa;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.json.Json;
import saucedemo.shop.TestBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class FileParsingTest extends TestBase {
 private  String str = "As stated above, JUnit";
    @Test
    void pdfParseTest() throws Exception {
        open("https://junit.org/junit5/docs/current/user-guide/");
        File downloadFilePdf = $x("//a[text()='PDF download']").download();
        PDF textFilePdf = new PDF(downloadFilePdf);
        assertThat(textFilePdf.text).contains(str);
    }

    ClassLoader classLoader = FileParsingTest.class.getClassLoader();

    @Test
    void xlsParseTest() throws Exception {
       try(InputStream resourceAsStream = classLoader.getResourceAsStream("fileTest.xlsx")){
           XLS fileXls = new XLS(resourceAsStream);
           assertThat(fileXls.excel.getSheet("Сотрудник").getRow(0).getCell(1).getStringCellValue().contains("Сергей"));
    }
    }

    @Test
    void csvParseTest() throws Exception {
        try(InputStream resourceAsStream = classLoader.getResourceAsStream("nameTest.csv");
            CSVReader CSVFile = new CSVReader( new InputStreamReader(resourceAsStream)))
        {
            List<String[]> content = CSVFile.readAll();
            String name1 = content.get(1)[1];
            org.junit.jupiter.api.Assertions.assertTrue(name1.equals("Albuk"));

        }
    }

    @Test
    void zipParseTest() throws Exception {
        try(InputStream resourceAsStream = classLoader.getResourceAsStream("zipFile.zip");
            ZipInputStream zis = new ZipInputStream(resourceAsStream))
        {
            ZipEntry zipEntry;
           while ((zipEntry = zis.getNextEntry()) != null) {
               org.junit.jupiter.api.Assertions.assertTrue(zipEntry.getName().equals("zipFile.zip"));
           }

        }
    }

    @Test
    void jsonParse () throws Exception {
        Gson gson = new Gson();
        try(InputStream resourceAsStream = classLoader.getResourceAsStream("jsonFile.json");
            InputStreamReader reader = new InputStreamReader(resourceAsStream))
        {
            JsonObject jsonObject = gson.fromJson(reader,JsonObject.class);
            assertThat(jsonObject.get("name").getAsString()).isEqualTo("Jeka");
            assertThat(jsonObject.get("data").getAsJsonObject().get("year").getAsInt()).isEqualTo(30);
        }
    }



}
