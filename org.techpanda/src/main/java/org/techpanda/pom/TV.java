package org.techpanda.pom;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TV {

	@FindBy(xpath = "//a[text()='TV']")
	private WebElement TvModule;
	
	@FindBy(xpath = "//a[text()='LG LCD']/../..//a[text()='Add to Wishlist']")
	private WebElement addLGTVtoWhishList;
	
	@FindBy(xpath = "//span[text()='Share Wishlist']")
	private WebElement shareWhishList;
	
	@FindBy(xpath = "//textarea[@name='emails']")
	private WebElement textAreaMail;
	
	@FindBy(xpath = "//div[2]/button/span/span")
	private WebElement shareWhishListBtn;
	
	@FindBy(xpath = "//span[text()='Your Wishlist has been shared.']")
	private WebElement shareMeaasge;
	
 
	public TV(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void shareWhishList()
	{
		TvModule.click();
		addLGTVtoWhishList.click();
		shareWhishList.click();
		textAreaMail.sendKeys("prashanthmk71@gmail.com");
		shareWhishList.click();
		boolean mess = shareMeaasge.isDisplayed();
		assertTrue(mess, "the message is not present");
		
	}
}
