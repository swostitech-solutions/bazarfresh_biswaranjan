package com.bazzarfresh.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.bazzarfresh.qa.basetest.Basetest;
import com.bazzarfresh.qa.commonutility.Xls_Reader;
import com.bazzarfresh.qa.pages.BazzarFreshLoginpage;

/**
 * <b>Login into Bazar Fresh Application </b>
 * <p>Open browser with bazar fresh url</p>
 * <p>Enter username into userid field</p>
 * <p>Enter password into password field</p>
 * <p>click on login button</p>
 * 
 * @author Biswaranjan Maharana
 */

public class LoginTest extends Basetest {

	BazzarFreshLoginpage Loginpage;
	
	@BeforeMethod
	public void setup() {
		initialization();
		Loginpage=new BazzarFreshLoginpage();
	}
	
	@Test
	public void VerifyLoginIntoApplicationTest() {
		Xls_Reader reader=new Xls_Reader("V:\\git_automation\\bazarfresh_biswaranjan\\src\\main\\java\\com\\bazzarfresh\\qa\\testdata\\bazarfreshdata.xlsx");
		String ModuleName="Registration";
		
		String username=reader.getCellData(ModuleName,"EmailId" , 2);
		String password=reader.getCellData(ModuleName, "Password", 2);
		
		Loginpage.EnterUsername(username);
		Loginpage.EnterPassword(password);
		Loginpage.ClickOnSubmitButton();
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
}
