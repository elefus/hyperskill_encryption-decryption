package encryptdecrypt;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Parameters {

    private final String algorithm;
    private final Mode mode;
    private final int key;
    private final String data;
    private final String inputFile;
    private final String outputFile;

    private Parameters(String algorithm, Mode mode, int key, String data, String inputFile, String outputFile) {
        this.algorithm = algorithm;
        this.key = key;
        this.mode = mode;
        this.data = data;
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public static Parameters parse(String[] args) {
        Map<String, String> params = new HashMap<>();
        for (int i = 0; i < args.length; i += 2) {
            params.put(args[i], args[i + 1]);
        }

        String data = params.get("-data");
        String in = params.get("-in");
        String out = params.get("-out");
        String algorithm = params.getOrDefault("-alg", "shift");
        int key = Integer.parseInt(params.getOrDefault("-key", "0"));
        Mode mode = Mode.valueOf(params.getOrDefault("-mode", "ENC").toUpperCase());
        return new Parameters(algorithm, mode, key, data, in, out);
    }

    public int getKey() {
        return key;
    }

    public Mode getMode() {
        return mode;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public Optional<String> tryGetData() {
        return Optional.ofNullable(data);
    }

    public Optional<String> tryGetInputFile() {
        return Optional.ofNullable(inputFile);
    }

    public Optional<String> tryGetOutputFile() {
        return Optional.ofNullable(outputFile);
    }
}
