package saucedemo.shop.rest_api;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.core.Is.is;

public class RestApiTests  {
    @Tag("rest")
    @Test
    public void testDemo() { // Самый простой запрос
        get("https://postman-echo.com/get?name=Jeka3541899").
                then().statusCode(200).
                body("args.name", is("Jeka3541899")).
                body("url",is("https://postman-echo.com/get?name=Jeka3541899"));
       // тест коммент
    }
    @Tag("rest")
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
    @Tag("rest")
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
    @Tag("rest")
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
    @Tag("rest")
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

    @Tag("rest")
    @Test
    public void postRestTestFormParam() {
        
        Response response = given().
                when().log().method().log().uri().
                contentType("application/x-www-form-urlencoded; charset= UTF-8").
                formParam("name","Jenya").
                formParam("job", "QA").
                post("https://reqres.in/api/users").
                then().log().status().log().body().statusCode(201).
                extract().response();

        String idUser = response.path("id");
        System.out.println("Мы получили id пользователя " + idUser);
    }
    @Tag("rest")
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
    @Tag("rest")
    @Test
    public void missingPasswordTest() {
        String data = "{ \"email\": \"eve.holt@reqres.in\" }";

         given().when().contentType(ContentType.JSON).
                log().uri().log().method().
                body(data).post("https://reqres.in/api/register").
                then().log().status().log().body().statusCode(400).
                body("error", is("Missing password"));
    }

    @Tag("rest")
    @Test
    public void apiTestSletter() {
        String textResponse = "Thank you for signing up! A verification email has been sent. We appreciate your interest.";
                given().when().
                contentType("application/x-www-form-urlencoded; charset=UTF-8").
                log().all().
                formParam("email","lora12@email.com").
                post("https://demowebshop.tricentis.com/subscribenewsletter").
                then().log().all().statusCode(200).
                  body("Success", is(true)).
                  body("Result",is(textResponse));

    }
    @Tag("rest")
    @Test
    public void addProductToCart() {
        String cookie = "ARRAffinity=08de7553c98a126b311a9fbb1c3917e9720f52e597f80f56eb8cb87735dafbe0;" +
                " ARRAffinitySameSite=08de7553c98a126b311a9fbb1c3917e9720f52e597f80f56eb8cb87735dafbe0;" +
                " NOPCOMMERCE.AUTH=7096D965881438AC6FB30D2E4D05F6BBA294EB65A473456BF831AFB02BB764819D3E2" +
                "1A9067C1BE339E2695E855CFBC00C475A9EE787A9916B216E2BBE498DEA36D837E7BA6AE7B94360F275EDC5" +
                "89A3FC3FC9FDD6F0681DBC8FF9780B0ACD451806EEE0981BE0E9B4BEC2E8C538791A36391385BFC7FD97192" +
                "85E52001E8236A64C15474169AFFA963A71614DA15E0F; Nop.customer=86c752a5-19fb-4556-a0e6-a" +
                "edd253b812f";
        given().when().
                contentType("application/x-www-form-urlencoded; charset=UTF-8").
                //cookie(cookie).
                log().all().
                formParam("giftcard_2.RecipientName","Vitya").
                formParam("giftcard_2.RecipientEmail","lora11@mail.com").
                formParam("giftcard_2.SenderName","Jeka").
                formParam("giftcard_2.SenderEmail", "lora12@email.com").
                formParam("addtocart_2.EnteredQuantity"," 1").
                post("https://demowebshop.tricentis.com/addproducttocart/details/2/1").
                then().log().all().statusCode(200).
                body("success",is(true)).
                body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>")).
                body("updatetopcartsectionhtml", is("(1)"));
    }


}
