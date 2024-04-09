package com.EStoreBazzarFresh.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.EStoreBazzarFresh.qa.Basetest.Basetest;


public class EStoreBazzarFreshRegistrationPage extends Basetest {
	@FindBy(linkText="Signup")
	WebElement Signup;
	@FindBy(id="input-firstname")
	WebElement firstname;
	@FindBy(id="input-lastname")
	WebElement lastname;
	@FindBy(id="input-email")
	WebElement gmail;
	@FindBy(id="input-telephone")
	WebElement phone;
	@FindBy(id="input-password")
	WebElement password;
	@FindBy(id="input-confirm")
	WebElement confirm;
	@FindBy(xpath ="//*[@name='agree']")
	WebElement Check;
	@FindBy(xpath = "//*[@class='btn btn-primary']")
	WebElement Continue;
	@FindBy(xpath = "//*[@class='alert alert-danger alert-dismissible']")
	WebElement Warningalert;
//	@FindBy(linkText = "Logout")
//	WebElement logout;
	
	public EStoreBazzarFreshRegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnSignup() {
		Signup.click();
	}
	
	public void EnterFirstName(String FirstName) {
		firstname.sendKeys(FirstName);
	}
	public void EnterLastName(String LastName) {
		lastname.sendKeys(LastName);
	}
	public void EnterGmail(String Gmail) {
		gmail.sendKeys(Gmail);
	}
	public void EnterPhone(String Phone) {
		phone.sendKeys(Phone);
	}
	public void EnterPassword(String Password) {
		password.sendKeys(Password);
	}
	public void EnterConfirmPassword(String AgainPassword) {
		confirm.sendKeys(AgainPassword);
	}
	public void ClickOnterms() {
		Check.click();
	}
	
	public void ClickOnContinue() {
		Continue.click();
	}
	
	public String VerifyWarningAlert() {
		String str=Warningalert.getText();
		return str;
		}
	
//	public void ClickOnLogout() {
//		logout.click();
//	}

}
