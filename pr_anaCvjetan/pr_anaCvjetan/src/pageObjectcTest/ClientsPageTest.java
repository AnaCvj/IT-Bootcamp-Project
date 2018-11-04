package pageObjectcTest;

import org.openqa.selenium.WebDriver;

import pageObjects.ClientsPage;
import utility.Constant;
import utility.ExcelUtils;

public class ClientsPageTest {

	public static void SetUpExcel() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "ClientFormSheet");
	}

	public static String addNewClientTest(WebDriver driver) throws Exception {

		String clientName = ExcelUtils.getCellData(1, 1);
		String contactName = ExcelUtils.getCellData(1, 2);
		String email = ExcelUtils.getCellData(1, 3);
		Integer registryNumber = ExcelUtils.getCellDataInt(1, 4);
		String country = ExcelUtils.getCellData(1, 5);
		String city = ExcelUtils.getCellData(1, 6);
		String street = ExcelUtils.getCellData(1, 7);
		Integer zip = ExcelUtils.getCellDataInt(1, 8);
		String dateAdded = ExcelUtils.getCellData(1, 9);
		String code = ExcelUtils.getCellData(1, 10);
		String agreementDay = ExcelUtils.getCellData(1, 11);
		String status = ExcelUtils.getCellData(1, 12);

		ClientsPage.addNewClientsClick(driver);
		ClientsPage.addClientName(driver, clientName);
		ClientsPage.addContactName(driver, contactName);
		ClientsPage.addEmail(driver, email);
		ClientsPage.addRegistryNumber(driver, registryNumber);
		ClientsPage.addCountries(driver, country);
		ClientsPage.addCity(driver, city);
		ClientsPage.addStreet(driver, street);
		ClientsPage.addZip(driver, zip);
		//ClientsPage.setDateAdded(driver, dateAdded);
		ClientsPage.addCode(driver, code);
		//ClientsPage.setAgreementDay(driver, agreementDay);
		ClientsPage.addStatus(driver, status);
		ClientsPage.addSaveClick(driver);
		return "Pass";

	}
	 
	  public static String addNewClientWithoutName(WebDriver driver) throws Exception
	  {
		  String clientName = ExcelUtils.getCellData(2, 1);
			String contactName = ExcelUtils.getCellData(2, 2);
			String email = ExcelUtils.getCellData(2, 3);
			Integer registryNumber = ExcelUtils.getCellDataInt(2, 4);
			String country = ExcelUtils.getCellData(2, 5);
			String city = ExcelUtils.getCellData(2, 6);
			String street = ExcelUtils.getCellData(2, 7);
			Integer zip = ExcelUtils.getCellDataInt(2, 8);
			String code = ExcelUtils.getCellData(2, 10);
			String status = ExcelUtils.getCellData(2, 12);

			ClientsPage.addNewClientsClick(driver);
			ClientsPage.addClientName(driver, clientName);
			ClientsPage.addContactName(driver, contactName);
			ClientsPage.addEmail(driver, email);
			ClientsPage.addRegistryNumber(driver, registryNumber);
			ClientsPage.addCountries(driver, country);
			ClientsPage.addCity(driver, city);
			ClientsPage.addStreet(driver, street);
			ClientsPage.addZip(driver, zip);
			ClientsPage.addCode(driver, code);
			ClientsPage.addStatus(driver, status);
			ClientsPage.addSaveClick(driver);
		  
		  boolean trueForPass = ClientsPage.checkClientNameStatus(driver);
			Thread.sleep(1000);
			if(trueForPass)
			{
				return "Pass";
			}
			else
			{
				return "Faild";
			}

	  }
}
