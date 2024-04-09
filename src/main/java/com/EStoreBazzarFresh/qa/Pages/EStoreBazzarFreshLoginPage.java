package com.EStoreBazzarFresh.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.EStoreBazzarFresh.qa.Basetest.Basetest;

public class EStoreBazzarFreshLoginPage extends Basetest{
	@FindBy(name="email")
    WebElement userName;
    
    @FindBy(name="password")
    WebElement password;
    
    @FindBy(xpath="(//*[@class='btn btn-primary'])[2]")
    WebElement loginButton;
    
    public EStoreBazzarFreshLoginPage() {
  	  PageFactory.initElements(driver, this);
    }
    
    public void EnterUsername(String Username) {
  	  userName.sendKeys(Username);
    }
    
    public void EnterPassword(String Password) {
  	  password.sendKeys(Password);
    }
    public void ClickOnSubmitButton() {
  	  loginButton.click();
    }

}
