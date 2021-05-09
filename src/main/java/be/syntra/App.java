package be.syntra;

import be.syntra.cowsay.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    /**
     * In traditional programming, the flow of the business logic is determined by objects that are statically
     * assigned to one another.
     * With inversion of control, the flow depends on the object graph that is instantiated
     * by the assembler and is made possible by object interactions being defined through abstractions.
     */

    /**
     * Dependency Injection is a technique of creating software in which objects do not create their dependencies on itself.
     * instead objects declare dependencies that they need and it an external object or framework to provide
     * concrete dependencies to objects
     */

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    CowSay cowSay = context.getBean("cowSay", CowSay.class);

    QuoteDao quoteDao = new QuoteDaoMysql();
    cowSay.setQuoteDao(quoteDao);
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