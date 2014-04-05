package welcomemat.lockpick;

/**
 * Created by nick on 4/5/14.
 */
public class PageInfo {
    private String sessionToken;
    private String cookie;

    public PageInfo(String sessionToken, String cookie) {
        this.sessionToken = sessionToken;
        this.cookie = cookie;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public String getCookie() {
        return cookie;
    }
}
