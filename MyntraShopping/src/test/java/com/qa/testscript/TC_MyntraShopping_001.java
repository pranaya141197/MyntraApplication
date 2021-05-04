package com.qa.testscript;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.ExcelUtility;
//Creating a class and extend that to MyntraTestBase class to aquire the properties of MyntraTestBase
public class TC_MyntraShopping_001 extends MyntraTestBase {
	/*@Test annotation is used as main method and priority and 
	 * dataprovider are flags which defines priority of method i.e which should run first and 
	 * data provider will provide the data from excelsheet */
	@Test(priority = 1, dataProvider = "getValidLoginData")
	// Creating a method to check login for valid data
	public void getValidLoginData(String Phonenumber, String Password) throws InterruptedException, IOException {
		WebElement target = myntrapages.getProfile();
		
		act.moveToElement(target).perform();
		act.moveToElement(myntrapages.getProfile()).build().perform();
		Thread.sleep(3000);
		myntrapages.getsignuporlogin().click();
		while (driver.getCurrentUrl().contains("login")) {
			myntrapages.getPhonenumberforsignup().sendKeys(Phonenumber);
			myntrapages.getClickonContinue().click();
			Thread.sleep(3000);
			myntrapages.getLoginwithpassword().click();
			Thread.sleep(3000);
			myntrapages.getpassword().sendKeys(Password);
			Thread.sleep(3000);
			myntrapages.getClickOnLogin().click();
			Thread.sleep(1000);
			CaptureScreenshot(driver, "getValidLoginData");
			Reporter.log("Logged in successful");
			
			
		}
	}

	@DataProvider
	public String[][] getValidLoginData() throws Exception {
		String Xlpath = "C:\\Users\\Pranaya\\eclipse-workspace\\MyntraShopping\\src\\test\\java\\com\\qa\\utility\\MyntraData.xlsx";
		String Xpath = "Sheet1";
		int rowCount = ExcelUtility.GetRowCount(Xlpath, Xpath);
		int columnCount = ExcelUtility.GetCellCount(Xlpath, Xpath, rowCount);
		String[][] data = new String[rowCount][columnCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				data[i - 1][j] = ExcelUtility.GetCallData(Xlpath, Xpath, i, j);
			}

		}
		return data;
   }

	@Test(priority = 2, dataProvider = "getShoppingData")
	public void AddToCart(String ProductName, String NavigateUrl) throws InterruptedException, Exception {
		Thread.sleep(3000);
		myntrapages.getSearchAnIteam().sendKeys(ProductName);
		Thread.sleep(3000);
		myntrapages.getSearchIcon().click();
		Thread.sleep(3000);
		myntrapages.getImageClick().click();
		Thread.sleep(3000);
		Set<String> windowHandles = driver.getWindowHandles();
		Thread.sleep(3000);
		String win = null;
		Thread.sleep(3000);
		for (String s : windowHandles) {
			System.out.println(s);
			win = s;
		}
		Thread.sleep(3000);
		driver.switchTo().window(win);
		myntrapages.getAddtobag().click();
		Thread.sleep(1000);
		CaptureScreenshot(driver, "AddToCart");
		driver.navigate().to(NavigateUrl);
     }
	
	
	
	@DataProvider
	public String[][] getShoppingData() throws Exception {
		String Xlpath = "C:\\Users\\Pranaya\\eclipse-workspace\\MyntraShopping\\src\\test\\java\\com\\qa\\utility\\MyntraData.xlsx";
		String Xpath = "Sheet2";
		int rowCount = ExcelUtility.GetRowCount(Xlpath, Xpath);
		int columnCount = ExcelUtility.GetCellCount(Xlpath, Xpath, rowCount);
		String[][] data = new String[rowCount][columnCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				data[i - 1][j] = ExcelUtility.GetCallData(Xlpath, Xpath, i, j);

			}

		}
		return data;
	}
	
	@Test(priority=3)
	public void BuyProductAndSignout() throws InterruptedException, IOException
	
	{
		myntrapages.getGotobag().click();
		Thread.sleep(2000);
		Reporter.log(myntrapages.getCount().size()+ ": Number of Items in cart");
		
		Reporter.log("Cart Items:");
		Thread.sleep(2000);
		 for(WebElement ele:myntrapages.getCount())
		    {
			    
		    	Reporter.log(ele.getText(), true);
		    }
		 
		    myntrapages.getClickonPlaceOrder().click();
			Thread.sleep(2000);
			myntrapages.getClickOnproceedtocontinue().click();
	    	Thread.sleep(3000);
			driver.navigate().to("https://www.myntra.com/");
			Thread.sleep(2000);
			WebElement target2 = myntrapages.getProfile();
			Thread.sleep(3000);
			act.moveToElement(target2).perform();
			Thread.sleep(2000);
			act.moveToElement(myntrapages.getProfile()).build().perform();
			Thread.sleep(2000);
			myntrapages.getSignout().click();
			Thread.sleep(1000);
			CaptureScreenshot(driver, "BuyProductAndSignout");
			Reporter.log(" Order placed and Signed out successfully");
	}

}
