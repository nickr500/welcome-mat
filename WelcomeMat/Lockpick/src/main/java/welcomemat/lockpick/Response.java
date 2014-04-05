package welcomemat.lockpick;

import java.util.Map;

/**
 * Created by nick on 4/5/14.
 */
public class Response {
    private String text;
    private Map<String, String> headers;

    public Response(String text, Map<String, String> headers) {
        this.text = text;
        this.headers = headers;
    }

    public String getText() {
        return text;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}
