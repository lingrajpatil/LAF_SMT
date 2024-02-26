package com.BasePackage;

//import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;
import com.google.common.base.Throwables;
import com.google.common.base.Verify;


import java.io.IOException;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {

	public static RemoteWebDriver driver ;
	 String Browser ;
	 String Url;
	public static Properties configloader() throws IOException {
		FileInputStream File = new FileInputStream(".\\src\\test\\resources\\config.properties");
		Properties properties = new Properties();
		properties.load(File);
		return properties;
	}

	public void setup() throws IOException, InterruptedException {

		Browser = configloader().getProperty("Browser");
		 Url = configloader().getProperty("URL");
//		String UserName = configloader().getProperty("UserName");
//		String Password = configloader().getProperty("Password");

		switch (Browser.toUpperCase()) {

		case "CHROME":
			  // System Property for Chrome Driver   
//	        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");  
	          
	       
//			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setBrowserVersion("121");
//			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-extensions");
			options.addArguments("--incognito");
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("--disable-gpu");
//			options.addArguments("enable-automation");
//			options.addArguments("--headless");
//			options.addArguments("--window-size=1920,1080");
//			options.addArguments("--dns-prefetch-disable");
//			options.addArguments("--no-sandbox");
//			options.addArguments("--disable-dev-shm-usage"); 
//			options.addArguments("--aggressive-cache-discard"); 
//			options.addArguments("--disable-cache"); 
//			options.addArguments("--disable-application-cache"); 
//			options.addArguments("--disable-offline-load-stale-cache"); 
//			options.addArguments("--disk-cache-size=0");
//			options.addArguments("--dns-prefetch-disable"); 
//			options.addArguments("--no-proxy-server");  
//			options.addArguments("--silent"); 
//			options.addArguments("--disable-browser-side-navigation");
//			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//			options.setExperimentalOption("useAutomationExtension", false);
//			options.addArguments("--disable-blink-features");
//			options.addArguments("--disable-blink-features=AutomationControlled");
//			options.setProxy(null);
//			WebDriverManager.chromedriver().forceDownload().setup();
//			DesiredCapabilities capabilities = new DesiredCapabilities();
//			capabilities.setCapability("acceptInsecureCerts", true); // no dedicated method
//			driver = new ChromeDriver(options.merge(capabilities));
			  driver=new ChromeDriver(options); 
//			driver = new ChromeDriver(options);
			
			break;

		case "FIREFOX":

			WebDriverManager.firefoxdriver().setup();
			
			FirefoxOptions options1 = new FirefoxOptions();
			options1.addArguments("--disable-extensions");
			options1.addArguments("-private");
//			driver = new FirefoxDriver(options1);
			
//			options1.setPageLoadStrategy(PageLoadStrategy.EAGER);
//			options1.addArguments("--disable-gpu");
//			options1.addArguments("enable-automation");
////			options.addArguments("--headless");
//			options1.addArguments("--window-size=1920,1080");
//			options1.addArguments("--dns-prefetch-disable");
//			options1.addArguments("--no-sandbox");
//			options1.addArguments("--disable-dev-shm-usage"); 
//			options1.addArguments("--aggressive-cache-discard"); 
//			options1.addArguments("--disable-cache"); 
//			options1.addArguments("--disable-application-cache"); 
//			options1.addArguments("--disable-offline-load-stale-cache"); 
//			options1.addArguments("--disk-cache-size=0");
//			options1.addArguments("--dns-prefetch-disable"); 
//			options1.addArguments("--no-proxy-server");  
//			options1.addArguments("--silent");
			WebDriverManager.firefoxdriver().forceDownload().setup();
			driver = new FirefoxDriver(options1);
			break;

		case "EDGE":

			WebDriverManager.edgedriver().setup();
			
			EdgeOptions options2 = new EdgeOptions();
			options2.addArguments("--disable-extensions");
			options2.addArguments("-private");
			driver = new EdgeDriver(options2);
			break;
			
			
		default:
			System.err.println("The Driver is not defined");
			Log.info("The Driver is not defined");
			ExtentTestManager.getTest().log(Status.PASS, "The Driver is not defined");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(150));
//		driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(50));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		Log.info(Browser+" browser launched successfully");
		ExtentTestManager.getTest().log(Status.PASS, Browser+" browser launched successfully");
		driver.get(Url);
		Log.info("Entered the application url successfully: "+Url);
		ExtentTestManager.getTest().log(Status.PASS, "Entered the application url successfully: "+Url);

		
		
//		Thread.sleep(100);
		/*
		 * driver.navigate().refresh(); driver.findElement(L_email).sendKeys(UserName);
		 * driver.findElement(L_password).sendKeys(Password);
		 * driver.findElement(L_Submit).click();
		 */

	}
	

	public void setup_Change_brand() throws IOException, InterruptedException {

		Browser = configloader().getProperty("Browser");
		 Url = configloader().getProperty("URL1");
//		String UserName = configloader().getProperty("UserName");
//		String Password = configloader().getProperty("Password");

		switch (Browser.toUpperCase()) {

		case "CHROME":

//			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setBrowserVersion("121");
			options.addArguments("--disable-extensions");
			options.addArguments("--incognito");
//			DesiredCapabilities capabilities = new DesiredCapabilities();
//			capabilities.setCapability("acceptInsecureCerts", true); // no dedicated method
//			driver = new ChromeDriver(options.merge(capabilities));
			driver=new ChromeDriver(options);
			break;

		case "FIREFOX":

			WebDriverManager.firefoxdriver().setup();
			
			FirefoxOptions options1 = new FirefoxOptions();
			options1.addArguments("--disable-extensions");
			options1.addArguments("-private");
			driver = new FirefoxDriver(options1);
			break;

		default:
			System.err.println("The Driver is not defined");
			Log.info("The Driver is not defined");
			ExtentTestManager.getTest().log(Status.PASS, "The Driver is not defined");
		}
		Log.info(Browser+" browser launched successfully");
		ExtentTestManager.getTest().log(Status.PASS, Browser+" browser launched successfully");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout( Duration.ofSeconds(50));
		driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(50));
		
		driver.get(Url);
		Log.info("Successfully entered the admin page url: "+Url);
		ExtentTestManager.getTest().log(Status.PASS, "Successfully entered the admin page url: "+Url);
		
//		Thread.sleep(100);
		/*
		 * driver.navigate().refresh(); driver.findElement(L_email).sendKeys(UserName);
		 * driver.findElement(L_password).sendKeys(Password);
		 * driver.findElement(L_Submit).click();
		 */

	}
	
		

	public void setup(String mobile) throws Exception {

		String Browser = configloader().getProperty("Browser");
		String Url = configloader().getProperty("URL");
//		String UserName = configloader().getProperty("UserName");
//		String Password = configloader().getProperty("Password");
try {
	
	switch (Browser.toUpperCase()) {

	case "CHROME":

		Map<String, String> mp=new HashMap<String, String>();
		mp.put("deviceName", mobile);
//		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		options.setBrowserVersion("115");
		options.addArguments("--incognito");
		options.setExperimentalOption("mobileEmulation", mp );
		driver = new ChromeDriver(options);
//		 = "iPhone SE"
		
		 
//		org.openqa.selenium.Dimension d = new org.openqa.selenium.Dimension(800, 800);
//		  
//		 driver.manage().window().setSize(d);
		
		break;

	case "FIREFOX":

		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options1 = new FirefoxOptions();
		options1.addArguments("--disable-extensions");
		options1.addArguments("-private");
		driver = new FirefoxDriver(options1);
		break;

	default:
		System.err.println("The Driver is not defined");
		Log.info("The Driver is not defined");
		ExtentTestManager.getTest().log(Status.PASS, "The Driver is not defined");
	}
	Log.info(Browser+" browser launched successfully");
	ExtentTestManager.getTest().log(Status.PASS, Browser+" browser launched successfully");
	driver.manage().timeouts().pageLoadTimeout( Duration.ofSeconds(50));
	driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(50));
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get(Url);
	Log.info("Entered the application url successfully");
	ExtentTestManager.getTest().log(Status.PASS, "Entered the application url successfully");
	
	
	Thread.sleep(1000);
	/*
	 * driver.navigate().refresh(); driver.findElement(L_email).sendKeys(UserName);
	 * driver.findElement(L_password).sendKeys(Password);
	 * driver.findElement(L_Submit).click();
	 */
	
} catch (Exception e) {
	
//	Log.error(e.toString());
	ExtentTestManager.getTest().log(Status.FAIL, e.toString() );
	throw new Exception(e.getMessage());

}
		

	}
	

	public void setup(int width, int height ) throws IOException, InterruptedException {

		String Browser = configloader().getProperty("Browser");
		String Url = configloader().getProperty("URL");
//		String UserName = configloader().getProperty("UserName");
//		String Password = configloader().getProperty("Password");

		switch (Browser.toUpperCase()) {

		case "CHROME":
//
//			Map<String, String> mp=new HashMap<String, String>();
//			mp.put("deviceName", mobile);
//			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setBrowserVersion("115");
			options.addArguments("--disable-extensions");
			options.addArguments("--incognito");
//			options.setExperimentalOption("mobileEmulation", mp );
			driver = new ChromeDriver(options);
//			 = "iPhone SE"
			
//			org.openqa.selenium.Dimension d = new org.openqa.selenium.Di
			org.openqa.selenium.Dimension d = new org.openqa.selenium.Dimension( width, height);
//			  
			 driver.manage().window().setSize(d);
			
			break;

		case "FIREFOX":

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.err.println("The Driver is not defined");
			Log.info("The Driver is not defined");
			ExtentTestManager.getTest().log(Status.PASS, "The Driver is not defined");
		}
		Log.info(Browser+" browser launched successfully");
		ExtentTestManager.getTest().log(Status.PASS, Browser+" browser launched successfully");
//		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().deleteAllCookies();
		driver.get(Url);
		Log.info("Entered the application url successfully");
		ExtentTestManager.getTest().log(Status.PASS, "Entered the application url successfully");
		Thread.sleep(1000);
		/*
		 * driver.navigate().refresh(); driver.findElement(L_email).sendKeys(UserName);
		 * driver.findElement(L_password).sendKeys(Password);
		 * driver.findElement(L_Submit).click();
		 */

	}
	
	
	public void setup_ClubStudio() throws IOException, InterruptedException {

		Browser = configloader().getProperty("Browser");
		 Url = configloader().getProperty("URL_ClubStudio");
//		String UserName = configloader().getProperty("UserName");
//		String Password = configloader().getProperty("Password");

		switch (Browser.toUpperCase()) {

		case "CHROME":

//			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			options.addArguments("--incognito");
			options.setBrowserVersion("115");
//			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
//			options.addArguments("--disable-gpu");
//			options.addArguments("enable-automation");
////			options.addArguments("--headless");
//			options.addArguments("--window-size=1920,1080");
//			options.addArguments("--dns-prefetch-disable");
//			options.addArguments("--no-sandbox");
//			options.addArguments("--disable-dev-shm-usage"); 
//			options.addArguments("--aggressive-cache-discard"); 
//			options.addArguments("--disable-cache"); 
//			options.addArguments("--disable-application-cache"); 
//			options.addArguments("--disable-offline-load-stale-cache"); 
//			options.addArguments("--disk-cache-size=0");
//			options.addArguments("--dns-prefetch-disable"); 
//			options.addArguments("--no-proxy-server");  
//			options.addArguments("--silent"); 
//			options.addArguments("--disable-browser-side-navigation");
//			options.setProxy(null);
//			WebDriverManager.chromedriver().forceDownload().setup();
			driver = new ChromeDriver(options);
			
			break;

		case "FIREFOX":

			WebDriverManager.firefoxdriver().setup();
			
			FirefoxOptions options1 = new FirefoxOptions();
			options1.addArguments("--disable-extensions");
			options1.addArguments("-private");
			driver = new FirefoxDriver(options1);
			break;

		default:
			System.err.println("The Driver is not defined");
			Log.info("The Driver is not defined");
			ExtentTestManager.getTest().log(Status.PASS, "The Driver is not defined");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(150));
//		driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(50));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		Log.info(Browser+" browser launched successfully");
		ExtentTestManager.getTest().log(Status.PASS, Browser+" browser launched successfully");
		driver.get(Url);
		Log.info("Entered the application url successfully: "+Url);
		ExtentTestManager.getTest().log(Status.PASS, "Entered the application url successfully: "+Url);

		
		
//		Thread.sleep(100);
		/*
		 * driver.navigate().refresh(); driver.findElement(L_email).sendKeys(UserName);
		 * driver.findElement(L_password).sendKeys(Password);
		 * driver.findElement(L_Submit).click();
		 */

	}

	
	public void Element_isdisplayed(By element) throws Exception {
		try {

			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
			Assert.assertTrue(wait2.until(ExpectedConditions.presenceOfElementLocated(element)).isDisplayed());
			
	
		} catch (Exception e) {
			String stackTrace = Throwables.getStackTraceAsString(e);
			Log.error( stackTrace);
			throw new Exception("Element: "+ element +" is not displayed");
			
		}
		catch (AssertionError e) {
			String stackTrace = Throwables.getStackTraceAsString(e);
			Log.error( stackTrace);
			throw new Exception("Element: "+ element +" is not displayed");
		}
		
Thread.sleep(100);
		
	}
	
	
	public boolean Element_isChecked(By element) throws Exception {
		boolean b=false;
		try {
			WebDriverWait wait2 = new WebDriverWait(driver,  Duration.ofSeconds(30));
			wait2.until(ExpectedConditions.presenceOfElementLocated(element));
			 b= ((WebElement) wait2).isSelected();
	
		} catch (Exception e) {
			throw new Exception("Element: "+ element +" is not displayed");
		}
		
//		WebDriverWait wait2 = new WebDriverWait(driver, 30);
//		Assert.assertTrue(wait2.until(ExpectedConditions.presenceOfElementLocated(element)).isDisplayed(), "Element: "+ element +" is not displayed");
//		Assert.assertTrue(driver.findElement(element).isDisplayed());
		return b;
		
	}
	
	public void MoveToElement(By element) throws InterruptedException {
		Thread.sleep(100);
		WebElement element1 = driver.findElement(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element1).perform();
//		actions.perform();
		Thread.sleep(500);
	}
	
	public void MoveTo_webelement(WebElement element) throws InterruptedException {
		Thread.sleep(100);
//		WebElement element1 = driver.findElement(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
//		actions.perform();
		Thread.sleep(500);
	}
	
	public void MoveToElement_and_click(By element) throws InterruptedException {
		Thread.sleep(100);
		WebElement element1 = driver.findElement(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element1).click().perform();
//		actions.perform();
		Thread.sleep(500);
	}
	
