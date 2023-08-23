package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private static final String CONFIG_FILE_PATH = "./config.properties";
    private static Properties properties;

    public static String getUsername() {
        return getProperties().getProperty("username");
    }

    public static String getPassword() {
        return getProperties().getProperty("password");
    }

    private static Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            try {
                FileInputStream inputStream = new FileInputStream(CONFIG_FILE_PATH);
                properties.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }
}
