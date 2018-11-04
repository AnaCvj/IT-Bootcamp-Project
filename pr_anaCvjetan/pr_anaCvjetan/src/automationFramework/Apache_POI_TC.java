package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.*;

import pageObjectcTest.BusinessPageTest;
import pageObjectcTest.ClientsPageTest;
import pageObjectcTest.LogOutPageTest;
import pageObjectcTest.SignInTest;
import utility.Constant;

import utility.ExcelUtils;
import pageObjects.BusinessPage;
import pageObjects.ClientsPage;

public class Apache_POI_TC {

	private static WebDriver driver = null;

	public static void main(String[] args) throws Exception {

		driver = new ChromeDriver();
		driver.get(Constant.url);
		String testResult = "";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// TestSingInTest
		SignInTest.SetUpExcel();
		testResult = SignInTest.signInTestWithoutEmail(driver);
		ExcelUtils.setCellData(testResult, 2, 3);
		driver.navigate().refresh();
		testResult = SignInTest.signInTestWithInvalidEmail(driver);
		ExcelUtils.setCellData(testResult, 3, 3);
		driver.navigate().refresh();
		testResult = SignInTest.signInTestWithoutPassword(driver);
		ExcelUtils.setCellData(testResult, 4, 3);
		driver.navigate().refresh();
		testResult = SignInTest.signInTestWithShortPassword(driver);
		ExcelUtils.setCellData(testResult, 5, 3);
		driver.navigate().refresh();
		testResult = SignInTest.signInTestWithTooLongPassword(driver);
		ExcelUtils.setCellData(testResult, 6, 3);
		driver.navigate().refresh();
		testResult = SignInTest.signInTest(driver);
		ExcelUtils.setCellData(testResult, 1, 3);

		// TestBusinessPageTest
		BusinessPageTest.SetUpExcel();
		Thread.sleep(5000);
		BusinessPage.addBusinessClick(driver);
		testResult = BusinessPageTest.addNewBusinessTest(driver);
		ExcelUtils.setCellData(testResult, 1, 12);

		// TestClientsPageTest
		ClientsPageTest.SetUpExcel();
		Thread.sleep(5000);
		ClientsPage.addClientsClick(driver);
		Thread.sleep(5000);
		testResult = ClientsPageTest.addNewClientTest(driver);
		ExcelUtils.setCellData(testResult, 1, 13);
		testResult = ClientsPageTest.addNewClientWithoutName(driver);
		ExcelUtils.setCellData(testResult, 2, 13);

		// TestLogOut
		LogOutPageTest.SetUpExcel();
		LogOutPageTest.addNewLogOutTest(driver);
		ExcelUtils.setCellData("Pass", 1, 1);

		driver.quit();

	}

}