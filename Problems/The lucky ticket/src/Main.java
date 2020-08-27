import java.io.IOException;
import java.io.InputStream;

class Main {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        int left = in.read() + in.read() + in.read();
        int right = in.read() + in.read() + in.read();

        System.out.println(left == right ? "Lucky" : "Regular");
    }
}