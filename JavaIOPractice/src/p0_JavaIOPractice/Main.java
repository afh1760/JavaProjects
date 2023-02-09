/*
 * p0_JavaIOPractice 
 * Name : Alexander Francis Hertadi 
 * Email : hertadi@wisc.edu 
 * Lecture : CS400 Lecture 002 
 * Program : This program asks data from the person asking name, how long they have been
 * studying cs for, and a super secret important question. The answer are recorded in a text file
 * then outputted at the end of the program.
 */
package p0_JavaIOPractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
  private static final Scanner sc = new Scanner(System.in); // scanner object
  private final String title = "Alexander Hertadi \nhertadi@wisc.edu \nLec002"; // to be printed at
                                                                                // the start of the
                                                                                // program

  /**
   * Method to return content of the private field title.
   * 
   * @return
   */
  private String getTitle() {
    return this.title;
  }

  public static void main(String[] args) {
    Main testInstance = new Main(); // creates instance for main
    System.out.println(testInstance.getTitle());
    System.out.println("****************************************************************");
    System.out.print("Give me your name, now. ");
    String answer1 = sc.nextLine(); // input for name
    FileWriter logF = null; // initializes the file writer for use of this whole program

    try {
      logF = new FileWriter("log.txt"); // initializes the text file log.txt or enters it for
                                        // writing
    } catch (IOException e2) {
      e2.printStackTrace();
    }

    PrintWriter log = null;
    log = new PrintWriter(logF); // initializes the writing in log.txt
    log.println(testInstance.getTitle());
    // First question and input/output
    log.println("****************************************************************");
    log.println("Give me your name, now. ");
    log.println(answer1);

    // code to ensure there exists a non-empty input for answer1
    while (answer1.length() == 0) {
      System.out.println("ENTER A NAME!!! DO IT NOW!!!");
      answer1 = sc.nextLine();
      log.println("ENTER A NAME!!! DO IT NOW!!!");
      log.println(answer1);
    }

    // Second question
    System.out
        .print("So, " + answer1 + ", in months, how long have you been learning how to code? ");
    log.println("So, " + answer1 + ", in months, how long have you been learning how to code? ");
    int answer2 = 0;
    // to ensure an integer is inputed, or else will yeild other response
    try {
      answer2 = Integer.parseInt(sc.nextLine());
      log.println(answer2);
      if (answer2 == 0) {
        System.out.println("Great I guess you do not code then. Shameful...");
        log.println("Great I guess you do not code then. Shameful...");
      } else {
        System.out
            .println("Well, " + answer1 + ", " + answer2 + " months is good progress! I Approve!");
        log.println("Well, " + answer1 + ", " + answer2 + " months is good progress! I Approve!");
      }
    } catch (NumberFormatException e) {
      System.out.println(
          "I guess you can't even enter numbers... Shamefull... You do NOT get another chance!");
      log.println(
          "I guess you can't even enter numbers... Shamefull... You do NOT get another chance!");
    }

    // delay to increase dramatic effect
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
    }
    System.out.println("For the next act, we will now let you choose a file.");
    log.println("For the next act, we will now let you choose a file.");

    // this is where the file containing the list of accepted answers is selected
    System.out.print("Type in file: ");
    log.println("Type in file: ");
    String fileName = sc.nextLine();
    log.println(fileName);
    Scanner sc2 = null;
    // loops until file is found
    do {
      try {
        File input = new File(fileName);
        sc2 = new Scanner(input);
        break;
      } catch (FileNotFoundException e) {
        System.out.println("file not found");
        log.println("file not found");
      }
      System.out.print("Type in file: ");
      log.println("Type in file: ");
      fileName = sc.nextLine();
      log.println(fileName);
    } while (true);

    System.out.println("****************************************************************");
    System.out.println("WELLL, this is the MOST important QUESTION of them ALL!!!!!!");
    System.out.println("Loading..............");
    System.out.println("****************************************************************");
    log.println("****************************************************************");
    log.println("WELLL, this is the MOST important QUESTION of them ALL!!!!!!");
    log.println("Loading..............");
    log.println("****************************************************************");

    // more delays
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
    }
    System.out.println("WHO. IS. YOUR. FAVORITE. TABLE TENNIS PLAYER???????????");
    System.out.println("Choose wisely, or suffer the berating that awaits......");
    log.println("WHO. IS. YOUR. FAVORITE. TABLE TENNIS PLAYER???????????");
    StringBuffer oneLine = new StringBuffer(); // this is used fo the text file iteration

    while (sc2.hasNextLine()) {
      oneLine.append(sc.nextLine()).append("\n");
    }
    System.out.println(oneLine);
    log.println(oneLine);
    log.println("Choose wisely, or suffer the berating that awaits......");
    String answer3 = sc.nextLine();
    log.println(answer3);
    // code to ensure there exists a non-empty input for answer1
    while (answer3.length() == 0) {
      System.out.println("ENTER A NAME!!! DO IT NOW!!!");
      answer3 = sc.nextLine();
      log.println("ENTER A NAME!!! DO IT NOW!!!");
      log.println(answer3);
    }
    String[] players = {"Xu Xin", "Ma Long", "Waldner", "Liu Shiwen"};
    boolean valid = false;
    for (int i = 0; i < players.length; i++) {
      if (answer3.equals(players[i])) {
        valid = true;
        break;
      }
    }

    if (valid == true) {
      System.out.println(answer3 + "!???? WISE CHOICE! HAVE A GREAT DAY!!!");
      log.println(answer3 + "!???? WISE CHOICE! HAVE A GREAT DAY!!!");
    } else {
      System.out.println("You have brought shame to us all.........");
      log.println("You have brought shame to us all.........");
    }
    System.out.println("****************************************************************");
    log.println("****************************************************************");
    log.close();

    PrintWriter output = null; // initializes output.txt and writes the data below/entered
    try {
      output = new PrintWriter(new FileWriter("output.txt"));
      output.println("Name              : " + answer1);
      output.println("HOW LONG CS STUDY : " + answer2);
      output.println("FAVORITE PLAYER   : " + answer3);
      output.close();
    } catch (IOException e1) {
      System.out.println("FILE NOT FOUND");
    }


  }
}
