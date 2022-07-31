import org.junit.Assert;
import org.junit.Test;

public class StringSearcherTest {
    @Test
    public void checkIsSubsetTrue() {
        String word = "facebook";
        String[] words2 = {"e","o"};

        Assert.assertEquals("facebook", StringSearcher.valueIfContains(word, words2).orElse(null));
    }

    @Test
    public void checkIsSubsetFalse() {
        String word = "amazon";
        String[] words2 = {"e","o"};

        Assert.assertNotEquals("facebook", StringSearcher.valueIfContains(word, words2).orElse(null));
    }
}
