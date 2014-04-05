package welcomemat.lockpick;


import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class Lockpick {
    Map<String, String> generateHeaders(String cookie) {
        return null;
    }

    Config getConfig() {
        return null;
    }

    void createConfig() {

    }

    // Nick
    PageInfo scrape(String path, String cookie, boolean getCookie) throws IOException {
        URL url = new URL(BASE_URL + path);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try {
            Map<String, String> headers = generateHeaders(cookie);
            for(String field : headers.keySet()) {
                http.setRequestProperty(field, headers.get(field));
            }
            IOUtils.toByteArray(http.getInputStream());
            Document soup = Jsoup.parse(http.getInputStream(), "UTF-8", url.toString());
            soup.
        } finally {
           http.disconnect();
        }
        return null;
    }

    // Allison
    String login(Config config) {
        return null;
    }

    boolean testLogin(String cookie) {

    }

    void unlockDoor(String cookie) {

    }

    Map<String, String> getArgs() {
       return null;
    }

    void unlock() {

    }

}
