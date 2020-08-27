import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String url = in.nextLine();
        Map<String, String> params = parseParameters(url.split("\\?")[1]);

        params.forEach((param, value) -> System.out.println(param + " : " + value));
        Optional.ofNullable(params.get("pass"))
                .ifPresent(pass -> System.out.println("password : " + pass));
    }

    private static Map<String, String> parseParameters(String url) {
        HashMap<String, String> result = new LinkedHashMap<>();
        for (String param : url.split("&")) {
            String[] parts = param.split("=");
            result.put(parts[0], parts.length == 2 ? parts[1] : "not found");
        }
        return result;
    }
}