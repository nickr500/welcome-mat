package welcomemat.lockpick;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by nick on 4/5/14.
 */
public class Request {
    public static HttpConnection.Response get(String URL, Map<String, String> headers) throws IOException {
        java.net.URL url = new URL(BASE_URL + path);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try {
            Map<String, String> headsWillRoll = generateHeaders(cookie);
            for(String field : headsWillRoll.keySet()) {
                http.setRequestProperty(field, headsWillRoll.get(field));
            }
            IOUtils.toByteArray(http.getInputStream());
        } finally {
            http.disconnect();
        }
        return null;
    }
    public static Response post() {
        return null;
    }
}