public ExpectedCondition<Boolean> Verify_staleelement(WebElement element) throws InterruptedException {
		
//		WebDriverWait wait2 = new WebDriverWait(driver, 30);
//	return	wait2.until(ExpectedConditions.stalenessOf(element));
	return ExpectedConditions.stalenessOf(element);
		
	}
	
	
	
	public static void input(By element, String Value) throws InterruptedException {
		
		WebDriverWait wait2 = new WebDriverWait(driver,  Duration.ofSeconds(30));
		wait2.until(ExpectedConditions.presenceOfElementLocated(element)).click();
		Thread.sleep(100);
		wait2.until(ExpectedConditions.presenceOfElementLocated(element)).sendKeys(Value);
		Thread.sleep(100);

	}
	
	
public static void Clear(By element) throws InterruptedException {
		
		WebDriverWait wait2 = new WebDriverWait(driver,  Duration.ofSeconds(30));
		wait2.until(ExpectedConditions.presenceOfElementLocated(element)).clear();
		Thread.sleep(100);

	}
	

	public static void click(By element) throws InterruptedException {

		Thread.sleep(100);
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		Thread.sleep(500);

	}
	
	public void Wait_method(int w) throws InterruptedException {
		
		Thread.sleep(w);
	}

	public void select(String value, By element) {
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();

	}

	public void scrolltoelement(By element) throws InterruptedException {
		Thread.sleep(200);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		Thread.sleep(200);
	}
	
	public void scrolltotop() throws InterruptedException {
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		Thread.sleep(4000);
	}
	
	public void scrolltoend() throws InterruptedException {
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(4000);
	}
	
	public void scrolltomiddle() throws InterruptedException {
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
		Thread.sleep(4000);
	}

	
	public void Mouse_hover(By element) throws Exception {
		
		
		//Creating object of an Actions class
				Actions action = new Actions(driver);

				//Performing the mouse hover action on the target element.
				action.moveToElement(driver.findElement(element)).perform();
				Thread.sleep(200);
	}
	
	
