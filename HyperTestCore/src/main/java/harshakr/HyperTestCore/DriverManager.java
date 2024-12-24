package harshakr.HyperTestCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class DriverManager {

	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	private static ConfigReader configReader;

	// Initialize WebDriver
	public static WebDriver getDriver() {
		if (threadLocalDriver.get() == null) {
			String browser = configReader.getProperty("browser").toLowerCase();

			switch (browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				threadLocalDriver.set(new ChromeDriver());
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				threadLocalDriver.set(new FirefoxDriver());
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				threadLocalDriver.set(new EdgeDriver());
				break;
			default:
				throw new IllegalArgumentException("Unsupported browser: " + browser);
			}

			// Set implicit wait and maximize the browser
			((WebDriver) threadLocalDriver).manage().timeouts()
					.implicitlyWait(Duration.ofSeconds(Integer.parseInt(configReader.getProperty("implicitWait"))));
			((WebDriver) threadLocalDriver).manage().window().maximize();
		}
		return threadLocalDriver.get();
	}

	// Quit WebDriver
	public static void quitDriver() {
		if (threadLocalDriver.get() != null) {
			threadLocalDriver.get().quit();
			threadLocalDriver.remove();
		}
	}
}
