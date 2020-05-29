package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath ="//span[text()=\"Log In\"]") 
	WebElement Logon_btn;
	
	@FindBy(name ="email") 
	WebElement username;
	
	@FindBy(name ="password") 
	WebElement password;
	
	@FindBy(xpath ="//div[text()=\"Login\"]") 
	WebElement login_btn;
	

	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	public HomePage login() {
		Logon_btn.click();
		username.sendKeys("shiraz8123ahmed@gmail.com");
		password.sendKeys("Test@1234");
		login_btn.click();
		return new HomePage();
	}
		
	}

