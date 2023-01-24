package quebec.artm.concerto.api.poc.extensions;

import java.util.Map;

public class HeadersExtensions {
    public static String AccessToken(Map<String, String> headers) {
        return headers.get("Authorization").replace("Bearer", "").trim();
    }
}
