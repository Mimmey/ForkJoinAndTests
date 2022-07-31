import java.util.Optional;

public class StringSearcher {
    public static boolean contains(String str, String view) {
        int[] strLetters = new int[26];
        int[] viewLetters = new int[26];

        for (int i = 0; i < str.length(); i++) {
            strLetters[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < view.length(); i++) {
            viewLetters[view.charAt(i) - 'a']++;
        }

        for (int i = 0; i < strLetters.length; i++) {
            if (strLetters[i] < viewLetters[i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean containsAll(String str, String[] views) {
        for (String view : views) {
            if (!contains(str, view)) {
                return false;
            }
        }

        return true;
    }

    public static Optional<String> valueIfContains(String str, String[] views) {
        if (containsAll(str, views)) {
            return Optional.of(str);
        } else {
            return Optional.empty();
        }
    }
}
