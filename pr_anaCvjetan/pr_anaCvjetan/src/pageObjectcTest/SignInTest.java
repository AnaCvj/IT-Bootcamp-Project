package pageObjectcTest;

import org.openqa.selenium.WebDriver;

import pageObjects.SignInPage;
import utility.Constant;
import utility.ExcelUtils;

public class SignInTest {
	public static void SetUpExcel() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "LogInSheet");
	}

	public static String signInTest(WebDriver driver) throws Exception {

		String email = ExcelUtils.getCellData(1, 1);

		String password = ExcelUtils.getCellData(1, 2);

		SignInPage.addEmail(driver, email);

		SignInPage.addPassword(driver, password);

		SignInPage.addLogInClick(driver);

		return "Pass";

	}

	public static String signInTestWithoutEmail(WebDriver driver) throws Exception {
		String email = ExcelUtils.getCellData(2, 1);

		String password = ExcelUtils.getCellData(2, 2);

		SignInPage.addEmail(driver, email);

		SignInPage.addPassword(driver, password);

		SignInPage.addLogInClick(driver);

		boolean trueForPass = SignInPage.checkEmailStatus(driver);
		Thread.sleep(1000);
		if (trueForPass) {
			return "Pass";
		} else {
			return "Faild";
		}

	}

	public static String signInTestWithInvalidEmail(WebDriver driver) throws Exception {
		String email = ExcelUtils.getCellData(3, 1);

		String password = ExcelUtils.getCellData(3, 2);

		SignInPage.addEmail(driver, email);

		SignInPage.addPassword(driver, password);

		SignInPage.addLogInClick(driver);

		boolean trueForPass = SignInPage.checkEmailInvalidStatus(driver);
		Thread.sleep(1000);
		if (trueForPass) {
			return "Pass";
		} else {
			return "Faild";
		}

	}

	public static String signInTestWithoutPassword(WebDriver driver) throws Exception {
		String email = ExcelUtils.getCellData(4, 1);

		String password = ExcelUtils.getCellData(4, 2);

		SignInPage.addEmail(driver, email);

		SignInPage.addPassword(driver, password);

		SignInPage.addLogInClick(driver);

		boolean trueForPass = SignInPage.checkPasswordStatus(driver);
		Thread.sleep(1000);
		if (trueForPass) {
			return "Pass";
		} else {
			return "Faild";
		}

	}

	public static String signInTestWithShortPassword(WebDriver driver) throws Exception {
		String email = ExcelUtils.getCellData(5, 1);

		String password = ExcelUtils.getCellData(5, 2);

		SignInPage.addEmail(driver, email);

		SignInPage.addPassword(driver, password);

		SignInPage.addLogInClick(driver);

		boolean trueForPass = SignInPage.checkPasswordShortStatus(driver);
		Thread.sleep(1000);
		if (trueForPass) {
			return "Pass";
		} else {
			return "Faild";
		}

	}

	public static String signInTestWithTooLongPassword(WebDriver driver) throws Exception {
		String email = ExcelUtils.getCellData(6, 1);

		String password = ExcelUtils.getCellData(6, 2);

		SignInPage.addEmail(driver, email);

		SignInPage.addPassword(driver, password);

		SignInPage.addLogInClick(driver);

		boolean trueForPass = SignInPage.checkPasswordTooLongStatus(driver);
		Thread.sleep(1000);
		if (trueForPass) {
			return "Pass";
		} else {
			return "Faild";
		}

	}

}