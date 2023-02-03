package devsecops.template.api.java.extensions;

import java.util.Map;

public class HeadersExtensions {
    public static String AccessToken(Map<String, String> headers) {
        return headers.get("Authorization").replace("Bearer", "").trim();
    }
}
