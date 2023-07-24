package org.techpanda.pom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.techpanda.generic.FileLib;
import org.testng.Reporter;

public class Mobile {
	FileLib f= new FileLib();

	@FindBy(xpath = "//select[@title='Sort By']")
	private WebElement sortBy;

	@FindBy(xpath="//ul[@class]/li/a[@title]")
	private List<WebElement> allItems;

	@FindBy(xpath="//a[@title='Sony Xperia']/../..//span[@class='price']")
	private WebElement priceSonyExperia;

	@FindBy(xpath = "//a[@title='Xperia']")
	private WebElement clickonxperia;

	@FindBy(xpath="//span[text()='Sony Xperia']/../..//span[@class='price']")
	private WebElement priceSonyExperiafromDetailsPage;


	@FindBy(xpath = "//a[text()='Sony Xperia' and @title]/../..//button")
	private WebElement addSonytoCart;


	@FindBy(xpath = "//input[@type='text']")
	private WebElement qtyToSony;

	@FindBy(xpath = "//button[@name='update_cart_action']//span[text()='Update']")
	private WebElement addToCartBtnQtyUpdate;


	@FindBy(xpath = "//p[@class='item-msg error']")
	private WebElement errorMessage;



	@FindBy(xpath = "//a[@class='skip-link skip-cart ']")
	private WebElement miniCart;

	@FindBy(xpath = "//a[@title='Remove This Item']")
	private WebElement removeBtn;


	@FindBy(xpath = "//p[@class='empty']")
	private WebElement cartMessage;

	@FindBy(xpath = "//a[text()='IPhone']/../..//a[text()='Add to Compare']")
	private WebElement addToCompareIphone;

	@FindBy(xpath = "//a[text()='Sony Xperia']/../..//a[text()='Add to Compare']")
	private WebElement addToCompareSony;

	@FindBy(xpath = "//button/span/span[text()='Compare']")
	private WebElement compareBtn;

	@FindBy(xpath = "//h1")
	private WebElement headingOfComapre;

	public Mobile(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSortBy() {
		return sortBy;
	}

	public List<WebElement> getAllItems() {
		return allItems;
	}

	public String getPriceOfSonyXperia()
	{
		return priceSonyExperia.getText();
	}


	public void clickOnxperia()
	{
		clickonxperia.click();
	}
	public String getPriceOfSonyXperiaFromDetailsPage()
	{
		return priceSonyExperiafromDetailsPage.getText();
	}

	public void addMoreProductsToCart()
	{
		addSonytoCart.click();
		qtyToSony.sendKeys("1000");
		addToCartBtnQtyUpdate.click();

	}

	public WebElement getErrorMessage() {
		return errorMessage;
	}

	public void clearCart(WebDriver driver)
	{
		miniCart.click();
		removeBtn.click();
		driver.switchTo().alert().accept();
		String text = cartMessage.getText();
		Reporter.log(text);
	}

	public void compareMobile(WebDriver driver) throws EncryptedDocumentException, IOException
	{
		addToCompareIphone.click();
		addToCompareSony.click();
		compareBtn.click();
		Set<String> win = driver.getWindowHandles();

		boolean count = (win.size()>1);
		assertTrue(count,"the window is not opened in separate window");
		String atext = f.getExcelData("test4", 0, 1);


		for(String w:win)
		{
			driver.switchTo().window(w).getTitle();
			if(headingOfComapre.equals(atext))
			{
				//verifying the heading 
				assertEquals(atext, headingOfComapre.getText(),"heading is not matching");

				// closing the window
				driver.close();

				//verifying pop-up window is closed or not

				Set<String> count2 = driver.getWindowHandles();
				boolean condition2 = (count2.size()==1);
				assertTrue(condition2);


			}
		}
	}

}
