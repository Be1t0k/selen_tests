package selenium.helpers;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();
    static Config readConfig(){
        return ConfigFactory.load("application.conf");
    }
    String URL = readConfig().getString("url");
    String LOGIN_URL = readConfig().getString("loginUrl");
    String EMAIL = readConfig().getString("loginParams.emails.email");
    String INCORRECT_EMAIL = readConfig().getString("loginParams.emails.incorrect_email");
    String PASSWORD = readConfig().getString("loginParams.passwords.password");
    String SEARCH_DATA = readConfig().getString("searchParams.search_data");
    String WRONG_SEARCH_DATA = readConfig().getString("searchParams.wrong_search_data");

}
