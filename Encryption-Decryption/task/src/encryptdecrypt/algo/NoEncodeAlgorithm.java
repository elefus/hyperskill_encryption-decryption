package encryptdecrypt.algo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class NoEncodeAlgorithm implements Algorithm {

    @Override
    public void encrypt(InputStream in, OutputStream out) throws IOException {
        in.transferTo(out);
    }

    @Override
    public void decrypt(InputStream in, OutputStream out) throws IOException {
        in.transferTo(out);
    }
}
