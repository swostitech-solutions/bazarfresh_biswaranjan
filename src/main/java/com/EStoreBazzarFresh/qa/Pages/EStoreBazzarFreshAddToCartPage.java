package com.EStoreBazzarFresh.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.EStoreBazzarFresh.qa.Basetest.Basetest;

public class EStoreBazzarFreshAddToCartPage extends Basetest {
	@FindBy(xpath ="(//span/i[@class='fa fa-bars'])[2]")
	WebElement ShopeByCategory;
	
	@FindBy(linkText  ="Groceries & Kirana")
	WebElement GroceriesAndKirana;
	
	@FindBy(name = "email")
	WebElement emailId;
	
	@FindBy(xpath ="//*[@id='add-cart-473']")
	WebElement AddAlmonds;
	
	@FindBy(xpath ="//*[@id='add-cart-477']")
	WebElement AmulMozzarellaCheese;
	@FindBy(xpath ="//*[@class='btn btn-inverse btn-block btn-lg dropdown-toggle active']")
	WebElement MyBasket;
	
	@FindBy(xpath = "//*[@class='checkout']")
	WebElement Checkout;
	
	
		public EStoreBazzarFreshAddToCartPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void ClickOnShopeByCategory() {
		
//		jScriptExecution(ShopeByCategory);
//		ShopeByCategory.click();
		jScriptExecution(ShopeByCategory);
		
		
		
	}
		
		
		public void ClickOnGroceriesAndKirana() {
		
		GroceriesAndKirana.click();
		
		}
		
		public void ClickOnAddAlmonds() {
		
			AddAlmonds.click();
		
		}
		public void ClickOnAmulMozzarellaCheese() {
		
			AmulMozzarellaCheese.click();
		
		}
		
		public void ClickOnMyBasket() {
		
			jScriptExecution(MyBasket);
		
		}
		
		public void ClickOnCheckout() {
		
			
			Checkout.click();
		
		}
	
 		public boolean IsLoginScreenDisplayed()
 		{
 			boolean status=emailId.isDisplayed();
 			return status;
 		}

}
