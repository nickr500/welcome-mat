package welcomemat.lockpick;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.HashMap;

public class Lockpick {
    private static final String BASE_URL = "";
    
    Map<String, String> generateHeaders(String cookie) {
        return null;
    }

    Config getConfig() {
        return null;
    }

    void createConfig() {

    }


    PageInfo scrape(String path, String cookie, boolean getCookie) throws IOException {
        Response resp;
        if(cookie != null) {
            resp = Request.get(BASE_URL + path, generateHeaders(cookie));
        } else {
            resp = Request.get(BASE_URL + path);
        }
        Document doc = Jsoup.parse(resp.getText());

        // Cookie
        String newCookie = null;
        if(getCookie) {
            cookie = resp.getHeaders().get("set-cookie").split(";")[0];
        }

        // Get session token
        Element elem = doc.select("script").get(0);
        String[] parts = elem.text().trim().split("\\s+");
        String part = parts[parts.length - 1];
        String token = part.substring(1, parts.length - 2);
        return new PageInfo(token, cookie);
    }

    // Allison
    String login(Config config) throws IOException {
        // Logs in to the huskycardcenter.neu.edu, returns the user's cookie
        PageInfo sesstokAndLoginCookie = scrape("/login/ldap.php", null, true);

        //maps the username and password to things in a hashmap for some reason
        Map<String, String> data = new HashMap<String, String>();
        data.put("User", config.getUsername());
        data.put("Pass", config.getPassword());

        Response loginImportantString = Request.post("{}/login/ldap.php".format(BASE_URL), data, generateHeaders(sesstokAndLoginCookie.getCookie()));

        String[] parts = loginImportantString.getHeaders().get("set-cookie").split(";");
        String cookie = parts[0];

        if (testLogin(cookie)){
            System.out.println("Login Successful!");
        } else {
            throw new RuntimeException("Login Failed!");
        }

        return cookie;
    }


    boolean testLogin(String cookie) throws IOException {
        Response t = Request.get("{}/student/welcome.php".format(BASE_URL));
        Map<String, String> headers = generateHeaders(cookie);
        return t.getText().equals("Welcome to CS Gold WebCard Center");
    }

    void unlockDoor(String cookie) throws IOException {
        //Takes the user's cookie, sends the request to unlock that door

        PageInfo doorSesstok = this.scrape("/student/openmydoor.php", cookie, false);
        Integer room = 1; //because only dealing with IV and not a suite
        Map<String, String> data = new HashMap<String, String>();
        data.put("doorType", Integer.toString(room));
        data.put("answeredYes", "yes");
        Response unlock = Request.post("{}/student/openmydoor.php".format(BASE_URL), data, generateHeaders(cookie));
    }


    Map<String, String> getArgs() {
       return null;
    }
}
