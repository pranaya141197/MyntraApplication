package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyntraPages {
	WebDriver driver;

	@FindBy(xpath = "//header/div[2]/div[3]/input[1]")
	WebElement SearchAnIteam;

	// To search an item
	public WebElement getSearchAnIteam() {
		return SearchAnIteam;
	}

	// To click on searchIcon
	@FindBy(xpath = "//header/div[2]/div[3]/a[1]/span[1]")
	WebElement SearchIcon;

	public WebElement getSearchIcon() {
		return SearchIcon;
	}

	// To click on product image
	@FindBy(xpath = "//*[@id=\"desktopSearchResults\"]/div[2]/section/ul/li[1]/a/div[1]/div")
	WebElement ImageClick;

	public WebElement getImageClick() {
		return ImageClick;
	}

	// To add selected product into bag

	@FindBy(xpath = "//body/div[@id='mountRoot']/div[1]/div[1]/div[1]/main[1]/div[2]/div[2]/div[3]/div[1]/div[1]")
	WebElement Addtobag;

	public WebElement getAddtobag() {
		return Addtobag;
	}

	// To go to bag
	@FindBy(xpath = "//header/div[2]/div[2]/a[2]/span[1]")
	WebElement Gotobag;

	public WebElement getGotobag() {
		return Gotobag;
	}

	// To click on place order
	@FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]")
	WebElement ClickonPlaceOrder;

	public WebElement getClickonPlaceOrder() {
		return ClickonPlaceOrder;
	}

	// To enter number to login
	@FindBy(xpath = "//input[@id='']")
	WebElement Phonenumberforsignup;

	public WebElement getPhonenumberforsignup() {
		return Phonenumberforsignup;
	}

	// To click on continue
	@FindBy(xpath = "//div[contains(text(),'CONTINUE')]")
	WebElement ClickonContinue;

	public WebElement getClickonContinue() {
		return ClickonContinue;
	}

	// To select login with password option
	@FindBy(xpath = "//span[contains(text(),'Password')]")
	WebElement Loginwithpassword;

	public WebElement getLoginwithpassword() {
		return Loginwithpassword;
	}

	// To Enter mobile number in address address step
	@FindBy(xpath = "//*[@id=\"mobile\"]")
	WebElement EnterNumber;

	public WebElement getEnterNumber() {
		return EnterNumber;
	}

	// To enter password while login
	@FindBy(xpath = "//*[@id=\"reactPageContent\"]/div/div/form/div/div[2]/input")
	WebElement Enterpassword;

	public WebElement getpassword() {
		return Enterpassword;
	}

	// To Click on login button
	@FindBy(xpath = "//*[@id=\"reactPageContent\"]/div/div/form/div/div[3]/button")
	WebElement ClickOnLogin;

	public WebElement getClickOnLogin() {
		return ClickOnLogin;
	}

	// To click on delete button
	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	WebElement DeleteBtn;

	public WebElement getDeleteBtn() {
		return DeleteBtn;
	}

	// To enter name while giving address
	@FindBy(xpath = "//input[@id='name']")
	WebElement EnterNamefield;

	public WebElement getEnterNamefield() {
		return EnterNamefield;
	}

	// To enter mobile number while giving address
	@FindBy(xpath = "//input[@id='mobile']")
	WebElement EnterMobileNumber;

	public WebElement getEnterMobileNumber() {
		return EnterMobileNumber;
	}

	// To enter pincode while giving address
	@FindBy(xpath = "//input[@id='pincode']")
	WebElement EnterPincode;

	public WebElement getEnterPincode() {
		return EnterPincode;
	}

	// To enter street adress while giving address
	@FindBy(xpath = "//input[@id='streetAddress']")
	WebElement StreetAdress;

	public WebElement getStreetAdress() {
		return StreetAdress;
	}

	@FindBy(xpath = "//input[@id='locality']")
	WebElement EnterTown;

	public WebElement getEnterTown() {
		return EnterTown;
	}

	@FindBy(xpath = "//input[@id='city']")
	WebElement Entercity;

	public WebElement getEntercity() {
		return Entercity;
	}

	@FindBy(xpath = "//input[@id='state']")
	WebElement Enterstate;

	public WebElement getEnterstate() {
		return Enterstate;
	}

	@FindBy(xpath = "//div[@id='addressType-home']")
	WebElement SelectHome;

	public WebElement getSelectHome() {
		return SelectHome;
	}

	@FindBy(xpath = "//div[contains(text(),'ADD ADDRESS')]")
	WebElement ClickOnaddress;

	public WebElement getClickOnaddress() {
		return ClickOnaddress;
	}

	/////
	@FindBy(xpath = "//*[@id=\"placeOrderButton\"]")
	WebElement ClickOnproceedtocontinue;

	public WebElement getClickOnproceedtocontinue() {
		return ClickOnproceedtocontinue;
	}

	@FindBy(xpath = "//*[@id=\"cod\"]/span/span/div[2]/span")
	WebElement ClickOncashondelivery;

	public WebElement getClickOncashondelivery() {
		return ClickOncashondelivery;
	}

	@FindBy(xpath = "//*[@id=\"action-cod\"]")
	WebElement PlaceOrder;

	public WebElement getPlaceOrder() {
		return PlaceOrder;
	}

	@FindBy(xpath = "//span[contains(text(),'Profile')]")
	WebElement profile;

	public WebElement getProfile() {
		return profile;
	}

	@FindBy(xpath = "//div[contains(text(),'Logout')]")
	WebElement Signout;

	public WebElement getSignout() {
		return Signout;
	}

	@FindBy(xpath = "//a[contains(text(),'login / Signup')]")
	WebElement signuporlogin;

	public WebElement getsignuporlogin() {
		return signuporlogin;
	}

	@FindAll(@FindBy(xpath="/html/body/div[1]/div[2]/div/div/div/div/div/div[2]/div[1]/div[5]/div/div/div/div/div[2]/div/div[1]/a "))
	List<WebElement> Count;
	public List<WebElement> getCount() {
		return Count;
	}

	
	
	public MyntraPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
