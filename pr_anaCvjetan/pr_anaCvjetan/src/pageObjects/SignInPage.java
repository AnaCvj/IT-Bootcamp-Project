package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

	private static WebElement element = null;
	private static String emailMissingStatus = "The email field is required.";
	private static String emailInvalidStatus = "The email field must be a valid email.";
	private static String passwordMissingStatus = "The password field is required.";
	private static String passwordShortStatus = "The password field must be at least 6 characters.";
	private static String passwordTooLongStatus = "The password field may not be greater than 20 characters.";

	public static WebElement getEmail(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='login-form-email']"));
		return element;
	}

	public static void addEmail(WebDriver driver, String email) {

		getEmail(driver).sendKeys(email);
	}

	public static WebElement getPassword(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='login-pass']"));
		return element;
	}

	public static void addPassword(WebDriver driver, String password) {

		getPassword(driver).sendKeys(password);
	}

	public static WebElement getLogInClick(WebDriver driver) {

		element = driver.findElement(By.xpath("//div[@class='v-btn__content']"));
		return element;
	}

	public static void addLogInClick(WebDriver driver) {
		getLogInClick(driver).click();
	}

	public static WebElement getEmailStatus(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[contains(text(),'The email field is required.')]"));
		return element;
	}

	public static boolean checkEmailStatus(WebDriver driver) {

		String message = getEmailStatus(driver).getText();
		if (message.equals(emailMissingStatus)) {
			return true;
		} else {
			return false;
		}
	}

	public static WebElement getEmailInvalidStatus(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[contains(text(),'The email field must be a valid email.')]"));
		return element;
	}

	public static boolean checkEmailInvalidStatus(WebDriver driver) {

		String message = getEmailInvalidStatus(driver).getText();
		if (message.equals(emailInvalidStatus)) {
			return true;
		} else {
			return false;
		}
	}

	public static WebElement getPasswordStatus(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[contains(text(),'The password field is required.')]"));
		return element;
	}

	public static boolean checkPasswordStatus(WebDriver driver) {

		String message = getPasswordStatus(driver).getText();
		if (message.equals(passwordMissingStatus)) {
			return true;
		} else {
			return false;
		}
	}

	public static WebElement getPasswordShortStatus(WebDriver driver) {
		element = driver
				.findElement(By.xpath("//div[contains(text(),'The password field must be at least 6 characters.')]"));
		return element;
	}

	public static boolean checkPasswordShortStatus(WebDriver driver) {

		String message = getPasswordShortStatus(driver).getText();
		if (message.equals(passwordShortStatus)) {
			return true;
		} else {
			return false;
		}
	}

	public static WebElement getPasswordTooLongStatus(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//div[contains(text(),'The password field may not be greater than 20 characters.')]"));
		return element;
	}

	public static boolean checkPasswordTooLongStatus(WebDriver driver) {

		String message = getPasswordTooLongStatus(driver).getText();
		if (message.equals(passwordTooLongStatus)) {
			return true;
		} else {
			return false;
		}
	}
}
