package saucedemo.shop.utils;

import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Random;


public class RandomUtils {

    public static void main(String[] args) {
       //  System.out.println(randomName());
       // System.out.println(randomNumber(10));

      String [] names = {"Jeka","Albert","Vanya","Sergey","Sacha","Vova"};
        System.out.println(randomChar(names));




    }

    public static String randomText (int len) {
        String AB = "qwertyuiopasFGHJKlzxcvNM";
        SecureRandom scr = new SecureRandom();
        StringBuilder SB = new StringBuilder(len);
        for( int i = 0 ; i< len; i++) {
            SB.append(AB.charAt(scr.nextInt(AB.length())));
        }
        return SB.toString();
    }

    public static String randomEmail () {
        return  randomText(8) + "@email.ru";
    }

    public static String randomName() {
        return randomText(1).toUpperCase() + randomText(4).toLowerCase();
    }

    public static String randomNumber(int length) {
        Random random = new Random();
        String number2 = "";
        for( int i = 0; i < length; i ++){
            int number = random.nextInt(10);
            String str = Integer.toString(number);
            number2 += str;
            System.out.println(number);
        }
        return number2;
    }

    public static String randomChar( String [] values) {
     Random random = new Random();
     int index = random.nextInt(values.length - 1);
     return values[index];
    }


}
