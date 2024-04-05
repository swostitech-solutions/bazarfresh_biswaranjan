package com.bazzarfresh.qa.basetest;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.bazzarfresh.qa.commonutility.WebEventListner;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {
	public static WebDriver driver;
	 public static Properties prop;
	 public static EventFiringWebDriver e_driver;
	 public static WebEventListner eventListener;
	 public static ThreadLocal<WebDriver> tdriver=new ThreadLocal<WebDriver>();
	 public int ThreadSleepTime=2000;
	 public static JavascriptExecutor js;
	 
	
	public Basetest()  {
		String path=System.getProperty("user.dir");
		System.out.println(path);
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream(path+"\\src\\main\\java\\com\\bazzarfresh\\qa\\configproperty\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String path=System.getProperty("user.dir");
		System.out.println(path);
		String Downloadpath=path+"\\downloads";
		String browsername=prop.getProperty("browser");
		System.out.println(browsername);
		if(browsername.equalsIgnoreCase("chrome")) {
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("disable-extension");
			opt.addArguments("--start-maximize");
			Map<String,Object> prefs = new HashMap<String,Object>();
	        prefs.put("profile.default_content_settings.popups", 0);
	        prefs.put("download.default_directory",Downloadpath);
	        prefs.put("profile.default_content_setting_values.automatic_downloads",1);
	        
	        opt.setExperimentalOption("prefs", prefs);
	        DesiredCapabilities cap = new DesiredCapabilities();
	        cap.setCapability(ChromeOptions.CAPABILITY, opt);    
	        opt.merge(cap);
	      //WebDriverManager.chromedriver().setup();
	        System.setProperty("webdriver.chrome.driver", path+"\\Driver\\chromedriver.exe");
	        driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", path+"\\Driver\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		else if(browsername.equalsIgnoreCase("edge")) {
//			System.setProperty("webdriver.edge.driver", path+"\\Driver\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		e_driver=new EventFiringWebDriver(driver);
		eventListener=new WebEventListner();
		e_driver.register(eventListener);
		driver=e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
//	Generic Functions
	public void SendKeys(WebElement element, String value) { // Function to enter value in textbox
		VisibleElement(driver,element,Duration.ofSeconds(20));
		try {			
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("Exception in SendKeys " + " " + e.getMessage());
		}
	}
	
	public void EnterKey(WebElement element, Keys key) {  // Function to use keyboard keys
		VisibleElement(driver,element,Duration.ofSeconds(20));
		try {			
			element.sendKeys(key);
		} catch (Exception e) {
			System.out.println("Exception in EnterKey " + " " + e.getMessage());
		}
	}
	public void ClearValues(WebElement element) {
		VisibleElement(driver,element,Duration.ofSeconds(20));
		try {			
			element.sendKeys(Keys.CONTROL + "a");
			element.sendKeys(Keys.DELETE);	
		} catch (Exception e) {
			System.out.println("Exception in " + " " + e.getMessage());
		}		
	}
	
	public String getCurrentDate() { //Function to get current date
		DateFormat format=new SimpleDateFormat("MM/dd/yyyy");
		Date systemDate=new Date();
		String CurrentDate=format.format(systemDate);
		return CurrentDate;
		
	}
	
	public void selectValue(WebElement element,String value) { // Function to select a value from drop down 
		Select dropDown  = new Select(element);
		dropDown.selectByVisibleText(value);
	}
	
	public void Log(String log) { // HTML Log statements
		Date date=new Date(System.currentTimeMillis());
		SimpleDateFormat formatter= new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		String datetime=formatter.format(date)	;
		System.out.println(datetime + "::" + log);
		Reporter.log(datetime +"::" + log);
	}
	
	//Get currentdate as string in mm//dd//yyyy format
	   public String currentDate() {
		   LocalDate date=LocalDate.now();
		   DateTimeFormatter f=DateTimeFormatter.ofPattern("MM/dd/yyyy");
		   String strDate=f.format(date);
		   return strDate;
	   }
	 //Generate a random value by passing the range
	   public int generaterandomValue(int max,int min) {
		   int randomValue=(int)(Math.random()*(max-min+1)+min);
		   return randomValue;
	   }
	 //Call mouse action by passing x and y coordinates
	   public void mouseActions(int x,int y) {
		   Actions action=new Actions(driver);
		  Action mouseHover = action.moveByOffset(x, y).click().build();
		  mouseHover.perform();
	   }
	   
	 // Javascript execution by passing element
	   public void jScriptExecution(WebElement element) {
		   JavascriptExecutor js=(JavascriptExecutor)driver;
		   js.executeScript("arguments[0].click", element);
	   }
	   
	   //Javascript to verify CheckBox is selected
	   public void jscriptChkBox(WebElement element) {
		   JavascriptExecutor js=(JavascriptExecutor)driver;
		   js.executeScript("return arguments[0].checked=true;", element);
		   System.out.println("checkbox is check");
	   }
	   
	   // Page Scroll Down
	   public void pageScrollDown() {
		   Actions actions=new Actions(driver);
		   actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
	   }
	   
	 // @Step("Taking screenshorts on failure")
	   public static WebDriver takeScreenshotAtEndOfTest() throws IOException {
		 File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String currentDir=System.getProperty("user.dir");
		 FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots" + System.currentTimeMillis() + ".png"));
		return driver;
		   
	   }
	   
	   //@Step("Waiting for element to load..")
	   public static void VisibleElement(WebDriver driver,WebElement locator,Duration i) {
		   new WebDriverWait(driver, i).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(locator));
	   }
	   
	   //Scroll until visible Element
	   public void scrollByVisibleElement(WebElement element) {
		   JavascriptExecutor js=(JavascriptExecutor)driver;
		   js.executeScript("arguments[0].scrollIntoView();", element);
	   }

}