public void upload_file(By upload_btn, String file_path) throws Exception {
	
	Element_isdisplayed(upload_btn);
	MoveToElement_and_click(upload_btn);
	Log.info("Successfully clicked on Choose file/ upload file input button");
	ExtentTestManager.getTest().log(Status.PASS, "Successfully clicked on Choose file/upload file input button");

//	driver.findElement(upload_btn).click();
	Thread.sleep(500);
	String path = System.getProperty("user.dir");
//	System.out.println(Sample resume doc.pdf");
	String project_path_and_file_path= path+"\\src\\test\\resources\\"+file_path;
	
	StringSelection s = new StringSelection(project_path_and_file_path);
//    Clipboard copy
   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
   Robot r = new Robot();
   //pressing enter
//   r.keyPress(KeyEvent.VK_ENTER);
   //releasing enter
//   r.keyRelease(KeyEvent.VK_ENTER);
   Thread.sleep(2000);
   //pressing ctrl+v
   r.keyPress(KeyEvent.VK_CONTROL);
   r.keyPress(KeyEvent.VK_V);
   //releasing ctrl+v
   r.keyRelease(KeyEvent.VK_CONTROL);
   r.keyRelease(KeyEvent.VK_V);
   Thread.sleep(2000);
   //pressing enter
   r.keyPress(KeyEvent.VK_ENTER);
   //releasing enter
   r.keyRelease(KeyEvent.VK_ENTER);
   
   Log.info("Successfully entered the upload file path and clicked on Enter key");
	ExtentTestManager.getTest().log(Status.PASS, "Successfully entered the upload file path and clicked on Enter key");
   Thread.sleep(2000);

      
}
	
	public void keypress(int KeyEvent) throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent);
	}
	
	
	
	
	public void Change_Brand(String Brand_name) throws Exception {
		
//		String admin_url="https://test2.lafitness.com/Pages/admin.aspx";
		
		By brand_btn=By.id("btnBrand");
		
		By eidt=By.id("lnkEditBrand");
		By brand_dropdown=By.id("ddlBrand");
		By update_btn=By.id("btnUpdateBrand");
		By app_settings=By.id("btnConfiguration");
		By reset_app_settings=By.id("btnResetAppSettings");
		By cache_btn=By.id("btnCache");
		By ClearCache_btn=By.id("btnClearCache");
		By CurrentBrand_name=By.id("pnlCurrentBrand");
		
		
		String admin_page_title="Admin Page";
//		driver.get(admin_url);
//		Thread.sleep(300);
	

		String title=driver.getTitle();
		Assert.assertEquals(title.toUpperCase().trim(), admin_page_title.toUpperCase().trim(), "Admin page title not validated");
		Log.info(title+" title successfully displayed, validated and navigated to "+title +"page ");
		ExtentTestManager.getTest().log(Status.PASS, title+" title successfully displayed, validated and navigated to "+title +"page ");
		
		Element_isdisplayed(brand_btn);
		click(brand_btn);
		Log.info("Successfully clicked on Brand button");
		ExtentTestManager.getTest().log(Status.PASS, "Successfully clicked on Brand button");
		
		Element_isdisplayed(eidt);
		click(eidt);
		Log.info("Successfully clicked on eidt link");
		ExtentTestManager.getTest().log(Status.PASS, "Successfully clicked on eidt link");
		
		Element_isdisplayed(brand_dropdown);
		Select brand_dd=new Select(driver.findElement(brand_dropdown));
		
		String selected_brand= brand_dd.getFirstSelectedOption().toString();
		
		if(selected_brand.toUpperCase().trim().equalsIgnoreCase(Brand_name.toUpperCase().trim())) {
			
			Log.info(Brand_name+" is already selected");
			ExtentTestManager.getTest().log(Status.PASS, Brand_name+" is already selected");
			
		}
		else {
			brand_dd.selectByVisibleText(Brand_name.trim());
			Element_isdisplayed(update_btn);
			click(update_btn);
			Thread.sleep(200);
			driver.switchTo().alert().accept();
			Thread.sleep(200);
			Element_isdisplayed(CurrentBrand_name);
			String current_brand_name=driver.findElement(CurrentBrand_name).getText();
			if(current_brand_name.toUpperCase().trim().contains(Brand_name.toUpperCase().trim()))
			{
			Log.info(Brand_name+" is selected and updated successfully");
			ExtentTestManager.getTest().log(Status.PASS, Brand_name+" is selected and updated successfully");
			}
			else if (current_brand_name.toUpperCase().trim().contains(Brand_name.replace("ClubStudioFitness", "Club Studio Fitness").toUpperCase().trim())) {
				
				Log.info(Brand_name+" is selected and updated successfully");
				ExtentTestManager.getTest().log(Status.PASS, Brand_name+" is selected and updated successfully");
			}
			else {
				throw new Exception(Brand_name+" is not selected");
			}
			
		}
		
		Element_isdisplayed(app_settings);
		click(app_settings);
		Log.info("Successfully clicked on app settings button");
		ExtentTestManager.getTest().log(Status.PASS, "Successfully clicked on app settings button");
		
		Element_isdisplayed(reset_app_settings);
		click(reset_app_settings);
		Log.info("Successfully clicked on reset app settings button");
		ExtentTestManager.getTest().log(Status.PASS, "Successfully clicked on reset app settings button");
		
		Element_isdisplayed(cache_btn);
		click(cache_btn);
		Log.info("Successfully clicked on cache button");
		ExtentTestManager.getTest().log(Status.PASS, "Successfully clicked on cache button");
		Element_isdisplayed(ClearCache_btn);
		click(ClearCache_btn);
		Log.info("Successfully clicked on clear cache button");
		ExtentTestManager.getTest().log(Status.PASS, "Successfully clicked on clear cache button");
		Thread.sleep(100);
		
		
	}

	public void keyrelease(int KeyEvent) throws Throwable {
		Robot r = new Robot();
		r.keyRelease(KeyEvent);
	}

	

