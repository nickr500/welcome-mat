package welcomemat.lockpick;

/**
 * Created by nick on 4/5/14.
 */
public class Config {
    private String username;
    private String password;

    public Config(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
