package org.techpanda.generic;

import java.time.LocalDateTime;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SUtils {

	public void waitForPageToLoad(WebDriver driver,String title)
	{
		WebDriverWait wait= new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.titleContains(title));
	}


	public String getDateStamp()
	{
		String stamp = LocalDateTime.now().toString().replace(":","");
		return stamp;

	}


}
