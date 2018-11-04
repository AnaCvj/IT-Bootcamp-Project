package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogOut_Page {
	private static WebElement element = null;

	public static WebElement getLogOutArrow(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		return element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='navbar-logout']")));

	}

	public static WebElement getLogOut(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		return element = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='v-btn__content'][contains(text(),'Logout')]")));

	}

	public static WebElement getLogOutYes(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		return element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Yes')]")));
	}

	public static void addLogOutArrow(WebDriver driver) {
		getLogOutArrow(driver).click();
	}

	public static void addLogOut(WebDriver driver) {
		getLogOut(driver).click();
	}

	public static void addLogOutYes(WebDriver driver) {
		getLogOutYes(driver).click();
	}

}
