package encryptdecrypt;

import encryptdecrypt.algo.Algorithm;
import encryptdecrypt.algo.EnglishLetterShiftAlgorithm;
import encryptdecrypt.algo.UnicodeAlgorithm;

public class AlgorithmFactory {

    public Algorithm create(String name, int key) {
        switch (name) {
            case "shift":
                return EnglishLetterShiftAlgorithm.create(key);

            case "unicode":
                return UnicodeAlgorithm.create(key);

            default:
                throw new IllegalArgumentException("Requested unknown type of algorithm [" + name + "]!");
        }
    }
}
