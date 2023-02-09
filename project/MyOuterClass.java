import java.util.Random;
public class MyOuterClass {
   public static void main ( String [] args ) {
      Random rng = new Random();
      for ( int i = 0;  i < 10; i++) { 
          int x = rng.nextInt() % 100;
          if( x < 0) {
              x *= -1;
          }
          System.out.print(x + ", ");
      }
      System.out.println();
   }
} // end of class