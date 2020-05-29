package com.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.testbase.TestBase;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initilization();
		loginpage = new LoginPage();
	}
	
	@Test
	public void loginTest() {
		homepage = loginpage.login();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
		}
}
