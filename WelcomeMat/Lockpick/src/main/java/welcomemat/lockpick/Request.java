package welcomemat.lockpick;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nick on 4/5/14.
 */
public class Request {
    public static Response get(String path) throws IOException {
        return Request.get(path, new HashMap<String, String>());
    }

    private static void setRequestHeaders(HttpURLConnection http, Map<String, String> headers) {
        for(String field : headers.keySet()) {
            http.setRequestProperty(field, headers.get(field));
        }
    }

    private static Map<String, String> getResponseHeaders(HttpURLConnection http) {
        //gets first string using similar code to the for loop above
        Map<String, String> firsts = new HashMap<String, String>();
        for(String field : http.getHeaderFields().keySet()){
            firsts.put(field, http.getHeaderFields().get(field).get(0));
        }
        return firsts;
    }

    public static Response get(String path, Map<String, String> headers) throws IOException {
        URL url = new URL(path);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try {
            setRequestHeaders(http, headers);
            return new Response(IOUtils.toString(http.getInputStream()), getResponseHeaders(http));
        } finally {
            http.disconnect();
        }
    }

    public static Response post(String path, Map<String, String> data, Map<String, String> headers)
            throws IOException {
        URL url = new URL(path);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try {
            setRequestHeaders(http, headers);

        } finally {
            http.disconnect();
        }

    }
}