public void captcha() throws Exception {
	
//	By dd=By.id("ctl00_MainContent_MembershipReviewInfo1_txtIAgree");
//	String Fullname=F_name+" "+L_name;
//	input(dd, Fullname);
	
	Thread.sleep(100);
	WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(30));
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
	        By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));

	wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//div[@class='recaptcha-checkbox-border']"))).click();

	Thread.sleep(100);
	driver.switchTo().defaultContent();
	By d=By.id("ctl00_MainContent_MembershipReviewInfo1_imgSubmit");
	click(d);

}

public void select_dropdown(By dropdown, String dropdown_value, String dropdown_name) throws Exception {
	Element_isdisplayed(dropdown);
	ExtentTestManager.getTest().log(Status.PASS, dropdown_name+ "dropdown displayed successfully" );
	Log.info(dropdown_name+ "dropdown displayed successfully");
	
	Select select = new Select(driver.findElement(dropdown)); 
	select.selectByVisibleText(dropdown_value);
	ExtentTestManager.getTest().log(Status.PASS, dropdown_value+" selected successfully in "+dropdown_name+" dropdwon");
	Log.info(dropdown_value+" selected successfully in "+dropdown_name+" dropdwon");
}

	public void PopUp_Authentication() throws Throwable {

		Robot r = new Robot();
		//First Login
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_D);
		r.keyRelease(KeyEvent.VK_D);
		r.keyPress(KeyEvent.VK_M);
		r.keyRelease(KeyEvent.VK_M);
		r.keyPress(KeyEvent.VK_I);
		r.keyRelease(KeyEvent.VK_I);
		r.keyPress(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_N);
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_D);
		r.keyRelease(KeyEvent.VK_D);
		r.keyPress(KeyEvent.VK_M);
		r.keyRelease(KeyEvent.VK_M);
		r.keyPress(KeyEvent.VK_I);
		r.keyRelease(KeyEvent.VK_I);
		r.keyPress(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_N);
		
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
		
		//Second Login
