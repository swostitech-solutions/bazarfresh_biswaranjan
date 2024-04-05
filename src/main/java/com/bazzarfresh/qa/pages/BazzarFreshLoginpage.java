package com.bazzarfresh.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bazarfresh.qa.Base.BaseTest;
public class BazzarFreshLoginpage extends BaseTest {
      @FindBy(name="email")
      WebElement userName;
      
      @FindBy(name="password")
      WebElement password;
      
      @FindBy(xpath="(//*[@class='btn btn-primary'])[2]")
      WebElement loginButton;
      
      public BazzarFreshLoginpage() {
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
