package encryptdecrypt.algo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.temporal.ValueRange;

public class EnglishLetterShiftAlgorithm implements Algorithm {

    private static final int ALPHABET_ENGLISH_LENGTH = 26;
    private static final ValueRange[] ALPHABET_ENGLISH_RANGES = {ValueRange.of('a', 'z'), ValueRange.of('A', 'Z')};
    private final int shift;

    public static Algorithm create(int key) {
        if (key == 0) {
            return new NoEncodeAlgorithm();
        }
        return new EnglishLetterShiftAlgorithm(key);
    }

    private EnglishLetterShiftAlgorithm(int key) {
        this.shift = key;
    }

    @Override
    public void encrypt(InputStream in, OutputStream out) throws IOException {
        encrypt(in, out, shift);
    }

    @Override
    public void decrypt(InputStream in, OutputStream out) throws IOException {
        encrypt(in, out, ALPHABET_ENGLISH_LENGTH - shift);
    }

    private void encrypt(InputStream in, OutputStream out, int shift) throws IOException {
        nextSymbol: for (int sym = in.read(); sym >= 0; sym = in.read()) {
            for (ValueRange range : ALPHABET_ENGLISH_RANGES) {
                if (range.isValidValue(sym)) {
                    int min = (int) range.getMinimum();
                    out.write(min + (sym - min + shift) % ALPHABET_ENGLISH_LENGTH);
                    continue nextSymbol;
                }
            }
            out.write(sym);
        }
    }
}
