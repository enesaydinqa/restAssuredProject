package Properties;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public abstract class SetProperties {

    public static void SetValueProperties() throws Exception {

        Properties prop = new Properties();
        OutputStream output = null;
        output = new FileOutputStream(System.getProperty("user.dir") + "/src/test/resources/config.Properties");

        prop.setProperty("baseURI", "https://app.base7.io");
        prop.setProperty("username", "admin");
        prop.setProperty("password", "admin123");

        prop.store(output, null);

    }
}
