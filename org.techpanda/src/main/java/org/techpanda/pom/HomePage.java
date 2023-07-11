package org.techpanda.pom;

import javax.swing.border.TitledBorder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
@FindBy(xpath = "//a[text()='Mobile']")
private WebElement mobileTab;


@FindBy(xpath = "//h2")
private WebElement tiltle;

@FindBy(xpath = "//a//span[text()='Account']")
private WebElement accountBtn;


@FindBy(xpath = "(//a[@title='My Account'])[2]")
private WebElement myaccountbtn;

public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}


public WebElement getMobileTab() {
	return mobileTab;
}

public String getTitle() {

	
		return this.tiltle.getText();
}

public void clickOnAccountCreate() throws InterruptedException
{
	
	myaccountbtn.click();
	
}





}
