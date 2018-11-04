package pageObjects;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.DateTimeUtils;

public class ClientsPage {

		private static WebElement elementC = null;
		private static String clientNameMissingStatus = "The Client Name field is required.";
	
		public static WebElement getClientsClick(WebDriver driver) {

			elementC = driver.findElement(By.xpath("//a[@id='nav-bar-clients']"));

			return elementC;

		}
		public static void addClientsClick(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement clientsClick = getClientsClick(driver);
			wait.until(ExpectedConditions.elementToBeClickable(clientsClick));
			clientsClick.click();

		}
		public static WebElement getNewClientsClick(WebDriver driver) {

			elementC = driver.findElement(By.xpath("//i[contains(text(),'library_add')]"));

			return elementC;

		}
		public static void addNewClientsClick(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement newClientsClick = getNewClientsClick(driver);
			wait.until(ExpectedConditions.elementToBeClickable(newClientsClick));
			newClientsClick.click();

		}
		public static WebElement getClientName(WebDriver driver) {
		
			elementC = driver.findElement(By.xpath("//body/div[@id='app']/div[@class='application--wrap']/main[@class='v-content']/div[@class='v-content__wrap']/div[@class='container']/div[@class='mt-1 white v-card']/div[@class='v-card__actions']/div[@class='layout column']/div[@class='layout']/div[@class='flex secondary xs12']/form[@class='ma-2 pa-3 text-xs-center']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]"));

			return elementC;

		}
		public static void addClientName(WebDriver driver, String clientName) {
			getClientName(driver).sendKeys(clientName);

		}
		public static WebElement getContactName(WebDriver driver) {
			
			elementC = driver.findElement(By.xpath("//form[@class='ma-2 pa-3 text-xs-center']//div[1]//div[2]//div[1]//div[2]//div[1]//div[1]//input[1]"));

			return elementC;

		}
		public static void addContactName(WebDriver driver, String contactName) {
			getContactName(driver).sendKeys(contactName);

		}
		public static WebElement getEmail(WebDriver driver) {
			
			elementC = driver.findElement(By.xpath("//div[@class='flex xs6 mr-2']//input[@type='text']"));

			return elementC;

		}
		public static void addEmail(WebDriver driver, String email) {
			getEmail(driver).sendKeys(email);

		}
		public static WebElement getRegistryNumber(WebDriver driver) {
		
			elementC = driver.findElement(By.xpath("//form[@class='ma-2 pa-3 text-xs-center']//div[2]//div[2]//div[1]//div[2]//div[1]//div[1]//input[1]"));

			return elementC;

		}
		public static void addRegistryNumber(WebDriver driver, Integer registryNumber) {
			getRegistryNumber(driver).sendKeys(String.valueOf(registryNumber));
		}

		
		public static WebElement getCountries(WebDriver driver) {
			
			
			elementC = driver.findElement(By.xpath("//div[@class='v-select__slot']//input[@type='text']"));
		
			return elementC;
			
		}
		public static void addCountries(WebDriver driver, String countryName) throws InterruptedException {
			Actions builder = new Actions(driver);
			Actions country = builder.moveToElement(getCountries(driver)).click().sendKeys(countryName);
			country.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
			country.perform();
		}
		
