package selenide.helpers;

import org.junit.Test;
import selenide.base.BaseSelenideTest;

import java.io.IOException;

public class ReadProperties extends BaseSelenideTest {
    @Test
    public void readFromConf() throws IOException{
        String urlFromConf = ConfigProvider.URL;

    }
}
