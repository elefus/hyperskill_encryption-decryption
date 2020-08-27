import java.io.IOException;
import java.io.InputStream;

class Main {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;

        StringBuilder result = new StringBuilder();
        int cur;
        int groupLen = 1;
        for (int prev = in.read(); prev > 0; prev = cur, ++groupLen) {
            cur = in.read();
            if (cur != prev) {
                result.append((char) prev).append(groupLen);
                groupLen = 0;
            }
        }

        System.out.println(result);
    }
}