package pageObjectcTest;

import org.openqa.selenium.WebDriver;

import pageObjects.LogOut_Page;
import utility.Constant;
import utility.ExcelUtils;

public class LogOutPageTest {
	public static void SetUpExcel() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "LogOutSheet");
	}

	public static String addNewLogOutTest(WebDriver driver) throws Exception {

		LogOut_Page.addLogOutArrow(driver);

		LogOut_Page.addLogOut(driver);

		LogOut_Page.addLogOutYes(driver);

		return "Pass";
	}

}
