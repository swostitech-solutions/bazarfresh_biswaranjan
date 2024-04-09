package com.EStoreBazzarFresh.qa.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.EStoreBazzarFresh.qa.Basetest.Basetest;
import com.EStoreBazzarFresh.qa.Pages.EStoreBazzarFreshAddToCartPage;

public class EStoreAddToCartTest extends Basetest{
	EStoreBazzarFreshAddToCartPage addtocartpage;
	@BeforeMethod
	public void setUP() {
		initialization();
		addtocartpage = new EStoreBazzarFreshAddToCartPage();
		
	}
	@Test
	public void VerifyAddToCartTest() throws InterruptedException {
		addtocartpage.ClickOnShopeByCategory();
		Thread.sleep(2000);
		addtocartpage.ClickOnGroceriesAndKirana();
		Thread.sleep(2000);
		addtocartpage.ClickOnAddAlmonds();
		Thread.sleep(2000);
		addtocartpage.ClickOnAmulMozzarellaCheese();
		Thread.sleep(2000);
		addtocartpage.ClickOnMyBasket();
		Thread.sleep(2000);
		addtocartpage.ClickOnCheckout();
		Thread.sleep(3000);
		
	}
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

}
