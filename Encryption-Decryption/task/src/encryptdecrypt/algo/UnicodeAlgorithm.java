package encryptdecrypt.algo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class UnicodeAlgorithm implements Algorithm {

    private final int shift;

    public static Algorithm create(int key) {
        if (key == 0) {
            return new NoEncodeAlgorithm();
        }
        return new UnicodeAlgorithm(key);
    }

    private UnicodeAlgorithm(int key) {
        shift = key;
    }

    @Override
    public void encrypt(InputStream in, OutputStream out) throws IOException {
        encrypt(in, out, shift);
    }

    @Override
    public void decrypt(InputStream in, OutputStream out) throws IOException {
        encrypt(in, out, -shift);
    }

    private void encrypt(InputStream in, OutputStream out, int shift) throws IOException {
        for (int sym = in.read(); sym >= 0; sym = in.read()) {
            out.write(sym + shift);
        }
    }
}
