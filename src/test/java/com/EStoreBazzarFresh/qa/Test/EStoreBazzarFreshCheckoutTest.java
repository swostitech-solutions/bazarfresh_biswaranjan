package com.EStoreBazzarFresh.qa.Test;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.EStoreBazzarFresh.qa.Basetest.Basetest;
import com.EStoreBazzarFresh.qa.Pages.EStoreBazzarFreshCheckoutPage;

public class EStoreBazzarFreshCheckoutTest extends Basetest{
	EStoreBazzarFreshCheckoutPage CheckoutPage;

	@BeforeMethod
	public void setUP() {
//		initialization();
		CheckoutPage = new EStoreBazzarFreshCheckoutPage();
		
	}
	
	@Test
	public void VerifyCheckoutTest() throws InterruptedException {
		
		CheckoutPage.LoginIntoBazzarFresh("Manasjn06@gmail.com","Test");
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void Teardown() {
		driver.close();
	}
}


