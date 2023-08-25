package selenide.helpers;

import org.junit.Test;
import selenium.base.BaseSeleniumTest;

import java.io.IOException;

public class ReadProperties extends BaseSeleniumTest {
    @Test
    public void readFromConf() throws IOException{
        String urlFromConf = ConfigProvider.URL;

    }
}
