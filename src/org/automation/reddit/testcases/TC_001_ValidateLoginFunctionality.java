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
	
	@Test(dataProvider="Excel")
	public void tc_001_login_functionality(String uname, String pass) throws Exception
	{
		LoginPage login = new LoginPage(driver);
		login.enterUsername(uname);
		login.enterPassword(pass);
		login.clickSignin();
	}
	
	@DataProvider(name="Excel")
	public Object[][] testDataGenerator() throws Exception
	{   //Read data without exel
		Object [][] data = {{"stangray94", "12345678"}, {"kurka", "12345678"}, {"durka", "12345678"}};
		return data;
		//Use Excel
//		FileInputStream file = new FileInputStream("./TestData/TestData.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(file);
//		XSSFSheet loginSheet = workbook.getSheet("Login");
//		int numberOfData = loginSheet.getPhysicalNumberOfRows();
//		Object [][] testData= new Object[numberOfData][2];
//		
//		for(int i=0;i<numberOfData;i++)
//		{
//				XSSFRow row = loginSheet.getRow(i);
//				XSSFCell username = row.getCell(0);
//				XSSFCell password = row.getCell(1);
//				testData[i][0] = username.getStringCellValue();
//				testData[i][0] = password.getStringCellValue();
//		}
//				
//				return testData;
	}

}