/*		Thread.sleep(15000);	
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_D);
		r.keyRelease(KeyEvent.VK_D);
		r.keyPress(KeyEvent.VK_M);
		r.keyRelease(KeyEvent.VK_M);
		r.keyPress(KeyEvent.VK_I);
		r.keyRelease(KeyEvent.VK_I);
		r.keyPress(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_N);
	
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_D);
		r.keyRelease(KeyEvent.VK_D);
		r.keyPress(KeyEvent.VK_M);
		r.keyRelease(KeyEvent.VK_M);
		r.keyPress(KeyEvent.VK_I);
		r.keyRelease(KeyEvent.VK_I);
		r.keyPress(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_N);
		
				
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);*/
		
		
	}
	public void KeyPress_AllProducts__WindowTypeTopDischarge() throws Throwable {

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_RIGHT);
		r.keyRelease(KeyEvent.VK_RIGHT);
		r.keyPress(KeyEvent.VK_RIGHT);
		r.keyRelease(KeyEvent.VK_RIGHT);
		r.keyPress(KeyEvent.VK_RIGHT);
		r.keyRelease(KeyEvent.VK_RIGHT);
		r.keyPress(KeyEvent.VK_RIGHT);
		r.keyRelease(KeyEvent.VK_RIGHT);

	}

	public void KeyPress_AllProducts__CarrierWindowTypeAirconInverter() throws Throwable {

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	
	public static String convert_month_to_number(String month) {

		switch(month) {
	    case "January":
	    case "january":
	    case "jan":
	    case "Jan":
	    	month = "01";
	    break;

	    case "febuary":
	    case "feb":
	    case "Febuary":
	    case "Feb":
	    	month = "02";
	    break;

	    case "march":
	    case "mar":
	    case "March":
	    case "Mar":
	    	month = "03";
	    break;

	    case "april":
	    case "apr":
	    case "April":
	    case "Apr":
	    	month = "04";
	    break;

	    case "may":
	    case "May":
	    	month = "05";
	    break;

	    case "june":
	    case "jun":
	    case "June":
	    case "Jun":
	    	month = "06";
	    break;

	    case "july":
	    case "jul":
	    case "July":
	    case "Jul":
	    	month = "07";
	    break;

	    case "august":
	    case "aug":
	    case "August":
	    case "Aug":
	    	month = "08";
	    break;

	    case "september":
	    case "sep":
	    case "sept":
	    case "September":
	    case "Sep":
	    case "Sept":
	    	month = "09";
	    break;

	    case "october":
	    case "oct":
	    case "October":
	    case "Oct":
	    	month = "10";
	    break;

	    case "november":
	    case "nov":
	    case "November":
	    case "Nov":
	    	month = "11";
	    break;

	    case "december":
	    case "dec":
	    case "December":
	    case "Dec":
	    	month = "12";
	    break;
	    }
		
		return month;
		
	}

	
	
	public String convert_to_tel_number(String number) {
		String tel_number = number.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
		return tel_number;
	}
	

	public String Get_todays_date_pus_1month(String dateformatter) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateformatter);  
