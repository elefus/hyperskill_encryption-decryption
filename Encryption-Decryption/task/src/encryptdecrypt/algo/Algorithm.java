package encryptdecrypt.algo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Algorithm {

    void encrypt(InputStream in, OutputStream out) throws IOException;

    void decrypt(InputStream in, OutputStream out) throws IOException;
}
