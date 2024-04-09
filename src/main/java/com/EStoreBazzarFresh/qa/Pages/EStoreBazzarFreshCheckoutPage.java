package com.EStoreBazzarFresh.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.EStoreBazzarFresh.qa.Basetest.Basetest;

public class EStoreBazzarFreshCheckoutPage extends Basetest {
	@FindBy(id="input-email")
	WebElement Email;
	@FindBy(id="input-password")
	WebElement Password;
	@FindBy(id="button-login")
    WebElement LoginButton;


public EStoreBazzarFreshCheckoutPage() {
	
	PageFactory.initElements(driver, this);
}

public void LoginIntoBazzarFresh(String username,String password) {
	Email.sendKeys(username);
	Password.sendKeys(password);
	LoginButton.click();
}

}
