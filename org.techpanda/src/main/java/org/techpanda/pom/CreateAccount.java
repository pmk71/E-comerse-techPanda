package org.techpanda.pom;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.techpanda.generic.FileLib;
import org.testng.Reporter;

public class CreateAccount {
	@FindBy(xpath = "//a[@title='Create an Account']")
	private WebElement createAccountBtn;

	@FindBy(id="firstname")
	private WebElement firstNameTxf;

	@FindBy(id = "lastname")
	private WebElement lastNameTxf;

	@FindBy(xpath="//input[@type='email' and @id='email_address']")
	private WebElement emailTbx;

	@FindBy(id="password")
	private WebElement passwordTbX;

	@FindBy(name = "confirmation")
	private WebElement confirmpasswordTbx;

	@FindBy(xpath ="//button[@title='Register']")
	private WebElement registerBtn;

	@FindBy(xpath ="//div/ul/li/ul/li/span")
	private WebElement registerConfirm;

	
	
	
	public CreateAccount(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void registerNewCustomer()
	{
		FileLib f= new FileLib();
		createAccountBtn.click();
		firstNameTxf.sendKeys("hihj"+f.getRandomNumber());
		lastNameTxf.sendKeys("gjds"+f.getRandomNumber());
		emailTbx.sendKeys("jfdisdfksdd"+f.getRandomNumber()+"@gmail.com");
		String pass="fjdkjskf"+f.getRandomNumber();
		passwordTbX.sendKeys(pass);
		confirmpasswordTbx.sendKeys(pass);
		registerBtn.click();
		boolean comfirm = registerConfirm.isDisplayed();
		assertTrue(comfirm);
		Reporter.log(registerConfirm.getText(),true);
	

	}

}
