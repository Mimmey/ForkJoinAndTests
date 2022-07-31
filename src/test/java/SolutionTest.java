import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class SolutionTest {
    @Test
    public void check() {
        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"e","o"};
        Assert.assertEquals(Set.of("facebook", "google", "leetcode"),
                Solution.wordSubsets(words1, words2));
    }

    @Test
    public void check2() {
        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"e","l"};
        Assert.assertEquals(Set.of("apple", "google", "leetcode"),
                Solution.wordSubsets(words1, words2));
    }

    @Test
    public void check3() {
        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"lo","eo"};
        Assert.assertEquals(Set.of("google", "leetcode"),
                Solution.wordSubsets(words1, words2));
    }

    @Test
    public void check4() {
        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"oo","e"};
        Assert.assertEquals(Set.of("google", "facebook"),
                Solution.wordSubsets(words1, words2));
    }

    @Test
    public void checkFalse() {
        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"e","o"};
        Assert.assertNotEquals(Set.of("amazon","apple","facebook","google","leetcode"),
                Solution.wordSubsets(words1, words2));
    }
}
