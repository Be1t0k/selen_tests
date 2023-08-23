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
    String LOGINURL = readConfig().getString("urlParams.loginUrl");
    String REGISTERURL = readConfig().getString("urlParams.registerUrl");

}
