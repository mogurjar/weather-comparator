package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Class to Load Properties from .property file
 */
public class LoadProperties {

    public Properties properties;

    /**
     * This method reads property file
     *
     * @param fileName file path of .properties file
     * @return Properties Object from which property value can be fetched
     * @throws IOException
     */
    public Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(fileName);
            properties = new Properties();
            properties.load(fis);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return properties;
    }

}
