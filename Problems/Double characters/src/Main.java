import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        StringBuilder result = new StringBuilder(str.length() * 2);
        for (char sym : str.toCharArray()) {
            result.append(sym).append(sym);
        }
        System.out.println(result);
    }
}