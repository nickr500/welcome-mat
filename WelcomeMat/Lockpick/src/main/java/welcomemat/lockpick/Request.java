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

    public static Response get(String path, Map<String, String> headers) throws IOException {
        java.net.URL url = new URL(path);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try {
            for(String field : headers.keySet()) {
                http.setRequestProperty(field, headers.get(field));
            }
            //gets first string using similar code to the for loop above
            Map<String, String> firsts = new HashMap<String, String>();
            for(String field : http.getHeaderFields().keySet()){
                firsts.put(field, http.getHeaderFields().get(field).get(0));
            }
            Response magical = new Response(IOUtils.toString(http.getInputStream()), firsts);
            return magical;
        } finally {
            http.disconnect();
        }
    }
    public static Response post() {
        return null;
    }
}
