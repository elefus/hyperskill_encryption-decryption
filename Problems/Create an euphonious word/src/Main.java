import java.util.Scanner;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(calcEuphoniousWord(in.next()));
    }

    private static int calcEuphoniousWord(String word) {
        Predicate<Character> isVowel = sym -> "aeiouy".indexOf(sym) >= 0;
        Predicate<Character> groupChecker = isVowel.test(word.charAt(0)) ? isVowel : isVowel.negate();

        int result = 0;
        int groupLength = 1;
        for (int i = 1; i < word.length(); ++i) {
            if (groupChecker.test(word.charAt(i))) {
                if (++groupLength == 3) {
                    ++result;
                    groupLength = 1;
                }
            } else {
                groupLength = 1;
                groupChecker = groupChecker.negate();
            }
        }

        return result;
    }
}