		public static WebElement getCity(WebDriver driver) {
			
			elementC = driver.findElement(By.xpath("//form[@class='ma-2 pa-3 text-xs-center']//div[3]//div[2]//div[1]//div[2]//div[1]//div[1]//input[1]"));

			return elementC;
			}
		public static void addCity(WebDriver driver, String cityName) {
			getCity(driver).sendKeys(cityName);

		}
		public static WebElement getStreet(WebDriver driver) {
			
			elementC = driver.findElement(By.xpath("//body/div[@id='app']/div[@class='application--wrap']/main[@class='v-content']/div[@class='v-content__wrap']/div[@class='container']/div[@class='mt-1 white v-card']/div[@class='v-card__actions']/div[@class='layout column']/div[@class='layout']/div[@class='flex secondary xs12']/form[@class='ma-2 pa-3 text-xs-center']/div[@class='layout']/div[3]/div[1]/div[2]/div[1]/div[1]/input[1]"));

			return elementC;
			}
		public static void addStreet(WebDriver driver, String streetName) {
			getStreet(driver).sendKeys(streetName);
		}
		public static WebElement getZip(WebDriver driver) {
		
			elementC = driver.findElement(By.xpath("//div[@class='layout']//div[@class='layout']//div[4]//div[1]//div[2]//div[1]//div[1]//input[1]"));

			return elementC;
			}
		public static void addZip(WebDriver driver, Integer zip) {
			getZip(driver).sendKeys(String.valueOf(zip));
		
		}
		public static WebElement getDateAdded(WebDriver driver)
		{
			elementC = driver.findElement(By.xpath("//div[@class='flex xs3']//div[@class='v-dialog__container']//input[@type='text']"));
			return elementC;
		}
		public static void addDateAdded(WebDriver driver, String dateAdded) throws InterruptedException
		{
			getDateAdded(driver).click();
			Thread.sleep(1000);
			LocalDate ld = DateTimeUtils.StringToDate(dateAdded);
			int monthsBetween = DateTimeUtils.MonthsBetweenTwoDates(LocalDate.now(), ld);
			if(monthsBetween>=0)
			{
				for(int i=0;i<monthsBetween;i++)
				{
					getMonthsForward(driver).click();
					Thread.sleep(1000);
				}
			}
			else
			{
				for(int i=0;i>monthsBetween;i--)
				{
					getMonthsBackward(driver).click();
					Thread.sleep(1000);
				}	
			}
	        String day = Integer.toString(ld.getDayOfMonth());
	        //contains(text(),'10')
	        String relXPathToRow =String.format("//*[contains(text(),'%s')]", day);
	        List<WebElement> lwe = driver.findElements(By.xpath(relXPathToRow));
	        lwe.get(lwe.size()-1).click();
	        Thread.sleep(1000);
	        System.out.println("Kliknuo na datum");
	        getOkCalendar(driver).click();
	        Thread.sleep(1000);
	        
			
		}
		public static WebElement getCode(WebDriver driver) {
			
			elementC = driver.findElement(By.xpath("//div[@class='v-input code-field v-text-field']//input[@type='text']"));
			return elementC;
			}
		public static void addCode(WebDriver driver, String code) {
			getCode(driver).sendKeys(code);
		}
		
		public static WebElement getStatus(WebDriver driver) {
			elementC = driver.findElement(By.xpath("//label[contains(text(),'Status: Active')]"));
			return elementC;
			}
		public static WebElement getAgreementDay(WebDriver driver)
		{
			elementC = driver.findElement(By.xpath("//div[@class='flex xs3 ml-3']//input[@type='text']"));
			return elementC;
		}
		public static void addAgreementDay(WebDriver driver, String agreementDay)
		{
			getAgreementDay(driver).sendKeys(agreementDay);
		}
		
		public static void addStatus(WebDriver driver, String status) throws InterruptedException {
			String currentStatus = getStatus(driver).getText();
			String cs = currentStatus.split(":")[1].trim();
			if(!status.equals(cs))
			{
				getStatus(driver).click();
			}
		}
		public static WebElement getMonthsForward(WebDriver driver)
		{
			elementC = driver.findElement(By.xpath("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//div[@class='v-picker v-card v-picker--date']//div[@class='v-picker__body']//div//i[@class='v-icon material-icons'][contains(text(),'chevron_right')]"));
			return elementC;
		}
		public static WebElement getMonthsBackward(WebDriver driver)
		{
			elementC = driver.findElement(By.xpath("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//div[@class='v-picker v-card v-picker--date']//div[@class='v-picker__body']//div//i[@class='v-icon material-icons'][contains(text(),'chevron_left')]"));
			return elementC;
		}
		
		public static WebElement getOkCalendar(WebDriver driver)
		{
			elementC = driver.findElement(By.xpath("//div[@class='v-dialog v-dialog--active v-dialog--persistent']//div[@class='v-btn__content'][contains(text(),'OK')]"));
			return elementC;
		}
		
		public static WebElement getSaveClick(WebDriver driver) {
			elementC = driver.findElement(By.xpath("//div[contains(text(),'Save')]"));
			return elementC;
			}
		public static void addSaveClick(WebDriver driver) {
			getSaveClick(driver).click();
		}
		public static WebElement getClientNameStatus(WebDriver driver)
		{
			elementC = driver.findElement(By.xpath("//div[contains(text(),'The Client Name field is required.')]"));
			return elementC;
		}
		public static boolean checkClientNameStatus(WebDriver driver)
		{
			String message = getClientNameStatus(driver).getText();
			if (message.equals(clientNameMissingStatus))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}


