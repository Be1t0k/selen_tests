package helpers;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();
    static Config readConfig(){
        return ConfigFactory.load("application.conf");
    }
    String URL = readConfig().getString("url");
    String EMAIL = readConfig().getString("email");
    String PASSWORD = readConfig().getString("password");
    String SEARCH_DATA = readConfig().getString("urlParams.search_data");

}
