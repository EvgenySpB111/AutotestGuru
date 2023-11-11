package guru.qa;


import org.junit.jupiter.api.Assertions;

import java.sql.SQLOutput;
import java.util.*;

public class Start {
    public static void main(String[] args) {


    }
    public void checkListLstNames(String name, List<String> strings) {
        boolean check = false;
        for(String str: strings){
            if( str.equals(name)){
                check = true;
            }
        }
        System.out.println(check);
    }

    public boolean checkNumber1Big( int number1, int number2) {
        return number1 > number2;
    }
            }




