import java.util.*;
import java.util.concurrent.ForkJoinPool;

public class Solution {
    public static Set<String> wordSubsets(String[] words1, String[] words2) {
        ForkJoinPool pool = new ForkJoinPool();
        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Counter counter = new Counter(words1, words2, set);
        Set<String> result = pool.invoke(counter);
        pool.shutdown();
        return result;
    }
}
