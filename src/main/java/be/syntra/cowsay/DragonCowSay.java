package be.syntra.cowsay;
import com.github.ricksbrown.cowsay.Cowsay;
import java.util.Scanner;

public class DragonCowSay implements CowSay {
    QuoteDao quoteDao;
    Quote quote;


    public DragonCowSay() {
        quoteDao = new QuoteDaoDummy();
    }

    @Override
    public void showQuote() {
        quote = quoteDao.getRandomQuote();
        String cow = "dragon";
        String[] cowArgs = new String[]{"-f", cow, quote.getAuthor() +" Says: " + quote.getQuote()};
        String result = Cowsay.say(cowArgs);
        System.out.println(result);
    }

    @Override
    public void voteUp() {
        quoteDao.likeQuote(quote);
    }

    @Override
    public void voteDown() {
        quoteDao.dislikeQuote(quote);
    }
}