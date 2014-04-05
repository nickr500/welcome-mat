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
    String login(Config config) {
        // Logs in to the huskycardcenter.neu.edu, returns the user's cookie
        
        return null;
    }

    /*def login(config):
            """ Logins in to huskycardcenter.neu.edu, returns user cookie """

            if args.verbose: print '[+] Logging in...'
    sesstok, login_cookie = scrape('/login/ldap.php', None, True)
    data = {
        '__sesstok': sesstok,
                'user': config['USER'],
                'pass': config['PASS']
    }
    login = requests.post('{}/login/ldap.php'.format(BASE_URL),
    data=data,
    headers=generate_headers(login_cookie),
    allow_redirects=False)
    cookie = login.headers['set-cookie'].split(';')[0]

            if args.verbose: print '\t[i] Got user cookie: {}'.format(cookie)

    if test_login(cookie):
            if args.verbose: print '[+] Login Successful!'
            else:
    print '[-] Login Failed!'
    print '[-] Exiting'
            sys.exit()

            return cookie*/

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
