import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(alphabet.contains(in.nextLine()));
    }
}