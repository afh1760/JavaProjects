import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CampEnrollmentApp {
  
  public static void main(String[] args) {
    try {
      List <String> fileLines = Files.readAllLines(Paths.get("sim.txt"));
      CampManager testManager = new CampManager();
      for (int i = 0; i < fileLines.size(); i++) {
        String[] temp = fileLines.get(i).split(" ");
        if (temp[0].equals("E")) {
          try {
            testManager.enrollCamper(new Camper(temp[2], temp[1], Integer.parseInt(temp[3])));
            System.out.println("Enrollment of " + temp[2] + " " + temp[1] + " Successful!");
          } catch (IllegalArgumentException e) {
            System.out.println("This person is too young or too old for Camp Badger.");
          } 
        } else if (temp[0].equals("R")) {
          try {
          testManager.unenrollCamper(new Camper(temp[2], temp[1], 10));
          System.out.println("Unenrollment of " + temp[2] + " " + temp[1] + " Successful!");
          } catch (NoSuchElementException e) {
            System.out.println("That camper is not enrolled.");
          }
        } else if (temp[0].equals("T")) {
          System.out.println("--- " + temp[1] + " TRAVERSAL ---");
          Iterator<Camper> tempIterator = testManager.traverse(temp[1]);
          while(tempIterator.hasNext()) {
            System.out.println(tempIterator.next());
          }
        } else if (temp[0].equals("S")){
          System.out.println("--- Camp Statistics ---");
          System.out.print("Number of Campers: ");
          testManager.printStatistics();
          System.out.println("-----------------------");
        }
      }
    } catch (IOException e) {
    }

  }
}
