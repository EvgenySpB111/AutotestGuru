package saucedemo.shop.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class JavaFaker {

    public static void main(String[] args) {
        Faker faker = new Faker(new Locale("ru"));

        
        String name = faker.name().lastName();
        String city = faker.address().cityName();
        String lastName = faker.name().fullName();
        String email = faker.internet().emailAddress();
        System.out.println(name);
    }
}
