package saucedemo.shop.rest_api;

import com.codeborne.selenide.Selenide;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import saucedemo.shop.TestBase;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.core.Is.is;

public class RestApiTests  {
    @Test
    public void testDemo() { // Самый простой запрос
        get("https://postman-echo.com/get?name=Jeka3541899").
                then().statusCode(200).
                body("args.name", is("Jeka3541899")).
                body("url",is("https://postman-echo.com/get?name=Jeka3541899"));

    }

    @Test
    public void testDemo2() { // более полный запрос
                given().
                when().log().all().
        get("https://postman-echo.com/get?name=Jeka3541899").
                then().log().all().
                        statusCode(200).
                body("args.name", is("Jeka3541899")).
                body("url",is("https://postman-echo.com/get?name=Jeka3541899"));
    }

    @Test
    public void testDemo3() { // более полный запрос
        given().
                when().log().method().log().uri().
                get("https://postman-echo.com/get?name=Jeka3541899").
                then().log().status().log().body().
                statusCode(200).
                body("args.name", is("Jeka3541899")).
                body("url",is("https://postman-echo.com/get?name=Jeka3541899")).
                body("headers.x-forwarded-port", is("443"));
    }

    @Test
    public void testDemo4() { // изымаем данные из запроса
         Response response = given().
                when().log().method().log().uri().
                get("https://postman-echo.com/get?name=Jeka3541899").
                then().log().status().log().body().
                statusCode(200).
                body("args.name", is("Jeka3541899")).
                body("url",is("https://postman-echo.com/get?name=Jeka3541899")).
                body("headers.x-forwarded-port", is("443")).extract().response();

         String name = response.path("args.name");
        System.out.println("Вот что в стринге : "+ name);
    }
    @Test
    public void postRestTest() {
        Response response = given().
                when().log().method().log().uri().
                body("{\"name\": \"Jenya\", \"job\": \"QA auto\"}").
                post("https://reqres.in/api/users").
                then().log().status().log().body().statusCode(201).
                extract().response();

        String idUser = response.path("id");
        System.out.println("Мы получили id пользователя " + idUser);

    }

    @Test
    public void postRestTest2() {
        String data = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\" }";

        Response response = given().when().
                 contentType(ContentType.JSON).
                 body(data).
                 post("https://reqres.in/api/register").
                 then().log().body().
                 statusCode(200).
                 body("token", is("QpwL5tke4Pnpja7X4")).
                 extract().response();

        String token = response.path("token");
        System.out.println("Token use is :"+ token);
    }
    @Test
    public void missingPasswordTest() {
        String data = "{ \"email\": \"eve.holt@reqres.in\" }";

         given().when().contentType(ContentType.JSON).
                log().uri().log().method().
                body(data).post("https://reqres.in/api/register").
                then().log().status().log().body().statusCode(400).
                body("error", is("Missing password"));
    }


}
