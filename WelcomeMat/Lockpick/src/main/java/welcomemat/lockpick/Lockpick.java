package welcomemat.lockpick;


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
    PageInfo scrape(String path, String cookie, boolean getCookie) {
        return null;
    }

    // Allison
    String login(Config config){
        // Logs in to the huskycardcenter.neu.edu, returns the user's cookie
        PageInfo sesstokAndLoginCookie = scrape("/login/ldap.php", null, true);

        //maps the username and password to things in a hashmap for some reason
        Map<String, String> data = new HashMap<String, String>();
        this.data.put("User", config.getUsername());
        this.data.put("Pass", config.getPassword());

        String loginImportantString = "Holder"; // make this equal to things with requests later . . .
        String[] parts = loginImportantString.split(";");
        String cookie = parts[0];

        return cookie;
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
