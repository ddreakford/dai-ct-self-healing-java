package helpers;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {

    public PropertiesReader() {}

    public String getProperty(String property) {
        Properties props = System.getProperties();

        try {
            props.load(new FileInputStream("config.properties"));

            if (props.getProperty("ct.accessKey").isEmpty()) {
                throw new Exception("SeeTest Cloud Access Key not found. Please look in config.properties.");
            }

            if (props.getProperty("ct.cloudUrl").isEmpty()) {
                throw new Exception("SeeTest Cloud URL not found. Please look config.properties.");
            }

            if (props.getProperty("unmodified.build").isEmpty()) {
                throw new Exception("URL to unmodified build not found. Please look config.properties.");
            }

            if (props.getProperty("modified.build").isEmpty()) {
                throw new Exception("URL to modified build not found. Please look config.properties.");
            }

        } catch(Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return System.getProperty(property);
    }

    public String getOperatingSystem() {
        String os = System.getProperty("os.name");
        return os;
    }

}
