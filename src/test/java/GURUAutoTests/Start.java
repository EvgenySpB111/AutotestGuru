package GURUAutoTests;



public class Start {
  public static void main(String[] args) {

  String name = "Smorzevskiy";
  char [] array = name.toCharArray();
    System.out.println( "Numbers char in a word  : " + array.length);
    for( int i = 0; i < array.length ; i ++){
      System.out.print( array[i]);
    }
   /*
    for (int i = 1; i < 11; i++) {

      if (i >= 1) System.out.println(i + ". Hello World!");
      if (i == 10) {
        System.out.println("Limit");
      }
    }

    nameQuestion("Jeka");

    for (int i = 0; i < 3; i++) {
      String first = " Hello ";
      String last = ", World ";
      int number = 111;
      char sym = '!';
      System.out.println(number + first + first + last + sym + number);


    }*/

  }

  public static void nameQuestion(String name) {
    System.out.println("Your name " + name);

  }


}
