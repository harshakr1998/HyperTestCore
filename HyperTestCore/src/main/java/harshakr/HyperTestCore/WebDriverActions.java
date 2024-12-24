package harshakr.HyperTestCore;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class WebDriverActions {
	WebDriver driver;

	public WebDriverActions(WebDriver driver) {
		this.driver = driver;
	}

	// Wait for visibility of element
	private WebElement waitForElement(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Click Action with explicit wait
	public void clickElement(By locator, int timeout) {
		WebElement element = waitForElement(locator, timeout);
		element.click();
	}

	// Send Keys (Type Text) with explicit wait
	public void sendKeys(By locator, String text, int timeout) {
		WebElement element = waitForElement(locator, timeout);
		element.clear();
		element.sendKeys(text);
	}

	// Get Text of an Element with explicit wait
	public String getElementText(By locator, int timeout) {
		WebElement element = waitForElement(locator, timeout);
		return element.getText();
	}

	// Get Element Attribute with explicit wait
	public String getElementAttribute(By locator, String attributeName, int timeout) {
		WebElement element = waitForElement(locator, timeout);
		return element.getAttribute(attributeName);
	}

	// Select Dropdown Option by Visible Text with explicit wait
	public void selectDropdownByVisibleText(By locator, String visibleText, int timeout) {
		WebElement dropdown = waitForElement(locator, timeout);
		Select select = new Select(dropdown);
		select.selectByVisibleText(visibleText);
	}

	// Select Dropdown Option by Value with explicit wait
	public void selectDropdownByValue(By locator, String value, int timeout) {
		WebElement dropdown = waitForElement(locator, timeout);
		Select select = new Select(dropdown);
		select.selectByValue(value);
	}

	// Select Dropdown Option by Index with explicit wait
	public void selectDropdownByIndex(By locator, int index, int timeout) {
		WebElement dropdown = waitForElement(locator, timeout);
		Select select = new Select(dropdown);
		select.selectByIndex(index);
	}

	// Check if Element is Present with explicit wait
	public boolean isElementPresent(By locator, int timeout) {
		try {
			waitForElement(locator, timeout);
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	// Wait for Element to be Visible (Explicit Wait)
	public void waitForElementToBeVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Wait for Element to be Clickable
	public void waitForElementToBeClickable(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	// Scroll to Element with explicit wait
	public void scrollToElement(By locator, int timeout) {
		WebElement element = waitForElement(locator, timeout);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Get Page Title
	public String getPageTitle() {
		return driver.getTitle();
	}

	// Handle Alerts (Accept) with explicit wait
	public void acceptAlert(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// Handle Alerts (Dismiss) with explicit wait
	public void dismissAlert(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	// Switch to Frame with explicit wait
	public void switchToFrame(By locator, int timeout) {
		WebElement frame = waitForElement(locator, timeout);
		driver.switchTo().frame(frame);
	}

	// Switch to Default Content (Exit Frame)
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	// Navigate Back in Browser
	public void navigateBack() {
		driver.navigate().back();
	}

	// Navigate Forward in Browser
	public void navigateForward() {
		driver.navigate().forward();
	}

	// Refresh Page
	public void refreshPage() {
		driver.navigate().refresh();
	}

	// Take Screenshot with explicit wait
	public void takeScreenshot(String filePath, int timeout) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body"))); // Wait for body to load
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filePath);
		FileUtils.copyFile(srcFile, destFile);
	}

	// Mouse Hover Action with explicit wait
	public void hoverMouseOver(By locator, int timeout) {
		WebElement element = waitForElement(locator, timeout);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	// Right-Click Action with explicit wait
	public void rightClick(By locator, int timeout) {
		WebElement element = waitForElement(locator, timeout);
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	// Double-Click Action with explicit wait
	public void doubleClick(By locator, int timeout) {
		WebElement element = waitForElement(locator, timeout);
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	// Drag and Drop with explicit wait
	public void dragAndDrop(By sourceLocator, By targetLocator, int timeout) {
		WebElement source = waitForElement(sourceLocator, timeout);
		WebElement target = waitForElement(targetLocator, timeout);
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}

	// Set Checkbox State (Check/Uncheck) with explicit wait
	public void setCheckboxState(By locator, boolean check, int timeout) {
		WebElement checkbox = waitForElement(locator, timeout);
		if (checkbox.isSelected() != check) {
			checkbox.click();
		}
	}

	// Wait for Element to Disappear (Invisible) with explicit wait
	public void waitForElementToDisappear(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	// Handle Multiple Windows (Switching Between) with explicit wait
	public void switchToWindowByTitle(String windowTitle, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(driver1 -> driver1.getWindowHandles().size() > 1); // Wait for multiple windows to appear

		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
			if (driver.getTitle().equals(windowTitle)) {
				break;
			}
		}
	}
}
