package be.syntra;

import be.syntra.dao.QuoteDao;
import be.syntra.daoimpl.QuoteDaoImpl;
import be.syntra.model.Quote;
import com.github.ricksbrown.cowsay.Cowsay;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    QuoteDao quoteDao = new QuoteDaoImpl();

    Quote quote = quoteDao.getRandomQuote();


    String message = "Hello from Java!";
    String cow = "dragon";
    String[] cowArgs = new String[]{"-f", cow, quote.getAuthor() +" Says: " + quote.getQuote()};
    String result = Cowsay.say(cowArgs);
    System.out.println(result);
    Scanner in = new Scanner(System.in);


    System.out.println("Did you like this quote ? (y/n)");
    while(true) {
      String line = in.nextLine();
      if (line.equalsIgnoreCase("y")) {
        quoteDao.likeQuote(quote);
        break;
      } else if(line.equalsIgnoreCase("n")) {
        quoteDao.dislikeQuote(quote);
        break;
      } else {
        System.out.println("Please enter y/n");
      }
    }



  }
}