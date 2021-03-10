package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.Utilities.XLUtils;
import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass

{
	
	@Test(dataProvider="LoginData")
	public void LoginDDT(String uname,String pwd)
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(uname);
		logger.info("Entered Username");
		lp.setPassword(pwd);
		logger.info("Entered Password");
		lp.clickSubmit();
		
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept(); //close the alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
			lp.clicklogout();
			driver.switchTo().alert().accept(); //close the alert
			driver.switchTo().defaultContent();
			
		}
		
	}
	
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();	
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	
	@DataProvider(name="LoginData")
	
	String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colnum = XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata [][] = new String[rownum][colnum];
		
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0; j<colnum; j++)
			{
				logindata [i-1][j]= XLUtils.getCellData(path, "Sheet1", i, j);
			}
			
		}
		return logindata;
		
	}


}
