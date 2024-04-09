package com.EStoreBazzarFresh.qa.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.EStoreBazzarFresh.qa.Basetest.Basetest;
import com.EStoreBazzarFresh.qa.Pages.EStoreBazzarFreshLoginPage;
import com.EStoreBazzarFresh.qa.commonutility.Xls_Reader;





/**
 * <b>Login into Bazar Fresh Application </b>
 * <p>Open browser with bazar fresh url</p>
 * <p>Enter username into userid field</p>
 * <p>Enter password into password field</p>
 * <p>click on login button</p>
 * 
 * @author Biswaranjan Maharana this is automate by Biswaranjan Maharana
 */


public class EStoreLoginTest extends Basetest{
	
EStoreBazzarFreshLoginPage Loginpage;
	
	@BeforeMethod
	public void setup() {
		initialization();
		Loginpage=new EStoreBazzarFreshLoginPage();
	}
	
	@Test
	public void VerifyLoginIntoApplication() throws InterruptedException {
		Xls_Reader reader=new Xls_Reader("V:\\git_automation\\autoworkspace\\EStoreBazzarFresh\\src\\main\\java\\com\\EStroreBazzarFresh\\qa\\TestData\\bazarfreshdata.xlsx");
		String ModuleName="Registration";
		
		String username=reader.getCellData(ModuleName,"GMAIL ACCOUNT", 2);
		String password=reader.getCellData(ModuleName, "PASSWORD", 2);
		
		System.out.println(username);
		System.out.println(password);
		
		Loginpage.EnterUsername(username);
		Loginpage.EnterPassword(password);
		Loginpage.ClickOnSubmitButton();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
