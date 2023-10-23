// Word Break Problem

import java.util.Arrays;
import java.util.List;

public class Ques_39 {
    public static void wordBreak(List<String> dict, String word, String out) {
        if (word.length() == 0) {
            System.out.println(out);
            return;
        }
        for (int i = 1; i <= word.length(); i++) {
            String prefix = word.substring(0,i);

            if (dict.contains(prefix)) {
                wordBreak(dict, word.substring(i), out + " " + prefix);
            }
        }
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("this", "th", "is", "famous", "Word",
                "break", "b", "r", "e", "a", "k", "br", "bre", "brea", "ak", "problem");
        String word = "Wordbreakproblem";

        wordBreak(dict, word, "");

        if (wordBreak1(dict, word)) {
            System.out.println("The string can be segmented");
        }else{
            System.out.println("The string can't be segmented");
        }
    }

    public static boolean wordBreak1(List<String> dict, String word) {
        if (word.length() == 0) {
            return true;
        }
        for (int i = 1; i <= word.length(); i++) {
            String prefix = word.substring(0, i);

            if (dict.contains(prefix) && wordBreak1(dict, word.substring(i))) {
                return true;
            }
        }
        return false;
    }
}

