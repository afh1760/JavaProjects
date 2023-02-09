import java.util.Scanner;
public class quiz {
    public static void main ( String [] args ) {
        Scanner stdin = new Scanner( System.in );
        System.out.print(stdin.next());
        System.out.println( stdin.hasNextDouble() );
        while ( stdin.hasNextLine() ) {
            System.out.println( stdin.nextLine() );
        }
    }
}