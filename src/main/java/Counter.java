import java.util.*;
import java.util.concurrent.RecursiveTask;

public class Counter extends RecursiveTask<Set<String>> {
    String[] strings;
    String[] views;
    static Set<String> set;

    Counter(String[] strings, String[] views, Set<String> set) {
        this.strings = strings;
        this.views = views;
        Counter.set = set;
    }

    @Override
    protected Set<String> compute() {
        if (strings.length == 1) {
            Optional<String> optString = StringSearcher.valueIfContains(strings[0], views);
            optString.ifPresent(set::add);
            return set;
        }

        Counter firstHalfCounter = new Counter(Arrays.copyOfRange(strings, 0, strings.length / 2), views, set);
        Counter secondHalfCounter = new Counter(Arrays.copyOfRange(strings, strings.length / 2, strings.length), views, set);
        firstHalfCounter.fork();
        secondHalfCounter.fork();
        firstHalfCounter.join();
        secondHalfCounter.join();
        return set;
    }
}