package org.techpanda.testscrits;

import org.techpanda.generic.BaseClass;
import org.techpanda.pom.CreateAccount;
import org.techpanda.pom.HomePage;
import org.techpanda.pom.TV;
import org.testng.annotations.Test;

public class TestCreateAccount extends BaseClass {
	/*    
	 * TeatCase=5
	 *  Verify can create an account in e-Commerce site and can share wishlist to other poeple using email.  
	Test Steps:
	1. Go to http://live.techpanda.org/
	2. Click on my account link
	3. Click Create an Account link and fill New User information except Email ID(now need to add emailID)
	4. Click Register
	5. Verify Registration is done. Expected account registration done.
	6. Go to TV menu
	7. Add product in your wish list - use product - LG LCD
	8. Click SHARE WISHLIST 
	9. In next page enter Email and a message and click SHARE WISHLIST
	10.Check wishlist is shared. Expected wishlist shared successfully but there is change 

	 */

	@Test(priority = 1)

	public void createAccountAndShareWhishList() throws InterruptedException
	{
		HomePage p= new HomePage(getDriver());
		CreateAccount ca= new CreateAccount(getDriver());
		TV t= new TV(getDriver());
		p.clickOnAccountCreate();

		ca.registerNewCustomer();
		t.shareWhishList();
		

	
		

	}
}
