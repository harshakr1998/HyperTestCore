package harshakr.HyperTestCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUpload {
	
	WebDriver driver;
	
	public FileUpload(WebDriver driver) {
		this.driver = driver;
	}
	
	
	/**
	 * Use this function when you can directly send the file path to the input field.
	 * @param fileUploadEle
	 * @param filePath
	 */
	public void uploadFile(WebElement fileUploadEle,String filePath) {
		fileUploadEle.sendKeys(filePath);
	}	
	
	/**
	 * Use this function when you have to use copy paste action to send the file path to the fileUpload dialogue box
	 * This comes handy and you can avoid the use of AutoIt when running via remote places.
	 * @param filePath
	 */
	public void uploadFile(String filePath) {
		ClipboardUtils.copyAndPaste(filePath);
	}
}
