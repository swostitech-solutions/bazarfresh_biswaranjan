package com.bazzarfresh.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bazzarfresh.qa.basetest.Basetest;
import com.bazzarfresh.qa.commonutility.Xls_Reader;
import com.bazzarfresh.qa.pages.BazzarFreshRegistrationpage;

/**
 * <b>Register into Bazar Fresh Aplication</b>
 * <p>
 * Open browser with bazar fresh url
 * </p>
 * <p>
 * Enter your firstname into firstname field
 * </p>
 * <p>
 * Enter your lastname into lastname field
 * </p>
 * <p>
 * Enter your gmail into gmail field
 * </p>
 * <p>
 * Enter your phonenumber into telephone field
 * </p>
 * <p>
 * Enter your password into password field
 * </p>
 * <p>
 * Again enter your password into password confirm field
 * </p>
 * <p>
 * Click on term and condition checkbox
 * </p>
 * <p>
 * Then submit your form through click the continue button
 * </p>
 *
 * @author Biswaranjan Maharana
 */

public class RegistrationTest extends Basetest {
	
	BazzarFreshRegistrationpage Registrationpage;
	
	@BeforeMethod
	public void setup() {
		initialization();
		Registrationpage=new BazzarFreshRegistrationpage();
	}
	@Test
	public void verifyRegistrationTest() throws InterruptedException {
		Xls_Reader reader=new Xls_Reader("V:\\git_automation\\bazarfresh_biswaranjan\\src\\main\\java\\com\\bazzarfresh\\qa\\testdata\\bazarfreshdata.xlsx");
		String Modulename="Registration";
		String firstname=reader.getCellData(Modulename,"FIRST NAME" , 2);
		String lastname=reader.getCellData(Modulename, "LAST NAME", 2);
		String email=reader.getCellData(Modulename, "GMAIL ACCOUNT", 2);
		String telephone=reader.getCellData(Modulename,"TELEPHONE", 2);
		String password=reader.getCellData(Modulename, "PASSWORD", 2);
		String confirmpassword=reader.getCellData(Modulename, "CONFIRM PASSWORD", 2);
		
		Registrationpage.ClickOnSignup();
		Registrationpage.EnterFirstName(firstname);
		Registrationpage.EnterLastName(lastname);
		Registrationpage.EnterGmail(email);
		Registrationpage.EnterPhone(telephone);
		Registrationpage.EnterPassword(password);
		Registrationpage.EnterConfirmPassword(confirmpassword);
		Registrationpage.ClickOnterms();
		Registrationpage.ClickOnContinue();
		Thread.sleep(5000);
		
		String ActualMessage=Registrationpage.VerifyWarningAlert();
		String ExpectedMesage="Warning: E-Mail Address is already registered!";
		Assert.assertTrue(ActualMessage.contains(ExpectedMesage), "This Warning Message Is Wrong Expected Warning Is" + " " + ExpectedMesage);
	}
	
//	@Test(priority = 2)
//	
//	public void VerifyLogout() {
//		Registrationpage.ClickOnLogout();
//	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
