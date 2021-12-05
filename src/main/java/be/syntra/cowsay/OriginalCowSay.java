package be.syntra.cowsay;
import com.github.ricksbrown.cowsay.Cowsay;
import org.springframework.beans.factory.annotation.Autowired;

public class OriginalCowSay implements CowSay {
    private QuoteDao quoteDao;
    private Quote quote;


    public OriginalCowSay(QuoteDao quoteDao) {
        this.quoteDao = quoteDao;
    }


    @Override
    public void showQuote() {
        quote = quoteDao.getRandomQuote();
        String cow = "dragon";
        String[] cowArgs = new String[]{quote.getAuthor() +" Says: " + quote.getQuote()};
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
