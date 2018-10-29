package Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class LoadProperties {

    public static Properties config = null;

    public static void LoadConfigProperty() throws IOException {
        config = new Properties();
        FileInputStream ConfigFile = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.Properties");
        config.load(ConfigFile);
    }
}
