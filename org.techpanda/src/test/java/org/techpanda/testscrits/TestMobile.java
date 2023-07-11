package org.techpanda.testscrits;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.techpanda.generic.BaseClass;
import org.techpanda.generic.SUtils;
import org.techpanda.pom.HomePage;
import org.techpanda.pom.Mobile;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMobile extends BaseClass{



	@Test(priority = 1)
	public void testMobileList() throws InterruptedException
	{
		Mobile m= new Mobile(driver.get());
		HomePage p= new HomePage(driver.get());
		SUtils u= new SUtils();


		//  to verify the tile (actually verify heading h2)

		String etitle =p.getTitle().trim();
		String atitle = "THIS IS DEMO SITE FOR";
		Assert.assertEquals(etitle, atitle, "title is not matching");
		// click on mobile menu
		p.getMobileTab().click();


		// verify title after clicking on MObile but case need to be ignored here
		String etitle1 = driver.get().getTitle();
		String atitle1 = "Mobile";
		System.out.println(etitle1);

		// to sort items by name
		Assert.assertEquals(etitle1, atitle1);
		Select s= new Select(m.getSortBy());
		s.selectByIndex(1);

		// to get all mobile
		ArrayList<String> al= new ArrayList<String>();
		ArrayList<String> a2= new ArrayList<String>();

		List<WebElement> allMobiel = m.getAllItems();
		for(WebElement mb:allMobiel)
		{
			String text = mb.getAttribute("title");
			al.add(text);
			a2.add(text);
		}


		Collections.sort(a2);
		// to check items are sorted or not

		boolean sorted = al.equals(a2);
		Assert.assertTrue(sorted);



	}

	@Test(priority = 2)
	public void testPrice()

	{
		HomePage p= new HomePage(driver.get());
		Mobile m=new Mobile(driver.get());
		p.getMobileTab().click();

		String pricefromMobileP = m.getPriceOfSonyXperia();
		m.clickOnxperia();
		String pricefromdetails = m.getPriceOfSonyXperiaFromDetailsPage();
		assertEquals(pricefromdetails, pricefromMobileP);
	}


	@Test(priority = 3)
	public void testQtyCart()
	{
		HomePage p= new HomePage(driver.get());
		Mobile m=new Mobile(driver.get());
		p.getMobileTab().click();
		m.addMoreProductsToCart();
		String error= m.getErrorMessage().getText();
		Reporter.log(error,true);

		m.clearCart(driver.get());

	}

	@Test(priority = 4)
	public void testComparision() throws EncryptedDocumentException, IOException
	{
		HomePage p= new HomePage(getDriver());
		Mobile m=new Mobile(getDriver());
		p.getMobileTab().click();
		m.compareMobile(getDriver());

	}

	
}
