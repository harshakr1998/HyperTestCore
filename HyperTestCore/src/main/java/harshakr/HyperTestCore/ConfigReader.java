package harshakr.HyperTestCore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;
    
    public ConfigReader(String configFilePath) {
        properties = new Properties();
        File configFile = new File(configFilePath);

        // Try to load from the passed file path first
        if (configFile.exists() && configFile.isFile()) {
            loadConfig(configFile);
        } else {
            // Try to search in different directories
            File defaultConfig = new File("src/test/resources/config/config.properties");
            if (defaultConfig.exists() && defaultConfig.isFile()) {
                loadConfig(defaultConfig);
            } else {
                throw new RuntimeException("Config file not found in any of the locations.");
            }
        }
    }

    private void loadConfig(File configFile) {
        try (FileInputStream fileInputStream = new FileInputStream(configFile)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading config file: " + configFile.getPath());
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
