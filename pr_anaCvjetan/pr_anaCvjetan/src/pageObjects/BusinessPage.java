package pageObjects;

import java.util.List;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusinessPage {

	private static WebElement elementB = null;

	public static WebElement getbusinessClick(WebDriver driver) {

		elementB = driver.findElement(By.xpath("//a[@id='nav-bar-business']//div[@class='v-btn__content']"));

		return elementB;
	}

	public static void addBusinessClick(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement newBusinessClick = getbusinessClick(driver);
		wait.until(ExpectedConditions.elementToBeClickable(newBusinessClick));
		newBusinessClick.click();
		// getBusinessName(driver).click();
	}

	public static WebElement getNewBusinessClick(WebDriver driver) {

		elementB = driver.findElement(By.xpath("//a[@id='add-new-business']//div[@class='v-btn__content']"));

		return elementB;

	}

	public static void addNewBusinessClick(WebDriver driver) {
		getNewBusinessClick(driver).click();
	}

	public static WebElement getBusinessName(WebDriver driver) {

		elementB = driver.findElement(By.xpath("//input[@id='business-form-name']"));

		return elementB;

	}

	public static void addBusinessName(WebDriver driver, String businessName) {
		getBusinessName(driver).sendKeys(businessName);
	}

	public static WebElement getCountries(WebDriver driver) {

		elementB = driver.findElement(By.xpath("//input[@id='business-form-country']"));

		return elementB;

	}

	public static void addCountries(WebDriver driver, String countryName) throws InterruptedException {
		Actions builder = new Actions(driver);
		Actions country = builder.moveToElement(getCountries(driver)).click().sendKeys(countryName);
		country.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
		country.perform();
	}

	public static WebElement getCity(WebDriver driver) {

		elementB = driver.findElement(By.xpath("//input[@id='business-form-city']"));

		return elementB;

	}

	public static void addCity(WebDriver driver, String cityName) {
		getCity(driver).sendKeys(cityName);

	}

	public static WebElement getStreet(WebDriver driver) {

		elementB = driver.findElement(By.xpath("//input[@id='business-form-street']"));

		return elementB;

	}

	public static void addStreet(WebDriver driver, String streetName) {
		getStreet(driver).sendKeys(streetName);
	}

	public static WebElement getZip(WebDriver driver) {

		elementB = driver.findElement(By.xpath("//input[@id='business-form-zip']"));

		return elementB;

	}

	public static void addZip(WebDriver driver, Integer zip) {
		getZip(driver).sendKeys(String.valueOf(zip));
	}

	public static WebElement getRegistryNumber(WebDriver driver) {

		elementB = driver.findElement(By.xpath("//input[@id='business-form-reg-num']"));

		return elementB;

	}

	public static void addRegistryNumber(WebDriver driver, Integer registryNumber) {
		getRegistryNumber(driver).sendKeys(String.valueOf(registryNumber));
	}

	public static WebElement getBankAccountClick(WebDriver driver) {
		elementB = driver
				.findElement(By.xpath("//button[@id='business-form-add-bank-btn']//div[@class='v-btn__content']"));
		return elementB;
	}

	public static void addBankAccountClick(WebDriver driver) {
		getBankAccountClick(driver).click();
		;
	}

	public static WebElement getBankName(WebDriver driver) {

		elementB = driver.findElement(By.xpath("//input[@id='bank-dialog-name']"));

		return elementB;

	}

	public static void addBankName(WebDriver driver, String bankName) {
		getBankName(driver).sendKeys(bankName);
	}

	public static WebElement getAccountNumber(WebDriver driver) {

		elementB = driver.findElement(By.xpath("//input[@id='bank-dialog-num']"));

		return elementB;

	}

	public static void addAccountNumber(WebDriver driver, String accountNumber) {
		getAccountNumber(driver).sendKeys(accountNumber);
	}

	public static WebElement getSwiftNumber(WebDriver driver) {

		elementB = driver.findElement(By.xpath("//input[@id='bank-dialog-swf-num']"));

		return elementB;

	}

	public static void addSwiftNumber(WebDriver driver, String swiftNumber) {
		getSwiftNumber(driver).sendKeys(swiftNumber);
	}

	public static WebElement getPaymentInstructions(WebDriver driver) {

		elementB = driver.findElement(By.xpath("//textarea[@id='bank-dialog-pay-inst']"));

		return elementB;

	}

	public static void addPaymentInstructions(WebDriver driver, String paymentInstructions) {
		getPaymentInstructions(driver).sendKeys(paymentInstructions);
	}

	public static WebElement getCurrency(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		elementB = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='v-select__selections']")));
		return elementB;
	}

	public static List<WebElement> getCurrencyLabel(WebDriver driver) {
		List<WebElement> currencyList = new ArrayList();
		currencyList.add(driver.findElement(By.xpath("//div[contains(text(),'Dinar')]")));
		currencyList.add(driver.findElement(By.xpath("//div[contains(text(),'Euro')]")));
		currencyList.add(driver.findElement(By.xpath("//div[contains(text(),'US Dollar')]")));
		return currencyList;
	}

	public static void addCurrency(WebDriver driver, String currencyName) {
		Actions builder = new Actions(driver);
		WebElement currencyList = getCurrency(driver);
		Actions currency = builder.moveToElement(currencyList).click();
		currency.perform();
		List<WebElement> CurrencyLabel = getCurrencyLabel(driver);
		for (WebElement e : CurrencyLabel) {
			if (e.getText().equals(currencyName)) {
				e.click();
			}
		}
	}

	public static WebElement getBankAccountAdd(WebDriver driver) {

		elementB = driver.findElement(By.xpath("//div[contains(text(),'Add bank account')]"));

		return elementB;

	}

	public static void addBankAccountAdd(WebDriver driver) {
		getBankAccountAdd(driver).click();
	}

	public static WebElement getSaveClick(WebDriver driver) {

		elementB = driver.findElement(By.xpath("//div[contains(text(),'Save')]"));

		return elementB;

	}

	public static void addSaveClick(WebDriver driver) {
		getSaveClick(driver).click();
	}
}
