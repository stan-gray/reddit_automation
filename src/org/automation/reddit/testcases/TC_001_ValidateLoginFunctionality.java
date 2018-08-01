package org.automation.reddit.testcases;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.automation.reddit.base.DriverInstance;
import org.automation.reddit.datagenerators.DataGenerator;
import org.automation.reddit.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_001_ValidateLoginFunctionality extends DriverInstance {
	
	@Test(dataProvider="Excel" , dataProviderClass=DataGenerator.class)
	public void tc_001_login_functionality(String uname, String pass) throws Exception
	{
		LoginPage login = new LoginPage(driver);
		login.enterUsername(uname);
		login.enterPassword(pass);
		login.clickSignin();
	}
	
	
}
