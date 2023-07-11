package org.techpanda.testscrits;

import org.techpanda.generic.FileLib;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestData {

	
	@Test(dataProvider = "ll")
	public void printData(String un ,String pwd,String c)
	{
		System.out.println(un +"-------"+pwd+c);
	}
	
	@DataProvider(name = "ll")
	public Object[][] getLoginData() throws Throwable
	{
		
		FileLib fl= new FileLib();
		return fl.toReadMultipleData("login");
		
		
	}
}
