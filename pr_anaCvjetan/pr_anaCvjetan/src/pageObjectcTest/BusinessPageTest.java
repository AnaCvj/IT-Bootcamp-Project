package pageObjectcTest;

import org.openqa.selenium.WebDriver;

import pageObjects.BusinessPage;
import utility.Constant;
import utility.ExcelUtils;

public class BusinessPageTest {

	public static void SetUpExcel() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "BusinessInfoSheet");
	}

	public static String addNewBusinessTest(WebDriver driver) throws Exception {
		String businessName = ExcelUtils.getCellData(1, 1);
		String countries = ExcelUtils.getCellData(1, 2);
		String city = ExcelUtils.getCellData(1, 3);
		String street = ExcelUtils.getCellData(1, 4);
		Integer zip = ExcelUtils.getCellDataInt(1, 5);
		Integer registryNumber = ExcelUtils.getCellDataInt(1, 6);
		String bankName = ExcelUtils.getCellData(1, 7);
		String accountNumber = ExcelUtils.getCellData(1, 8);
		String swiftNumber = ExcelUtils.getCellData(1, 9);
		String paymentInstructions = ExcelUtils.getCellData(1, 10);
		String currencyName = ExcelUtils.getCellData(1, 11);

		BusinessPage.addNewBusinessClick(driver);
		BusinessPage.addBusinessName(driver, businessName);
		BusinessPage.addCountries(driver, countries);
		BusinessPage.addCity(driver, city);
		BusinessPage.addStreet(driver, street);
		BusinessPage.addZip(driver, zip);
		BusinessPage.addRegistryNumber(driver, registryNumber);
		BusinessPage.addBankAccountClick(driver);
		BusinessPage.addBankName(driver, bankName);
		BusinessPage.addAccountNumber(driver, accountNumber);
		BusinessPage.addSwiftNumber(driver, swiftNumber);
		BusinessPage.addPaymentInstructions(driver, paymentInstructions);
		BusinessPage.addCurrency(driver, currencyName);
		BusinessPage.addBankAccountAdd(driver);
		BusinessPage.addSaveClick(driver);
		return "Pass";

	}
}
