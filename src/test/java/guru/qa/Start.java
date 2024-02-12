package guru.qa;

import java.util.*;

public class Start {
    public static void main(String[] args) {


        for(int x = 0; x < 10; x++) {
            System.out.println("test" + x);
        }
        List<String> underNames = new ArrayList<>();
        underNames.add("Albert");
        underNames.add("Vova");
        underNames.add("Yana");
        underNames.add("Jenia");
        checkListLstNames("Jenia",underNames);



    }
    public static void checkListLstNames(String name, List<String> strings) {
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