//		   LocalDateTime now = LocalDateTime.now();
		 LocalDate now = LocalDate.now().plusMonths(1);
		   String date=dtf.format(now);
		   return date;
	}

    public static String convert_day_to_fulldayname(String day) {

		switch(day) {
	    case "Mon":
	    case "mon":
	    
	    	day = "Monday";
	    break;

	    case "Tue":
	    case "tue":
	   
	    	day = "Tuesday";
	    break;

	    case "Wed":
	    case "wed":
	    
	    	day = "Wednesday";
	    break;

	    case "Thu":
	    case "thu":
	    
	    	day = "Thursday";
	    break;

	    case "Fri":
	    case "fri":
	    	day = "Friday";
	    break;

	    case "Sat":
	    case "sat":
	   
	    	day = "Saturday";
	    break;

	    case "Sun":
	    case "sun":
	   
	    	day = "Sunday";
	    break;

	    
	    }
		
		return day;
		
	}

    public static String convert_month_to_monthname(String month) {

		switch(month) {
	    case "jan":
	    case "Jan":
	    	month = "January";
	    break;

	 
	    case "feb":
	    case "Feb":
	    	month = "February";
	    break;

	   
	    case "mar":
	   
	    case "Mar":
	    	month = "March";
	    break;

	   
	    case "apr":
	 
	    case "Apr":
	    	month = "April";
	    break;

	    case "may":
	    case "May":
	    	month = "May";
	    	
	    break;

	  
	    case "jun":
	
	    case "Jun":
	    	month = "June";
	    break;

	  
	    case "jul":
	  
	    case "Jul":
	    	month = "July";
	    break;

	  
	    case "aug":
	
	    case "Aug":
	    	month = "August";
	    break;

	  
	    case "sep":
	    
	
	    case "Sep":
	 
	    	month = "September";
	    break;

	  
	    case "oct":
	   
	    case "Oct":
	    	month = "October";
	    break;

	 
	    case "nov":
	 
	    case "Nov":
	    	month = "November";
	    break;

	
	    case "dec":
	  
	    case "Dec":
	    	month = "December";
	    break;
	    }
		
		return month;
		
	}


	public String Get_todays_date() {
		
		java.util.Date date = new java.util.Date();  
		String[] date_fields=date.toString().split(" ");
		String day=date_fields[0]; 
		String month=date_fields[1]; 
		String day_no=date_fields[2].replaceAll("^0*", ""); 
		String year=date_fields[5]; 
		
		String Date_exact= convert_day_to_fulldayname(day).trim()+", "+convert_month_to_monthname(month).trim()+" "+day_no+", "+year+".";
//		System.out.println(Date_exact);
		return Date_exact;
	}
	
	public String GetCurrentURL()
	{
		String currentURL = driver.getCurrentUrl();
		
		return currentURL;
	}
	
	public boolean IsElementDisplayed(By element) throws Exception {
		try {

			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
			Assert.assertTrue(wait2.until(ExpectedConditions.presenceOfElementLocated(element)).isDisplayed());
			Thread.sleep(100);
			return driver.findElement(element).isDisplayed();
	
		} catch (Exception e) {
			String stackTrace = Throwables.getStackTraceAsString(e);
			Log.error( stackTrace);
			throw new Exception("Element: "+ element +" is not displayed");
			
		}
		catch (AssertionError e) {
			String stackTrace = Throwables.getStackTraceAsString(e);
			Log.error( stackTrace);
			throw new Exception("Element: "+ element +" is not displayed");
		}
		
		
	}
	
	public void waitForElementClickable(By element) {
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();

	}
	
	
	}


































