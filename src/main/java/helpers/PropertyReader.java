package helpers;


import java.io.IOException;

public class PropertyReader {

    public static String readProperty(String key) {
        loadProperties();
        return System.getProperty(key);
    }

    private static void loadProperties() {
        try {
            System.getProperties().load(ClassLoader.getSystemResourceAsStream("webData.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Could not read properties from file: " + e);
        }
    }

    public static String getWebURL() {
        return readProperty("baseWebUrl");
    }

    public static String getApiURL() {
        return readProperty("baseAPIUrl");
    }


}
