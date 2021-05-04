package com.qa.testscript;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.pages.MyntraPages;
// Creating a method which acts as base for every test script.
public class MyntraTestBase {
	// Declaration of driver variable
	WebDriver driver;
	// Declaration MyntraPages class variable
	MyntraPages myntrapages;
	 JavascriptExecutor js;
	// Declaration of Actions class variable
	Actions act;
	// Using @parameters annotation to pass browser name and URL
	SoftAssert SAssert;
	@Parameters({ "Browser", "Url" })
	// Using @Beforeclass annotation to run below method before every class
	@BeforeClass
	// Creating a method with arguments  called browser name and URL  and this method will run before every class
	public void SetUp(String Browser, String Url) {
 
		// If is used to check the condition which is specified and equalsIgonrecase method will used to ignore the case of given input
		if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pranaya\\Desktop\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
       // If above if condition is false this else if condition will be checked and equalsIgonrecase method will used to ignore the case of given input
		} else if (Browser.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.edge.driver", "C:\\Users\\Pranaya\\Desktop\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		//	 If above if and if else condition is false this else condition will be checked and equalsIgonrecase method will used to ignore the case of given input	
		} else {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Pranaya\\Desktop\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		// Creating object of of MyntraPages class and passing driver argument
		myntrapages = new MyntraPages(driver);
		
		driver.get(Url);
		// Used maximize the window
		driver.manage().window().maximize();
		// Creating object of of Actions class and passing driver argument
		act=new Actions(driver);
		SAssert = new SoftAssert();
		
	}
	// Creating a method to capture the screenshot
	public void CaptureScreenshot(WebDriver driver, String name) throws IOException
	{
		// Creating a object of take screenshot
		TakesScreenshot ts=(TakesScreenshot)driver;
		// Creating a variable of file type to store screenshot in the form of file.
		File Source=ts.getScreenshotAs(OutputType.FILE);
		// Creating a variable of file type and storing a path where screenshot should save
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+name+".png");
		FileUtils.copyFile(Source,target);
		// Used to print in console window
		System.out.println("Screenshot captured");
		
	}
   // Creating a method to close all windows opened by automation and @AfterClass annotation is used to run after evry class
	@AfterClass
	public void TearDown() {
		driver.quit();
	}


}
