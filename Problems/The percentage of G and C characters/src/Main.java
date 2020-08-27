import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        String source = new Scanner(System.in).nextLine();

        long countCG = source.chars()
                             .map(Character::toLowerCase)
                             .filter(sym -> sym == 'c' || sym == 'g')
                             .count();

        System.out.println(100.0 * countCG / source.length());
    }
}