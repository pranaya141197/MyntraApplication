package com.qa.testscript;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.utility.ExcelUtility;

public class TC_InvalidLogin_002 extends MyntraTestBase {

	@Test(priority = 4, dataProvider = "getInvalidLoginData")

	public void Invalidlogin(String MobileNumber, String Passcode)
			throws InterruptedException, Exception, InvocationTargetException {
		// Which is used to wait 1 second
		Thread.sleep(1000);
		WebElement target = myntrapages.getProfile();
		Thread.sleep(3000);

		act.moveToElement(target).perform();
		Thread.sleep(3000);
		act.moveToElement(myntrapages.getProfile()).build().perform();
		Thread.sleep(3000);
		// Click is used to click on particular element
		myntrapages.getsignuporlogin().click();
		Thread.sleep(3000);
		// Sendkeys is used to send data for any field
		myntrapages.getPhonenumberforsignup().sendKeys(MobileNumber);
		Thread.sleep(3000);
		myntrapages.getClickonContinue().click();
		Thread.sleep(3000);
		myntrapages.getLoginwithpassword().click();
		Thread.sleep(3000);
		myntrapages.getpassword().sendKeys(Passcode);
		Thread.sleep(3000);
		myntrapages.getClickOnLogin().click();
		Thread.sleep(1000);
		CaptureScreenshot(driver, "Invalidlogin");
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		Thread.sleep(1000);
		Reporter.log("Invalid Credentials");

	}

	// Which is used to provide data from excel sheet
	@DataProvider
	// Creating a method which returns string array
	public String[][] getInvalidLoginData() throws Exception {

		String Xlpath = "C:\\Users\\Pranaya\\Desktop\\MyntraData.xlsx";
		String Xpath = "Sheet3";

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

	// Creating a method to buy a product
	@Test(priority = 5, dataProvider = "getShoppingData")
	public void buyproduct(String ProductName, String NavigateUrl) throws InterruptedException, Exception {
		if (driver.getTitle().contains("logout")) {
			CaptureScreenshot(driver, "buyproduct");
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
				Reporter.log("Window id is :" + s, true);
				win = s;
			}
			Thread.sleep(3000);
			driver.switchTo().window(win);
			Thread.sleep(3000);
			myntrapages.getAddtobag().click();
			Thread.sleep(2000);

			driver.navigate().to(NavigateUrl);
			Thread.sleep(1000);
		} else {
			Reporter.log("User is not logged in. Please login",true);
			Thread.sleep(1000);
		}
	}

	// Creating a data provider method to provide data to buy product
	@DataProvider
	public String[][] getShoppingData() throws Exception {
		String Xlpath = "C:\\Users\\Pranaya\\git\\MyntraApplication\\MyntraShopping\\src\\test\\java\\com\\qa\\testdata\\MyntraData.xlsx";
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

	// Creating a Method to buy products and signout
	@Test(priority = 6)
	public void BuyProductAndSignout() throws InterruptedException

	{

		if (driver.getTitle().contains("logout")) {
            
			myntrapages.getGotobag().click();
			Thread.sleep(2000);
			Reporter.log(myntrapages.getCount().size() + ": Number of Items in cart");

			Reporter.log("Cart Items:");
			Thread.sleep(2000);
			for (WebElement ele : myntrapages.getCount()) {

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
			Reporter.log(" Order placed and Signed out successfully");
		} else {
			Reporter.log("User is not logged in. Please login", true);
		}
	}

}
