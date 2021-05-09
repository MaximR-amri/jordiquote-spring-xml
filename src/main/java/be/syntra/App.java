package be.syntra;

import be.syntra.cowsay.*;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    CowSay cowSay = new DragonCowSay();
    cowSay.showQuote();
    Scanner in = new Scanner(System.in);
    System.out.println("Did you like this quote ? (y/n)");
    while(true) {
      String line = in.nextLine();
      if (line.equalsIgnoreCase("y")) {
        cowSay.voteDown();
        break;
      } else if(line.equalsIgnoreCase("n")) {
        cowSay.voteUp();
        break;
      } else {
        System.out.println("Please enter y/n");
      }
    }


  }
}