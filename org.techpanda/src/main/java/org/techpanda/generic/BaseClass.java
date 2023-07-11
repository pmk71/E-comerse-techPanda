package org.techpanda.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.techpanda.pom.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static ThreadLocal <WebDriver> driver =new ThreadLocal<>();

	//public static WebDriver driver;

	static
	{
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.edgedriver().setup();
	}

	FileLib fb= new FileLib();
	//	@BeforeClass
	//	public void lauchBrowser() throws IOException
	//	{
	//		driver.set(new FirefoxDriver());
	//		driver.get().manage().window().maximize();
	//		driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	//
	//	}

	@BeforeClass

	public void enterUrl() throws IOException
	{driver.set(new FirefoxDriver());
	getDriver().manage().window().maximize();
	getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	String url = fb.getPropertyData("url");
	driver.get().get(url);
	}

	@AfterClass
	public void closeBrowser()
	{
		driver.get().quit();
	}

	public WebDriver getDriver() {
		return driver.get();
	}

}
