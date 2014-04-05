package welcomemat.lockpick;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.HashMap;

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
    String login(Config config){
        // Logs in to the huskycardcenter.neu.edu, returns the user's cookie
        PageInfo sesstokAndLoginCookie = scrape("/login/ldap.php", null, true);

        //maps the username and password to things in a hashmap for some reason
        Map<String, String> data = new HashMap<String, String>();
        data.put("User", config.getUsername());
        data.put("Pass", config.getPassword());

        String loginImportantString = "Holder"; // make this equal to things with requests later . . .
        String[] parts = loginImportantString.split(";");
        String cookie = parts[0];

        return cookie;
    }

    boolean testLogin(String cookie) {

    }

    void unlockDoor(String cookie) {
        //Takes the user's cookie, sends the request to unlock that door

        PageInfo doorSesstok = this.scrape("/student/openmydoor.php", cookie, false);
        Boolean room = true; //because only dealing with IV and not a suite
        Map<String, Boolean> data = new HashMap<String, Boolean>();
        data.put("doorType", room);
        data.put("answeredYes", true);
        String unlock = "Holder"; //here needs to go a request thing

        //and then we're done (the python has test things here)
    }

    Map<String, String> getArgs() {
       return null;
    }

    void unlock() {

    }

}
