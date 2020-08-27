package encryptdecrypt;

import encryptdecrypt.algo.Algorithm;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Parameters params = Parameters.parse(args);

        AlgorithmFactory algoFactory = new AlgorithmFactory();
        Algorithm algorithm = algoFactory.create(params.getAlgorithm(), params.getKey());
        try (InputStream in = openDataProvider(params);
             OutputStream out = openDataConsumer(params)) {
            if (params.getMode() == Mode.ENC) {
                algorithm.encrypt(in, out);
            } else {
                algorithm.decrypt(in, out);
            }
        } catch (IOException exception) {
            System.out.println("Error occurred during invocation!");
            exception.printStackTrace(System.out);
        }
    }

    private static InputStream openDataProvider(Parameters params) {
        return Main.tryGetArgumentDataProvider(params)
                   .or(() -> tryGetFileDataProvider(params))
                   .orElseGet(() -> new ByteArrayInputStream(new byte[0]));
    }

    private static Optional<InputStream> tryGetArgumentDataProvider(Parameters params) {
        return params.tryGetData()
                     .map(data -> data.getBytes(StandardCharsets.UTF_8))
                     .map(ByteArrayInputStream::new);
    }

    private static Optional<InputStream> tryGetFileDataProvider(Parameters params) {
        return params.tryGetInputFile()
                     .map(filename -> {
                         try {
                             return new FileInputStream(filename);
                         } catch (FileNotFoundException ex) {
                             throw new RuntimeException(ex);
                         }
                     });
    }

    private static OutputStream openDataConsumer(Parameters params) {
        return Main.tryGetFileDataConsumer(params)
                   .orElse(System.out);
    }

    private static Optional<OutputStream> tryGetFileDataConsumer(Parameters params) {
        return params.tryGetOutputFile()
                     .map(filename -> {
                         try {
                             return new FileOutputStream(filename);
                         } catch (FileNotFoundException ex) {
                             throw new RuntimeException(ex);
                         }
                     });
    }
}