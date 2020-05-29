package com.qa.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
	try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("E:\\Automation Folder\\Eclipse Workspace\\FreeCRM\\src\\main\\java\\com\\qa\\propertyfile\\config.properties");
	     prop.load(ip);
} catch (FileNotFoundException e) {
	e.printStackTrace();
	System.out.println("config file is not found.....");
} catch (IOException e) {
	e.printStackTrace();
}
	}
	
	
	public static void initilization() {
		String browserName =  prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			
		} else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
		
		} else {
			System.out.println(browserName + " is not found, please pass the right browser Name");
		}
		
		System.out.println("Running on ----> " + browserName + " browser");
		

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	
	}

	
	

