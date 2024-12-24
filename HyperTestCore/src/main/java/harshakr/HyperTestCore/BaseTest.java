package harshakr.HyperTestCore;
 
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    
    private ConfigReader configReader;

    public BaseTest() {
        String configFilePath = System.getProperty("configFilePath", "src/test/resources/config/config.properties");
        configReader = new ConfigReader(configFilePath);  // Pass the path to the ConfigReader
    }

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get(configReader.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}

